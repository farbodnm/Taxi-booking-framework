package com.taxi.framework.feedback.controller;

import com.taxi.framework.feedback.service.AbstractUserFeedbackServiceImpl;
import com.taxi.framework.feedback.dto.BaseUserFeedbackDto;
import com.taxi.framework.feedback.dto.BaseUserFeedbackResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;

public abstract class AbstractUserFeedbackController<T extends BaseUserFeedbackDto, Y extends BaseUserFeedbackResponseDto> {
    private final AbstractUserFeedbackServiceImpl<T, Y> feedbackService;

    protected AbstractUserFeedbackController(AbstractUserFeedbackServiceImpl<T, Y> feedbackService) {
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
