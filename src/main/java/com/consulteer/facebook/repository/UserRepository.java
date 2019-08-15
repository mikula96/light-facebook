package com.consulteer.facebook.repository;

import com.consulteer.facebook.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT user FROM User user WHERE user.name = ?1")
    User findByUsername(String username);

    User findUserByEmail(String email);

}
