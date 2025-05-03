package com.salarylupin.server.unit.magicbook;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.salarylupin.server.magicbook.MagicBookAnswerEntity;
import com.salarylupin.server.magicbook.MagicBookAnswerRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@DisplayName("[마법의 고민해결 책] Repository")
class MagicBookAnswerRepositoryTest {

    @Autowired
    private MagicBookAnswerRepository magicBookAnswerRepository;

    @Test
    @DisplayName("[성공] 무작위 응답 가져오기")
    void 성공_무작위_응답_가져오기() {
        // given
        magicBookAnswerRepository.save(new MagicBookAnswerEntity("Random Answer 1"));
        magicBookAnswerRepository.save(new MagicBookAnswerEntity("Random Answer 2"));

        // when & then
        MagicBookAnswerEntity actual = magicBookAnswerRepository.findRandomAnswer();
        assertAll(
            () -> assertNotNull(actual),
            () -> assertTrue(
                actual.getAnswer().equals("Random Answer 1")
                    || actual.getAnswer().equals("Random Answer 2")
            )
        );
    }
}