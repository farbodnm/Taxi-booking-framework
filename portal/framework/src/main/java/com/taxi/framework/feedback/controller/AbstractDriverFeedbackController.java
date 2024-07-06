package com.taxi.framework.feedback.controller;

import com.taxi.framework.feedback.service.AbstractDriverFeedbackServiceImpl;
import com.taxi.framework.feedback.dto.BaseDriverFeedbackDto;
import com.taxi.framework.feedback.dto.BaseDriverFeedbackResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;

public abstract class AbstractDriverFeedbackController<T extends BaseDriverFeedbackDto, Y extends BaseDriverFeedbackResponseDto> {
    private final AbstractDriverFeedbackServiceImpl<T, Y> feedbackService;

    protected AbstractDriverFeedbackController(AbstractDriverFeedbackServiceImpl<T, Y> feedbackService) {
        this.feedbackService = feedbackService;
    }

    @PostMapping
    public ResponseEntity<Y> submitFeedback(@RequestBody T dto) {
        return ResponseEntity.ok(feedbackService.saveFeedback(dto));
    }

    @GetMapping("/{userId}/average-rating")
    public ResponseEntity<Map<String, BigDecimal>> getAverageRating(@PathVariable Long userId) {
        Optional<BigDecimal> averageRating = feedbackService.getAverageRating(userId);
        return averageRating
                .map(rating -> ResponseEntity.ok(Collections.singletonMap("averageRating", rating)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
