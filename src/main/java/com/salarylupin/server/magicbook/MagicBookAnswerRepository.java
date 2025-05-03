package com.salarylupin.server.magicbook;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MagicBookAnswerRepository extends JpaRepository<MagicBookAnswerEntity, Integer> {

}
