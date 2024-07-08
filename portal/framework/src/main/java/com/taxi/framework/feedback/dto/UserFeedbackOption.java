package com.taxi.framework.feedback.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
public enum UserFeedbackOption {
    // Positive feedback
    POLITE("Polite", true),
    TIMELY("Timely", true),
    GOOD_COMMUNICATION("Good communication", true),

    // Negative feedback
    RUDE("Rude", false),
    LATE("Late", false),
    NO_SHOW("No show", false),
    INTOXICATED("Intoxicated", false);

    private final String description;
    private final boolean isPositive;

    UserFeedbackOption(String description, boolean isPositive) {
        this.description = description;
        this.isPositive = isPositive;
    }
    public boolean isPositive() {
        return isPositive;
    }
}
