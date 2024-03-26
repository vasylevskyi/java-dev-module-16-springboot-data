package ua.goit.springbootdata.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.goit.springbootdata.model.Note;
import ua.goit.springbootdata.service.NoteService;

import java.util.List;

@RequestMapping("/note")
@RequiredArgsConstructor
@Controller
public class NoteController {
    private final NoteService noteService;

    @GetMapping("/list")
    public ModelAndView getNotesList() {
        ModelAndView result = new ModelAndView("notes");
        List<Note> notesList = noteService.findAll();
        result.addObject("notesList", notesList);
        return result;
    }

    @PostMapping("/delete")
    public String deleteNote(@RequestParam("id") long id) {
        noteService.deleteById(id);
        return "redirect:/note/list";
    }

    @GetMapping("/edit")
    public String editNote(@RequestParam("id") long id, Model model) {
        Note note = noteService.getById(id);
        model.addAttribute("note", note);
        return "editNote";
    }

    @PostMapping("/update")
    public String saveNote(@ModelAttribute("note") Note note) {
        noteService.saveNote(note);
        return "redirect:/note/list";
    }

    @GetMapping
    public ModelAndView getNoteById(@RequestParam("id") long id) {
        ModelAndView result = new ModelAndView("notes");
        Note noteById = noteService.getById(id);
        result.addObject("notesList", noteById);
        return result;
    }
}
