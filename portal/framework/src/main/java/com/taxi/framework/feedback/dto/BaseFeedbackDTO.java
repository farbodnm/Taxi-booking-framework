package com.taxi.framework.feedback.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BaseFeedbackDTO {
    private Long userId;
    private Long driverId;
    private int rating;
    private String comments;
}
