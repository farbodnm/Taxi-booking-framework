package com.taxi.framework.user.repository;

import com.taxi.framework.user.dao.UserDao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AbstractUserRepository extends JpaRepository<UserDao, Long> {

}