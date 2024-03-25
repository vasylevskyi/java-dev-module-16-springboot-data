package ua.goit.springbootdata.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.goit.springbootdata.model.Note;
import ua.goit.springbootdata.service.NoteService;

import java.util.Map;

@RequestMapping("/note")
@RequiredArgsConstructor
@Controller
public class NoteController {
    private final NoteService noteService;

    @GetMapping("/list")
    public ModelAndView getNotesList() {
        ModelAndView result = new ModelAndView("notes");
        Map<Long, Note> notesList = noteService.getNotes();
        result.addObject("notesList", notesList);
        return result;
    }

    @PostMapping("/delete")
    public String deleteNote(@RequestParam("id") long id) {
        noteService.deleteNoteById(id);
        return "redirect:/note/list";
    }

    @GetMapping("/edit")
    public String editNote(@RequestParam("id") long id, Model model) {
        Note note = noteService.getNoteById(id);
        model.addAttribute("note", note);
        return "editNote";
    }

    @PostMapping("/update")
    public String updateNote(@ModelAttribute("note") Note note) {
        noteService.updateNote(note);
        return "redirect:/note/list";
    }

}
