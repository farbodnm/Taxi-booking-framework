package com.taxi.notification.repository;

import com.taxi.framework.notification.model.EmailNotification;
import com.taxi.framework.notification.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmailNotificationRepository extends JpaRepository<EmailNotification, Long> {
    List<EmailNotification> findByUser(User user);
}
