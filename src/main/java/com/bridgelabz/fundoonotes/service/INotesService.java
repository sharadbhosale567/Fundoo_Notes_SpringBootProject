package com.bridgelabz.fundoonotes.service;

import com.bridgelabz.fundoonotes.dto.NotesDTO;
import com.bridgelabz.fundoonotes.dto.ResponseDTO;

public interface INotesService {
    public ResponseDTO addNotes(NotesDTO notesDTO);
    public ResponseDTO getNotesByUsingId(int id);
    public ResponseDTO getAllNotes(NotesDTO notesDTO);
    public ResponseDTO changeNotesData(int id,NotesDTO notesDTO);
    public ResponseDTO deleteNotesByUsingId(int id);
    public ResponseDTO deleteNotesByUsingTitles(String title);
}
