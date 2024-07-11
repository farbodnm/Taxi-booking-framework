package com.taxi.notification.repository;

import com.taxi.framework.notification.model.PushNotification;
import com.taxi.framework.notification.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PushNotificationRepository extends JpaRepository<PushNotification, Long> {
    List<PushNotification> findByUser(User user);
}
