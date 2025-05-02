package com.salarylupin.server.unit.magicbook;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.salarylupin.server.magicbook.MagicBookController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(MagicBookController.class)
@AutoConfigureRestDocs(outputDir = "build/generated-snippets")
class ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void magicBookSuccess() throws Exception {
        mockMvc.perform(get("/magic-book/answer"))
            .andExpect(status().isOk())
            .andDo(document("magicbook-answer"));
    }
}