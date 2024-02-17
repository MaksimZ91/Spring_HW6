package com.example.Spring_HW6.repository;

import com.example.Spring_HW6.models.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


public interface NoteRepository extends JpaRepository<Note, Long> {

    /**
     * Обновление заметки в бд.
     *
     * @param id          Идентификатор заметки.
     * @param title       Заголовок заметки.
     * @param description Описание заметки.
     * @return Кол-во обновленных строк.
     */
    @Modifying
    @Query("UPDATE note SET title = :title, description = :description WHERE Id = :id")
    int updateNote(Long id, String title, String description);


}
