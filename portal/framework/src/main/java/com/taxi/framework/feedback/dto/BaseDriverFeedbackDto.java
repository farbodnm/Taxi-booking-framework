package com.taxi.framework.feedback.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class BaseDriverFeedbackDto {
    private Long feedbackGiverUserId;
    private Long feedbackReceiverDriverId;
    private int rating;
    private String comments;
    private List<DriverFeedbackOption> feedbackOptions;

}
