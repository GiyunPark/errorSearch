package com.giyun.errorsearch.repository;

import com.giyun.errorsearch.domain.Board;
import com.giyun.errorsearch.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
    Board findByUser(User user);
}
