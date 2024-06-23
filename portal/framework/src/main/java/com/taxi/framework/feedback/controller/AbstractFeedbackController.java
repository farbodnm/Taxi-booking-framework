package com.taxi.framework.feedback.controller;

import com.taxi.framework.feedback.service.AbstractFeedbackServiceImpl;
import com.taxi.framework.feedback.dto.BaseFeedbackDTO;
import com.taxi.framework.feedback.dto.BaseFeedbackResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public abstract class AbstractFeedbackController<T extends BaseFeedbackDTO, Y extends BaseFeedbackResponseDTO> {
    protected final AbstractFeedbackServiceImpl<T, Y> feedbackService;

    protected AbstractFeedbackController(AbstractFeedbackServiceImpl<T, Y> feedbackService) {
        this.feedbackService = feedbackService;
    }

    @PostMapping("/feedback")
    public ResponseEntity<Y> feedback(@RequestBody T dto) {
        return ResponseEntity.ok(feedbackService.saveFeedback(dto));
    }

    @GetMapping("/feedback/{id}")
    public ResponseEntity<Y> getFeedback(@PathVariable Long id) {
        return ResponseEntity.ok(feedbackService.getFeedback(id));
    }

    @PutMapping("/feedback/{id}")
    public ResponseEntity<Y> updateFeedback(@PathVariable Long id, @RequestBody T dto) {
        return ResponseEntity.ok(feedbackService.updateFeedback(id, dto));
    }

    @DeleteMapping("/feedback/{id}")
    public ResponseEntity<Void> deleteFeedback(@PathVariable Long id) {
        feedbackService.deleteFeedback(id);
        return ResponseEntity.noContent().build();
    }
}
