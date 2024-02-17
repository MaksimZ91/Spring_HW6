package com.example.Spring_HW6.service;

import com.example.Spring_HW6.models.Note;

import java.util.List;
import java.util.Optional;

public interface NoteService {

    /**
     * Получение всех заметок.
     *
     * @return Список заметок.
     */
    List<Note> getAllNotes();

    /**
     * Получение заметки по идентификатору.
     *
     * @param id Идентификатор заметки.
     * @return Заметка.
     */
    Optional<Note> getNoteById(Long id);

    /**
     * Удаление заметки.
     *
     * @param id Идентификатор заметки.
     */
    void deleteNoteById(Long id);

    /**
     * Обновление заметки.
     *
     * @param note Объект обновляемой заметки.
     * @param id   Идентификатор заметки.
     * @return Обновленная заметка.
     */
    Note updateNote(Note note, Long id);

    /**
     * Сохранение новой заметки.
     *
     * @param note Объект создоваемой заметки.
     * @return Созданная заметка.
     */
    Note saveNote(Note note);

}
