package com.example.Spring_HW6.controller;

import com.example.Spring_HW6.models.Note;
import com.example.Spring_HW6.service.NoteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class NoteController {
    /**
     * Подключение сервиса заметок.
     */
    private final NoteService noteService;

    /**
     * Получение всех заметок.
     *
     * @return Список заметок.
     */
    @GetMapping
    public ResponseEntity<List<Note>> getAllNotes() {
        return new ResponseEntity<>(noteService.getAllNotes(), HttpStatus.OK);
    }

    /**
     * Создание новой заметки.
     *
     * @param note Объект создоваемой заметки.
     * @return Созданная заметка.
     */
    @PostMapping
    public ResponseEntity<Note> addNote(@RequestBody Note note) {
        return new ResponseEntity<>(noteService.saveNote(note), HttpStatus.CREATED);
    }

    /**
     * Получение заметки по идентификатору.
     *
     * @param id Идентификатор заметки.
     * @return Заметка.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable("id") Long id) {
        Optional<Note> optionalNote = noteService.getNoteById(id);
        return (optionalNote.isPresent()) ?
                new ResponseEntity<>(optionalNote.get(), HttpStatus.OK) :
                new ResponseEntity<>(new Note(), HttpStatus.NOT_FOUND);
    }

    /**
     * Обновление заметки.
     *
     * @param note Объект обновляемой заметки.
     * @param id   Идентификатор заметки.
     * @return Обновленная заметка.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Note> updateNote(@RequestBody Note note, @PathVariable("id") Long id) {
        return new ResponseEntity<>(noteService.updateNote(note, id), HttpStatus.OK);

    }

    /**
     * Удаление заметки.
     *
     * @param id Идентификатор заметки.
     * @return Ответ со статусом.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable("id") Long id) {
        noteService.deleteNoteById(id);
        return ResponseEntity.ok().build();
    }


}
