package com.taxi.feedback.controller;

import com.taxi.feedback.service.UserFeedbackServiceImpl;
import com.taxi.framework.commons.dao.UserDao;
import com.taxi.framework.feedback.controller.AbstractUserFeedbackController;
import com.taxi.framework.feedback.dto.BaseUserFeedbackDto;
import com.taxi.framework.feedback.dto.BaseUserFeedbackResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Optional;

@RequestMapping("/api/user-feedback")
@RestController
public class UserFeedbackControllerImpl extends AbstractUserFeedbackController<BaseUserFeedbackDto, BaseUserFeedbackResponseDto> {
    private UserFeedbackServiceImpl feedbackService;

    @Autowired
    protected UserFeedbackControllerImpl(UserFeedbackServiceImpl feedbackService) {
        super(feedbackService);
    }
    @GetMapping("/{userId}/average-rating")
    public ResponseEntity<String> getAverageRating(@PathVariable Long userId) {
        Optional<UserDao> userOptional = feedbackService.getRatedUser(userId);

        if (userOptional.isPresent()) {
            BigDecimal averageRating = userOptional.get().getAverageRating();
            return ResponseEntity.ok("Average Rating: " + averageRating);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
