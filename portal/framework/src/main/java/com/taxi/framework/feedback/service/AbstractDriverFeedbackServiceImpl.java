package com.taxi.framework.feedback.service;

import com.taxi.framework.feedback.dto.BaseDriverFeedbackDto;
import com.taxi.framework.feedback.dto.BaseDriverFeedbackResponseDto;
import com.taxi.framework.utils.Utilities;

public abstract class AbstractDriverFeedbackServiceImpl<B extends BaseDriverFeedbackDto, R extends BaseDriverFeedbackResponseDto> implements DriverFeedbackService<B, R> {

    @Override
    public R saveFeedback(B dto) {
        R baseFeedbackResponseDTO = createFeedbackResponseDto();
        baseFeedbackResponseDTO.setId(1L);
        baseFeedbackResponseDTO.setFeedbackGiverUserId(dto.getFeedbackGiverUserId());
        baseFeedbackResponseDTO.setFeedbackReceiverDriverId(dto.getFeedbackReceiverDriverId());
        baseFeedbackResponseDTO.setRating(dto.getRating());
        baseFeedbackResponseDTO.setComments(dto.getComments());
        baseFeedbackResponseDTO.setCreatedAt(Utilities.getCurrentDateTime());
        return baseFeedbackResponseDTO;
    }
    @Override
    public R getFeedback(Long id) {
        return null;

    }

    @Override
    public R updateFeedback(Long id, B dto) {
        return null;
    }

    @Override
    public void deleteFeedback(Long id) {

    }
    protected abstract R createFeedbackResponseDto();


}
