package com.taxi.feedback.service;

import com.taxi.feedback.repository.FeedbackOptionRepository;
import com.taxi.feedback.repository.UserDaoRepository;
import com.taxi.feedback.repository.UserFeedbackRepository;
import com.taxi.framework.commons.dao.UserDao;
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
import java.util.stream.Collectors;

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
        updateRatedUserNewAverageRating(feedback.getFeedbackReceiverUser(), new BigDecimal(dto.getRating()));
        return generateFeedbackSubmissionResponseDto(feedback);
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
                .collect(Collectors.toList()));
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

    private void updateRatedUserNewAverageRating(UserDao user, BigDecimal newRating) {
        List<UserFeedback> previousFeedbacks = userFeedbackRepository.findByFeedbackReceiverUser(user);
        BigDecimal totalRating = previousFeedbacks.stream()
                .map(feedback -> BigDecimal.valueOf(feedback.getRating()))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        totalRating = totalRating.add(newRating);
        int numberOfFeedbacks = previousFeedbacks.size() + 1;
        BigDecimal averageRating = totalRating.divide(BigDecimal.valueOf(numberOfFeedbacks), 2, RoundingMode.HALF_UP);
        user.setAverageRating(averageRating);
        userDaoRepository.save(user);
    }
    public Optional<UserDao> getRatedUser(Long id) {
        return userDaoRepository.findById(id);
    }

}
