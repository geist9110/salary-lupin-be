package com.salarylupin.server.magicbook;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "magic_book_answer")
@NoArgsConstructor
public class MagicBookAnswerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Getter
    String answer;

    public MagicBookAnswerEntity(String answer) {
        this.answer = answer;
    }
}
