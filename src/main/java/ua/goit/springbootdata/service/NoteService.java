package ua.goit.springbootdata.service;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityNotFoundException;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import ua.goit.springbootdata.model.Note;
import ua.goit.springbootdata.repository.NoteRepository;

import java.util.*;

@RequiredArgsConstructor
@Data
@Service
public class NoteService {
    private final Note note;
    private Map<Long, Note> notes = new TreeMap<>();
    private final ApplicationContext context;
    private final NoteRepository noteRepository;

    public List<Note> findAll() {
        return noteRepository.findAll();
    }

    public void deleteById(long id) {
        Note noteToDelete = noteRepository.findById(id)
                .map(Note.class::cast)
                .get();

        if (noteToDelete == null) {
            throw new EntityNotFoundException("Note not found with id = " + id);
        }
        noteRepository.deleteById(id);
    }

    public Note getById(long id) {
        Note noteById = noteRepository.findById(id)
                .map(Note.class::cast)
                .get();

        if (noteById == null) {
            throw new EntityNotFoundException("Note not found, id = " + id);
        } else {
            return noteById;
        }
    }

    public void saveNote(Note note) {
        noteRepository.save(note);
    }

    public Note add(Note note) {
        long randomID = (long )(Math.random() * (Long.MAX_VALUE));
        note.setId(randomID);
        notes.put(randomID, note);
        return note;
    }



    @PostConstruct
    public void init() {
//        note.hello();
        System.out.println(noteRepository.getClass());
    }


}
