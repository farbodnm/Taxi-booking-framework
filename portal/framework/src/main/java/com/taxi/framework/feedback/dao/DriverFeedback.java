package com.taxi.framework.feedback.dao;

import com.taxi.framework.commons.dao.UserDao;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "driver_feedback")
public class DriverFeedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "feedback_giver_user_id")
    private UserDao feedbackGiverUser;

    @ManyToOne
    @JoinColumn(name = "feedback_receiver_driver_id")
    private UserDao feedbackReceiverDriver;

    @Column(name = "rating")
    private int rating;

    @Column(name = "comments")
    private String comments;

    @ManyToMany
    @JoinTable(
            name = "driver_feedback_options",
            joinColumns = @JoinColumn(name = "feedback_id"),
            inverseJoinColumns = @JoinColumn(name = "option_id")
    )
    private List<FeedbackOption> feedbackOptions;
}
