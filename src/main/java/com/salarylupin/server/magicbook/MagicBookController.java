package com.salarylupin.server.magicbook;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/magic-book")
@RequiredArgsConstructor
public class MagicBookController {

    private final MagicBookService magicBookService;

    @GetMapping("/answer")
    public MagicBookResponseDTO magicBook() {
        return magicBookService.getRandomAnswer();
    }
}
