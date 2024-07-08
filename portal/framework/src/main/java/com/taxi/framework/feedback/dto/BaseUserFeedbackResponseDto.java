package com.taxi.framework.feedback.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BaseUserFeedbackResponseDto {
    private Long id;
    private Long feedbackGiverDriverId;
    private Long feedbackReceiverUserId;
    private int rating;
    private String comments;
    private String createdAt;
}
