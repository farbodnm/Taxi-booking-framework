package com.taxi.framework.feedback.dao;

import com.taxi.framework.commons.dao.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "user_feedback")
public class UserFeedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "feedback_giver_driver_id")
    private User feedbackGiverDriver;

    @ManyToOne
    @JoinColumn(name = "feedback_receiver_user_id")
    private User feedbackReceiverUser;

    @Column(name = "rating")
    private int rating;

    @Column(name = "comments")
    private String comments;

    @ManyToMany
    @JoinTable(
            name = "user_feedback_options",
            joinColumns = @JoinColumn(name = "feedback_id"),
            inverseJoinColumns = @JoinColumn(name = "option_id")
    )
    private List<FeedbackOption> feedbackOptions;
}
