package com.salarylupin.server.unit.magicbook;

import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.TEXT_PLAIN;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.salarylupin.server.magicbook.MagicBookController;
import com.salarylupin.server.magicbook.MagicBookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

@WebMvcTest(MagicBookController.class)
@AutoConfigureRestDocs(outputDir = "build/generated-snippets")
class MagicBookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private MagicBookService magicBookService;

    @Test
    void magicBookSuccess() throws Exception {
        //given
        String expect = "Random Answer";

        // when
        when(magicBookService.getRandomAnswer())
            .thenReturn(expect);

        ResultActions result = mockMvc.perform(get("/magic-book/answer"));

        // then
        result.andExpectAll(
            status().isOk(),
            content().contentTypeCompatibleWith(TEXT_PLAIN),
            content().string(expect)
        ).andDo(document("magicbook-answer"));
    }
}