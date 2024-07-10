package com.taxi.user.repository;

import com.taxi.framework.user.dao.DriverDao;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface DriverRepository extends UserRepository<DriverDao> {
    @Modifying
    @Transactional
    @Query("UPDATE DriverDao u SET u.signInStatus = :status WHERE u.username = :username OR u.email = :email OR u.phone = :phone")
    void updateSignInStatusByUsername(@Param("username") String username, @Param("email") String email, @Param("phone") String phone, @Param("status") String status);

    @Modifying
    @Transactional
    @Query("UPDATE DriverDao u SET u.signInStatus = :status WHERE u.id = :id")
    void updateSignInStatusByID(@Param("id") Long id, @Param("status") String status);
}
