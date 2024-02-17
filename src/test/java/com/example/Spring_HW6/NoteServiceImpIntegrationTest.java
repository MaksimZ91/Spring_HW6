package com.example.Spring_HW6;


import com.example.Spring_HW6.models.Note;
import com.example.Spring_HW6.repository.NoteRepository;
import com.example.Spring_HW6.service.NoteServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class NoteServiceImpIntegrationTest {
    @MockBean
    private NoteRepository noteRepository;

    @Autowired
    private NoteServiceImpl noteService;

    @Test
    public void updateNoteGoodTest(){
        Note note = new Note(1L, "testTitle", "testDescription", LocalDate.now());
        Note updateNote = new Note(1L, "updateTitle", "updateTitle", LocalDate.now());
        given(noteRepository.findById(1L)).willReturn(Optional.of(updateNote));
        noteService.updateNote( updateNote, 1L);
        verify(noteRepository).updateNote(1L, updateNote.getTitle(), updateNote.getDescription());
        Assertions.assertEquals(updateNote,noteRepository.findById(1L).get());
    }


}
