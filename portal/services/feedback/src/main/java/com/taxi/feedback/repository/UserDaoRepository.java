package com.taxi.feedback.repository;

import com.taxi.framework.commons.dao.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDaoRepository extends JpaRepository<User, Long> {
}
