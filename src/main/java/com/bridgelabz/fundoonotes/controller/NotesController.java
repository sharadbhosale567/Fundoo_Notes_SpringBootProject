package com.bridgelabz.fundoonotes.controller;

import com.bridgelabz.fundoonotes.dto.NotesDTO;
import com.bridgelabz.fundoonotes.dto.ResponseDTO;
import com.bridgelabz.fundoonotes.service.INotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class NotesController {
    @Autowired
    private INotesService iNotesService;

    @GetMapping("/notes")
    public ResponseEntity<ResponseDTO> getAllNotes() {
        ResponseDTO responseDTO = iNotesService.getAllNotes();
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/notes")
    public ResponseEntity<ResponseDTO> createNotes(@RequestBody NotesDTO notesDTO) {
        ResponseDTO responseDTO = iNotesService.addNotes(notesDTO);
        return new ResponseEntity<>(responseDTO,HttpStatus.ACCEPTED);
    }

    @PutMapping("/notes/{id}")
    public ResponseEntity<ResponseDTO> updateNotes(@PathVariable int id,@RequestBody NotesDTO notesDTO) {
        ResponseDTO responseDTO = iNotesService.changeNotesData(id,notesDTO);
        return new ResponseEntity<>(responseDTO,HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/notes/{id}")
    public ResponseEntity<ResponseDTO> deleteNotesById(@PathVariable int id) {
        ResponseDTO responseDTO = iNotesService.deleteNotesByUsingId(id);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    @DeleteMapping("/notes/{title}")
    public ResponseEntity<ResponseDTO> deleteNotesById(@PathVariable String title) {
        ResponseDTO responseDTO = iNotesService.deleteNotesByUsingTitles(title);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

}
