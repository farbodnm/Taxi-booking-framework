package com.taxi.framework.feedback.repository;

import com.taxi.framework.commons.dao.User;
import com.taxi.framework.feedback.dao.DriverFeedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DriverFeedbackRepository extends JpaRepository<DriverFeedback, Long> {
    List<DriverFeedback> findByFeedbackReceiverDriver(User feedbackReceiverDriver);

}
