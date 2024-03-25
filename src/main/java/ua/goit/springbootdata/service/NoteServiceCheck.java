package ua.goit.springbootdata.service;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import ua.goit.springbootdata.model.Note;

import java.util.Map;

@Service
public class NoteServiceCheck {
    private Note note;
    private NoteService noteService;
    private ApplicationContext context;
    @Autowired
    private NoteServiceCheck(Note note, NoteService noteService) {
        this.note = note;
        this.noteService = noteService;
    }

    @Order(1)
    @PostConstruct
    public void checkAddNote() {
        Note newNote = new Note();
        newNote.setTitle("Note Title");
        newNote.setContent("Note Content");
        System.out.println("noteService.add(note) = " + noteService.add(newNote).toString());
    }

    @Order(1000)
    @PostConstruct
    public void checkMapAllNotes() {
        Note newNote = new Note();
        newNote.setTitle("Note MapAll Title");
        newNote.setContent("Note MapAll Content");
        noteService.add(newNote);
        System.out.println("noteService.mapAll = " + noteService.mapAll().toString());
    }

/*    @Order(10000000)
    @PostConstruct
    public void checkDeleteNote() {
        System.out.println("noteService before delete = " + noteService.mapAll().toString());
        Map<Long, Note> notes = noteService.mapAll();
        Long noteId = 0L;
        for (Map.Entry<Long, Note> note: notes.entrySet()) {
            if (note != null) {
                noteId = note.getKey();
                break;
            }
        }
        noteService.deleteNoteById(noteId);
        System.out.println("noteService after delete = " + noteService.mapAll().toString());
    }*/

/*    @Order(999999999)
    @PostConstruct
    public void checkUpdateNote() {
        System.out.println("noteService before update = " + noteService.mapAll().toString());
        Map<Long, Note> notes = noteService.mapAll();
        Long noteId = 0L;
        for (Map.Entry<Long, Note> note: notes.entrySet()) {
            if (note != null) {
                noteId = note.getKey();
                break;
            }
        }
        Note updatedNote = new Note();
        updatedNote.setId(noteId);
        updatedNote.setContent("Updated Content");
        updatedNote.setTitle("Updated Title");
        noteService.updateNote(updatedNote);
        System.out.println("noteService after update = " + noteService.mapAll().toString());
    }*/


}