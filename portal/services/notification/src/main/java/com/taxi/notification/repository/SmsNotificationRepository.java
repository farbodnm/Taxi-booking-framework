package com.taxi.notification.repository;

import com.taxi.framework.notification.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import com.taxi.framework.notification.model.SmsNotification;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SmsNotificationRepository extends JpaRepository<SmsNotification, Long> {
    List<SmsNotification> findByUser(User user);
}
