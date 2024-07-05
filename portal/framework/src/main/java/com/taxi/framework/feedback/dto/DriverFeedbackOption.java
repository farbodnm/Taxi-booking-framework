package com.taxi.framework.feedback.dto;

import lombok.Getter;

@Getter
public enum DriverFeedbackOption {
    // Positive feedback
    SAFE_DRIVER("Safe driver", true),
    POLITE("Polite", true),
    CLEAN_CAR("Clean car", true),
    GOOD_NAVIGATION("Good navigation", true),

    // Negative feedback
    DANGEROUS_DRIVER("Dangerous driver", false),
    NO_AC("No A/C", false),
    RUDE("Rude", false),
    LATE("Late", false);

    private final String description;
    private final boolean isPositive;

    DriverFeedbackOption(String description, boolean isPositive) {
        this.description = description;
        this.isPositive = isPositive;
    }

    public boolean isPositive() {
        return isPositive;
    }
}

