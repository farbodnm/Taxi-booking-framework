package com.taxi.feedback.repository;

import com.taxi.framework.commons.dao.UserDao;
import com.taxi.framework.feedback.dao.UserFeedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserFeedbackRepository extends JpaRepository<UserFeedback, Long> {
    List<UserFeedback> findByFeedbackReceiverUser(UserDao feedbackReceiverUser);

}
