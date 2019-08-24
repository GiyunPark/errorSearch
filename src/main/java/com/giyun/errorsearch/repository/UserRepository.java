package com.giyun.errorsearch.repository;

import com.giyun.errorsearch.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
