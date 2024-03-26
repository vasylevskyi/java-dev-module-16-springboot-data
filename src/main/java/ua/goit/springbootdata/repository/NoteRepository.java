package ua.goit.springbootdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.goit.springbootdata.model.Note;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
}
