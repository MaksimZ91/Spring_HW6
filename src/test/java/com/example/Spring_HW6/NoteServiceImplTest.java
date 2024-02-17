package com.example.Spring_HW6;


import com.example.Spring_HW6.models.Note;
import com.example.Spring_HW6.repository.NoteRepository;
import com.example.Spring_HW6.service.NoteServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class NoteServiceImplTest {
    @Mock
    private NoteRepository noteRepository;

    @InjectMocks
    private NoteServiceImpl noteService;

    @Test
    public void findNoteByIdGoodTest() {
        Note note = new Note(1L, "testTitle", "testDescription", LocalDate.now());
        given(noteRepository.findById(1L)).willReturn(Optional.of(note));

        noteService.getNoteById(1L);

        verify(noteRepository).findById(1L);

        Assertions.assertEquals(note,noteRepository.findById(1L).get());
    }


}
