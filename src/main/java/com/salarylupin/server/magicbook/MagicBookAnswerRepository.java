package com.salarylupin.server.magicbook;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MagicBookAnswerRepository extends JpaRepository<MagicBookAnswerEntity, Integer> {

    @Query(value = "SELECT * FROM magic_book_answer ORDER BY RAND() LIMIT 1", nativeQuery = true)
    MagicBookAnswerEntity findRandomAnswer();
}
