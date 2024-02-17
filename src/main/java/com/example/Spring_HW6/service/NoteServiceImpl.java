package com.example.Spring_HW6.service;

import com.example.Spring_HW6.aspects.TrackUserAction;
import com.example.Spring_HW6.models.Note;
import com.example.Spring_HW6.repository.NoteRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class NoteServiceImpl implements NoteService {
    /**
     * Подключение репозитория заметок.
     */
    private  final NoteRepository noteRepository;

    /**
     * Получение всех заметок.
     * @return Список заметок.
     */
    @Override
    @TrackUserAction
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    /**
     * Получение заметки по идентификатору.
     * @param id Идентификатор заметки.
     * @return Заметка.
     */
    @Override
    public Optional<Note> getNoteById(Long id) {
        return noteRepository.findById(id);
    }

    /**
     * Удаление заметки.
     * @param id Идентификатор заметки.
     */
    @Override
    public void deleteNoteById(Long id) {
         noteRepository.deleteById(id);
    }

    /**
     * Обновление заметки.
     * @param note Объект обновляемой заметки.
     * @param id Идентификатор заметки.
     * @return Обновленная заметка.
     */
    @Override
    @Transactional
    public Note updateNote(Note note, Long id) {
        noteRepository.updateNote(id, note.getTitle(), note.getDescription());
        Note updateNote = noteRepository.findById(id).get();
        return updateNote;
    }

    /**
     * Сохранение новой заметки.
     *
     * @param note Объект создоваемой заметки.
     * @return Созданная заметка.
     */
    @Override
    @TrackUserAction
    public Note saveNote(Note note) {
        return noteRepository.save(note);
    }

}
