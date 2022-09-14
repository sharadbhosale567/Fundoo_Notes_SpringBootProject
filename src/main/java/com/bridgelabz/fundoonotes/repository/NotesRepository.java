package com.bridgelabz.fundoonotes.repository;

import com.bridgelabz.fundoonotes.model.Notes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotesRepository extends JpaRepository<Notes,Integer> {

    Notes deleteNotesById(int id);
    Notes deleteNotesByTitle(String titles);
}
