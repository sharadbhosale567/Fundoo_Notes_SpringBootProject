package com.bridgelabz.fundoonotes.service;

import com.bridgelabz.fundoonotes.dto.NotesDTO;
import com.bridgelabz.fundoonotes.dto.ResponseDTO;
import com.bridgelabz.fundoonotes.model.Label;
import com.bridgelabz.fundoonotes.model.Notes;

import java.util.List;

public interface INotesService {

    Notes addNotes(NotesDTO notesDTO, String token);

    boolean updateNote(NotesDTO notesDTO, String token, long id);

    long trashNote(String token, long id);

    boolean deleteForever(String token, long id);

    long archive(String token, long id);

    List<Notes> getAllNote(String token);

    List<Label> allLabelofOneNote(String token, long id);
}
