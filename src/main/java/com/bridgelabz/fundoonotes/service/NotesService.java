package com.bridgelabz.fundoonotes.service;

import com.bridgelabz.fundoonotes.dto.NotesDTO;
import com.bridgelabz.fundoonotes.dto.ResponseDTO;
import com.bridgelabz.fundoonotes.model.Notes;
import com.bridgelabz.fundoonotes.repository.NotesRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotesService implements INotesService{
    @Autowired
    private NotesRepository notesRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ResponseDTO addNotes(NotesDTO notesDTO) {
        Notes notes = modelMapper.map(notesDTO,Notes.class);
        notesRepository.save(notes);
        System.out.println(notes.toString());
        return new ResponseDTO("Add Note successfully completed",notes);
    }

    @Override
    public ResponseDTO getNotesByUsingId(int id) {
        return new ResponseDTO("Get notes by using id",notesRepository.getById(id));
    }

    @Override
    public ResponseDTO getAllNotes() {
        return new ResponseDTO("Get all notes",notesRepository.findAll());
    }

    @Override
    public ResponseDTO changeNotesData(int id,NotesDTO notesDTO) {
        Notes notes = modelMapper.map(notesDTO, Notes.class);
        notesRepository.save(notes);
        return new ResponseDTO("Change Notes data",notes);
    }

    @Override
    public ResponseDTO deleteNotesByUsingId(int id) {
        return new ResponseDTO("Delete Notes By using id Successfully",notesRepository.deleteNotesById(id));
    }

    @Override
    public ResponseDTO deleteNotesByUsingTitles(String title) {
        return new ResponseDTO("Delete Notes By using Titles Successfully",notesRepository.deleteNotesByTitle(title));
    }
}
