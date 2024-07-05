package com.taxi.framework.feedback.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BaseDriverFeedbackResponseDto {
    private Long id;
    private Long feedbackGiverUserId;
    private Long feedbackReceiverDriverId;
    private int rating;
    private String comments;
    private String createdAt;
}
