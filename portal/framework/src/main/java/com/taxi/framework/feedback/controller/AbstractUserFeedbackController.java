package com.taxi.framework.feedback.controller;

import com.taxi.framework.feedback.service.AbstractUserFeedbackServiceImpl;
import com.taxi.framework.feedback.dto.BaseUserFeedbackDto;
import com.taxi.framework.feedback.dto.BaseUserFeedbackResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public abstract class AbstractUserFeedbackController<T extends BaseUserFeedbackDto, Y extends BaseUserFeedbackResponseDto> {
    protected final AbstractUserFeedbackServiceImpl<T, Y> feedbackService;

    protected AbstractUserFeedbackController(AbstractUserFeedbackServiceImpl<T, Y> feedbackService) {
        this.feedbackService = feedbackService;
    }

    @PostMapping
    public ResponseEntity<Y> submitFeedback(@RequestBody T dto) {
        return ResponseEntity.ok(feedbackService.saveFeedback(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Y> getFeedback(@PathVariable Long id) {
        return ResponseEntity.ok(feedbackService.getFeedback(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Y> updateFeedback(@PathVariable Long id, @RequestBody T dto) {
        return ResponseEntity.ok(feedbackService.updateFeedback(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFeedback(@PathVariable Long id) {
        feedbackService.deleteFeedback(id);
        return ResponseEntity.noContent().build();
    }
}
