package com.salarylupin.server.magicbook;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/magic-book")
public class MagicBookController {

    @GetMapping("/answer")
    public String magicBook() {
        return "Magic Book";
    }
}
