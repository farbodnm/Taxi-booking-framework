package com.taxi.feedback.service;

import com.taxi.framework.feedback.repository.DriverFeedbackRepository;
import com.taxi.framework.feedback.repository.FeedbackOptionRepository;
import com.taxi.framework.feedback.repository.UserDaoRepository;
import com.taxi.framework.commons.dao.User;
import com.taxi.framework.feedback.dao.DriverFeedback;
import com.taxi.framework.feedback.dao.FeedbackOption;
import com.taxi.framework.feedback.dto.*;
import com.taxi.framework.feedback.service.AbstractDriverFeedbackServiceImpl;
import com.taxi.framework.utils.Utilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;

@Service
public class DriverFeedbackServiceImpl extends AbstractDriverFeedbackServiceImpl<BaseDriverFeedbackDto, BaseDriverFeedbackResponseDto> {

    private final DriverFeedbackRepository driverFeedbackRepository;

    private final FeedbackOptionRepository feedbackOptionRepository;

    private final UserDaoRepository userDaoRepository;

    @Autowired
    public  DriverFeedbackServiceImpl(DriverFeedbackRepository driverFeedbackRepository, FeedbackOptionRepository feedbackOptionRepository,
                                      UserDaoRepository userDaoRepository) {
        this.driverFeedbackRepository = driverFeedbackRepository;
        this.feedbackOptionRepository = feedbackOptionRepository;
        this.userDaoRepository = userDaoRepository;
    }
    @Override
    public BaseDriverFeedbackResponseDto createFeedbackResponseDto() {
        return new BaseDriverFeedbackResponseDto();
    }

    @Override
    public BaseDriverFeedbackResponseDto saveFeedback(BaseDriverFeedbackDto dto) {
        DriverFeedback feedback = driverFeedbackRepository.save(mapFeedbackDtoToEntity(dto));
        updateRatedUserNewAverageRating(feedback.getFeedbackReceiverDriver());
        return generateFeedbackSubmissionResponseDto(feedback);
    }

    @Override
    public Optional<BaseDriverFeedbackResponseDto> getFeedbackById(Long id) {
        return driverFeedbackRepository.findById(id).map(this::mapFeedbackEntityToDto);
    }
    @Override
    public Optional<BigDecimal> getAverageRating(Long driverId) {
        Optional<User> userOptional = getRatedDriver(driverId);
        return userOptional.map(User::getAverageRating);
    }
    private DriverFeedback mapFeedbackDtoToEntity(BaseDriverFeedbackDto dto) {
        DriverFeedback feedback = new DriverFeedback();
        feedback.setFeedbackGiverUser(userDaoRepository.findById(dto.getFeedbackGiverUserId()).get());
        feedback.setFeedbackReceiverDriver(userDaoRepository.findById(dto.getFeedbackReceiverDriverId()).get());
        feedback.setRating(dto.getRating());
        feedback.setComments(dto.getComments());
        feedback.setFeedbackOptions(dto.getFeedbackOptions().stream().map(this::mapFeedbackOptionDtoToEntity)
                .toList());
        feedback.setCreatedAt(Utilities.getCurrentDateTime());
        return feedback;
    }

    private BaseDriverFeedbackResponseDto generateFeedbackSubmissionResponseDto(DriverFeedback feedback) {
        BaseDriverFeedbackResponseDto responseDTO = createFeedbackResponseDto();
        responseDTO.setId(feedback.getId());
        responseDTO.setFeedbackGiverUserId(feedback.getFeedbackGiverUser().getId());
        responseDTO.setFeedbackReceiverDriverId(feedback.getFeedbackReceiverDriver().getId());
        responseDTO.setRating(feedback.getRating());
        responseDTO.setComments(feedback.getComments());
        responseDTO.setCreatedAt(Utilities.getCurrentDateTime());
        return responseDTO;
    }
    private FeedbackOption mapFeedbackOptionDtoToEntity (DriverFeedbackOption feedbackOptionDto) {
        FeedbackOption option = new FeedbackOption();
        option.setDescription(feedbackOptionDto.getDescription());
        option.setType(feedbackOptionDto.isPositive() ?
                FeedbackOption.FeedbackOptionType.POSITIVE :
                FeedbackOption.FeedbackOptionType.NEGATIVE);
        feedbackOptionRepository.save(option);
        return option;
    }
    private void updateRatedUserNewAverageRating(User driver) {
        List<DriverFeedback> feedbacks = driverFeedbackRepository.findByFeedbackReceiverDriver(driver);
        BigDecimal averageRating = feedbacks.stream()
                .map(feedback -> BigDecimal.valueOf(feedback.getRating()))
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .divide(BigDecimal.valueOf(feedbacks.size()), 2, RoundingMode.HALF_UP);
        driver.setAverageRating(averageRating);
        userDaoRepository.save(driver);
    }

    private Optional<User> getRatedDriver(Long id) {
        return userDaoRepository.findById(id);
    }

    private BaseDriverFeedbackResponseDto mapFeedbackEntityToDto(DriverFeedback feedback) {
        BaseDriverFeedbackResponseDto responseDTO = createFeedbackResponseDto();
        responseDTO.setId(feedback.getId());
        responseDTO.setFeedbackGiverUserId(feedback.getFeedbackGiverUser().getId());
        responseDTO.setFeedbackReceiverDriverId(feedback.getFeedbackReceiverDriver().getId());
        responseDTO.setRating(feedback.getRating());
        responseDTO.setComments(feedback.getComments());
        responseDTO.setCreatedAt(feedback.getCreatedAt());
        return responseDTO;
    }

}
