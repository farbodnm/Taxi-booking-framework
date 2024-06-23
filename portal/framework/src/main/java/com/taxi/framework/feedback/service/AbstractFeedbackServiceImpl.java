package com.taxi.framework.feedback.service;

import com.taxi.framework.feedback.dto.BaseFeedbackDTO;
import com.taxi.framework.feedback.dto.BaseFeedbackResponseDTO;
import com.taxi.framework.utils.Utilities;

public abstract class AbstractFeedbackServiceImpl <B extends BaseFeedbackDTO, R extends BaseFeedbackResponseDTO> implements FeedbackService<B, R>{

    @Override
    public R saveFeedback(B dto) {
        R baseFeedbackResponseDTO = createBookedRequestDTO();
        baseFeedbackResponseDTO.setId(1L);
        baseFeedbackResponseDTO.setUserId(dto.getUserId());
        baseFeedbackResponseDTO.setDriverId(dto.getDriverId());
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
    protected abstract R createBookedRequestDTO();


}
