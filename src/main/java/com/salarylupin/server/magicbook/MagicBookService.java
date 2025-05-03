package com.salarylupin.server.magicbook;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MagicBookService {

    private final MagicBookAnswerRepository magicBookAnswerRepository;

    public MagicBookResponseDTO getRandomAnswer() {
        return new MagicBookResponseDTO(magicBookAnswerRepository.findRandomAnswer().answer);
    }
}
