package com.salarylupin.server.magicbook;

import org.springframework.stereotype.Service;

@Service
public class MagicBookService {

    public MagicBookResponseDTO getRandomAnswer() {
        return new MagicBookResponseDTO("Random answer");
    }
}
