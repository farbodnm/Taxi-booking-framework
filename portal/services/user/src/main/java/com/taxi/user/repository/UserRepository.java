package com.taxi.user.repository;

import com.taxi.framework.user.dao.UserDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

@NoRepositoryBean
public interface UserRepository<T extends UserDao> extends JpaRepository<T, Long> {
    T findFirstByUsernameOrEmailOrPhone(String username, String email, String phone);
    @Modifying
    void updateSignInStatusByUsername(@Param("username") String username, @Param("email") String email, @Param("phone") String phone, @Param("status") String status);

    @Modifying
    void updateSignInStatusByID(@Param("id") Long id, @Param("status") String status);
}
