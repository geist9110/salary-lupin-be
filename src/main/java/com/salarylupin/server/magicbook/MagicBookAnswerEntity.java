package com.salarylupin.server.magicbook;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "magic_book_answer")
@NoArgsConstructor
public class MagicBookAnswerEntity {

    @Id
    private int id;

    String answer;
}
