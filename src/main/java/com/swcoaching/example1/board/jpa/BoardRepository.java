package com.swcoaching.example1.board.jpa;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BoardRepository extends CrudRepository<BoardEntity, Long> {
    // JPQL
    @Query("SELECT b FROM BoardEntity  b ORDER BY b.id ASC ")
    List<BoardEntity> findAllDesc();
}
