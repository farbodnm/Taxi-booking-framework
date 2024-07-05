package com.taxi.feedback.repository;

import com.taxi.framework.feedback.dao.FeedbackOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackOptionRepository extends JpaRepository<FeedbackOption, Long> {
}
