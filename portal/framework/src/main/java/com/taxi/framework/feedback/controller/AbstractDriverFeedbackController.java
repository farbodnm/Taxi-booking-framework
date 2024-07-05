package com.taxi.framework.feedback.controller;

import com.taxi.framework.feedback.service.AbstractDriverFeedbackServiceImpl;
import com.taxi.framework.feedback.dto.BaseDriverFeedbackDto;
import com.taxi.framework.feedback.dto.BaseDriverFeedbackResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public abstract class AbstractDriverFeedbackController<T extends BaseDriverFeedbackDto, Y extends BaseDriverFeedbackResponseDto> {
    protected final AbstractDriverFeedbackServiceImpl<T, Y> feedbackService;

    protected AbstractDriverFeedbackController(AbstractDriverFeedbackServiceImpl<T, Y> feedbackService) {
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
