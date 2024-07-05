package com.taxi.feedback.controller;

import com.taxi.feedback.service.DriverFeedbackServiceImpl;
import com.taxi.framework.commons.dao.UserDao;
import com.taxi.framework.feedback.controller.AbstractDriverFeedbackController;
import com.taxi.framework.feedback.dto.BaseDriverFeedbackDto;
import com.taxi.framework.feedback.dto.BaseDriverFeedbackResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Optional;

@RequestMapping("/api/driver-feedback")
@RestController
public class DriverFeedbackControllerImpl extends AbstractDriverFeedbackController<BaseDriverFeedbackDto, BaseDriverFeedbackResponseDto> {
    private DriverFeedbackServiceImpl feedbackService;
    @Autowired
    protected DriverFeedbackControllerImpl(DriverFeedbackServiceImpl feedbackService) {
        super(feedbackService);
    }

    @GetMapping("/{userId}/average-rating")
    public ResponseEntity<String> getAverageRating(@PathVariable Long userId) {
        Optional<UserDao> userOptional = feedbackService.getRatedDriver(userId);

        if (userOptional.isPresent()) {
            BigDecimal averageRating = userOptional.get().getAverageRating();
            return ResponseEntity.ok("Average Rating: " + averageRating);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
