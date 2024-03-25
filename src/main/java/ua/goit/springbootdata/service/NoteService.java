package ua.goit.springbootdata.service;

import jakarta.annotation.PostConstruct;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import ua.goit.springbootdata.model.Note;

import java.util.*;

@RequiredArgsConstructor
@Data
@Service
public class NoteService {
    private final Note note;
    private Map<Long, Note> notes = new TreeMap<>();
    private final ApplicationContext context;

    public Note add(Note note) {
        long randomID = (long )(Math.random() * (Long.MAX_VALUE));
        note.setId(randomID);
        notes.put(randomID, note);
        return note;
    }
    Map<Long, Note> mapAll() {
        return notes;
    }

    public void deleteNoteById(long id) {
        Note noteById = notes.get(id);

        if (noteById == null) {
            throw new RuntimeException("Note not found, id = " + id);
        } else {
            notes.remove(id);
        }
    }

    public void updateNote(Note note) {
        Long noteID = note.getId();
        Note noteById = context
                .getBean(NoteService.class)
                .getNoteById(noteID);
        if (noteById == null) {
            throw new RuntimeException("Note not found, id = " + noteID);
        } else {
            notes.replace(noteID, note);
        }
    }

    public Note getNoteById(long id) {
        Note noteById = notes.get(id);

        if (noteById == null) {
            throw new RuntimeException("Note not found, id = " + id);
        } else {
            return noteById;
        }

    }

    @PostConstruct
    public void init() {
        note.hello();
    }


}
