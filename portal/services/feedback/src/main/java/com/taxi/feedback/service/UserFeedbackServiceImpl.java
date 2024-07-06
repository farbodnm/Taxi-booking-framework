package com.taxi.feedback.service;

import com.taxi.framework.feedback.repository.FeedbackOptionRepository;
import com.taxi.framework.feedback.repository.UserDaoRepository;
import com.taxi.framework.feedback.repository.UserFeedbackRepository;
import com.taxi.framework.commons.dao.User;
import com.taxi.framework.feedback.dao.FeedbackOption;
import com.taxi.framework.feedback.dao.UserFeedback;
import com.taxi.framework.feedback.dto.BaseUserFeedbackDto;
import com.taxi.framework.feedback.dto.BaseUserFeedbackResponseDto;
import com.taxi.framework.feedback.dto.UserFeedbackOption;
import com.taxi.framework.feedback.service.AbstractUserFeedbackServiceImpl;
import com.taxi.framework.utils.Utilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;

@Service
public class UserFeedbackServiceImpl extends AbstractUserFeedbackServiceImpl<BaseUserFeedbackDto, BaseUserFeedbackResponseDto> {

    private final UserFeedbackRepository userFeedbackRepository;

    private final FeedbackOptionRepository feedbackOptionRepository;

    private final UserDaoRepository userDaoRepository;

    @Autowired
    public UserFeedbackServiceImpl(UserFeedbackRepository userFeedbackRepository, FeedbackOptionRepository feedbackOptionRepository,
                                   UserDaoRepository userDaoRepository) {
        this.userFeedbackRepository = userFeedbackRepository;
        this.feedbackOptionRepository = feedbackOptionRepository;
        this.userDaoRepository = userDaoRepository;
    }

    @Override
    public BaseUserFeedbackResponseDto saveFeedback(BaseUserFeedbackDto dto) {
        UserFeedback feedback = userFeedbackRepository.save(mapFeedbackDtoToEntity(dto));
        updateRatedUserNewAverageRating(feedback.getFeedbackReceiverUser());
        return generateFeedbackSubmissionResponseDto(feedback);
    }
    @Override
    public Optional<BigDecimal> getAverageRating(Long userId) {
        Optional<User> userOptional = getRatedUser(userId);
        return userOptional.map(User::getAverageRating);
    }
    @Override
    public Optional<BaseUserFeedbackResponseDto> getFeedbackById(Long id) {
        return userFeedbackRepository.findById(id).map(this::mapFeedbackEntityToDto);
    }
    @Override
    public BaseUserFeedbackResponseDto createFeedbackResponseDTO() {
        return new BaseUserFeedbackResponseDto();
    }
    private UserFeedback mapFeedbackDtoToEntity(BaseUserFeedbackDto dto) {
        UserFeedback feedback = new UserFeedback();
        feedback.setFeedbackGiverDriver(userDaoRepository.findById(dto.getFeedbackGiverDriverId()).get());
        feedback.setFeedbackReceiverUser(userDaoRepository.findById(dto.getFeedbackReceiverUserId()).get());
        feedback.setRating(dto.getRating());
        feedback.setComments(dto.getComments());
        feedback.setFeedbackOptions(dto.getFeedbackOptions().stream().map(this::mapFeedbackOptionDtoToEntity)
                .toList());
        feedback.setCreatedAt(Utilities.getCurrentDateTime());
        return feedback;
    }

    private BaseUserFeedbackResponseDto generateFeedbackSubmissionResponseDto(UserFeedback feedback) {
        BaseUserFeedbackResponseDto responseDTO = createFeedbackResponseDTO();
        responseDTO.setId(feedback.getId());
        responseDTO.setFeedbackGiverDriverId(feedback.getFeedbackGiverDriver().getId());
        responseDTO.setFeedbackReceiverUserId(feedback.getFeedbackReceiverUser().getId());
        responseDTO.setRating(feedback.getRating());
        responseDTO.setComments(feedback.getComments());
        responseDTO.setCreatedAt(Utilities.getCurrentDateTime());
        return responseDTO;
    }
    private FeedbackOption mapFeedbackOptionDtoToEntity (UserFeedbackOption feedbackOptionDto) {
        FeedbackOption option = new FeedbackOption();
        option.setDescription(feedbackOptionDto.getDescription());
        option.setType(feedbackOptionDto.isPositive() ?
                FeedbackOption.FeedbackOptionType.POSITIVE :
                FeedbackOption.FeedbackOptionType.NEGATIVE);
        feedbackOptionRepository.save(option);
        return option;
    }

    private void updateRatedUserNewAverageRating(User user) {
        List<UserFeedback> feedbacks = userFeedbackRepository.findByFeedbackReceiverUser(user);
        BigDecimal averageRating = feedbacks.stream()
                .map(feedback -> BigDecimal.valueOf(feedback.getRating()))
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .divide(BigDecimal.valueOf(feedbacks.size()), 2, RoundingMode.HALF_UP);
        user.setAverageRating(averageRating);
        userDaoRepository.save(user);
    }
    private Optional<User> getRatedUser(Long id) {
        return userDaoRepository.findById(id);
    }

    private BaseUserFeedbackResponseDto mapFeedbackEntityToDto(UserFeedback feedback) {
        BaseUserFeedbackResponseDto responseDTO = createFeedbackResponseDTO();
        responseDTO.setId(feedback.getId());
        responseDTO.setFeedbackGiverDriverId(feedback.getFeedbackGiverDriver().getId());
        responseDTO.setFeedbackReceiverUserId(feedback.getFeedbackReceiverUser().getId());
        responseDTO.setRating(feedback.getRating());
        responseDTO.setComments(feedback.getComments());
        responseDTO.setCreatedAt(feedback.getCreatedAt());
        return responseDTO;
    }

}
