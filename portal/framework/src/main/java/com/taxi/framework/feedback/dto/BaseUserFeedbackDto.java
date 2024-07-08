package com.taxi.framework.feedback.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class BaseUserFeedbackDto {
    private Long feedbackGiverDriverId;
    private Long feedbackReceiverUserId;
    private int rating;
    private String comments;
    private List<UserFeedbackOption> feedbackOptions;

}
