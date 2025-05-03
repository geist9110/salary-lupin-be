package com.salarylupin.server.unit.magicbook;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.salarylupin.server.magicbook.MagicBookAnswerEntity;
import com.salarylupin.server.magicbook.MagicBookAnswerRepository;
import com.salarylupin.server.magicbook.MagicBookResponseDTO;
import com.salarylupin.server.magicbook.MagicBookService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
@DisplayName("[마법의 고민해결 책] Service")
class MagicBookServiceTest {

    @InjectMocks
    private MagicBookService magicBookService;

    @Mock
    private MagicBookAnswerRepository magicBookAnswerRepository;

    @Test
    @DisplayName("[성공] 무작위 응답 조회")
    void 성공_무작위_응답_조회() {
        // given
        String expectAnswer = "무작위 응답";
        MagicBookResponseDTO expect = new MagicBookResponseDTO(expectAnswer);
        MagicBookAnswerEntity magicBookAnswerEntity = new MagicBookAnswerEntity(expectAnswer);

        // when
        when(magicBookAnswerRepository.findRandomAnswer()).thenReturn(magicBookAnswerEntity);

        // then
        assertEquals(expect, magicBookService.getRandomAnswer());
    }

}