package com.example.Spring_HW6.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "note")
public class Note {
    /**
     * Идентификатор заметки.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * Заголовок заметки.
     */
    @Column(nullable = false)
    private String title;

    /**
     * Описание заметки.
     */
    @Column(nullable = false)
    private String description;

    /**
     * Дата создание заметки.
     */
    @Builder.Default()
    private LocalDate date = LocalDate.now();

}
