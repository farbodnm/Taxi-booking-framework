package com.taxi.user.repository;

import com.taxi.framework.user.dao.UserDao;
import com.taxi.framework.user.repository.AbstractUserRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends AbstractUserRepository {
    Optional<UserDao> findByUsername(String username);
}
