package com.salarylupin.server.unit.magicbook;

import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.salarylupin.server.magicbook.MagicBookController;
import com.salarylupin.server.magicbook.MagicBookResponseDTO;
import com.salarylupin.server.magicbook.MagicBookService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

@WebMvcTest(MagicBookController.class)
@AutoConfigureRestDocs(outputDir = "build/generated-snippets")
@DisplayName("마법의 고민해결 책")
class MagicBookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    private MagicBookService magicBookService;

    @Test
    @DisplayName("[성공] 무작위 응답")
    void 성공_무작위_응답() throws Exception {
        //given
        MagicBookResponseDTO expect = new MagicBookResponseDTO("Random Answer");

        // when
        when(magicBookService.getRandomAnswer())
            .thenReturn(expect);

        ResultActions result = mockMvc.perform(get("/magic-book/answer"));

        // then
        result.andExpectAll(
            status().isOk(),
            content().contentType(APPLICATION_JSON),
            content().json(objectMapper.writeValueAsString(expect))
        ).andDo(document("magicbook-answer"));
    }
}