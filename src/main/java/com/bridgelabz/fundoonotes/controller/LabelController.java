package com.bridgelabz.fundoonotes.controller;

import com.bridgelabz.fundoonotes.dto.LabelDTO;
import com.bridgelabz.fundoonotes.dto.ResponseDTO;
import com.bridgelabz.fundoonotes.model.Label;
import com.bridgelabz.fundoonotes.service.ILabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LabelController {

    @Autowired
    private ILabelService iLabelService;

    @PostMapping("/addlabel")
    public ResponseEntity<ResponseDTO> createNewLabel(@RequestBody LabelDTO labelDTO,  @RequestHeader("token") String token) {
        int result = iLabelService.createLabel(labelDTO, token);
        if (result != 0)
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO("Label is Created", 200));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDTO("Already exist in label ", 400));
    }


    @GetMapping("/getlabel")
    public ResponseEntity<ResponseDTO> getAllLabels(@RequestHeader("token") String token) {
        List<Label> labelList = iLabelService.getAllLabel(token);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(200, "all labels of user", labelList));
    }

    @PutMapping("/updatelabel/{labelId}")
    public ResponseEntity<ResponseDTO> updateLabel(@RequestBody long labelId,@RequestBody LabelDTO labelDTO, @RequestHeader("token") String token) {

        boolean result = iLabelService.updateLabel(labelDTO,labelId, token);
        if(result) {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO("Label is updated", 200));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDTO("Something went wrong", 400));
    }

    @DeleteMapping("/label/{labelId}")
    public ResponseEntity<ResponseDTO> deleteLabelById(@PathVariable long labelId, @RequestHeader("token") String token) {

        boolean result = iLabelService.deleteLabelById(labelId, token);
        if(result) {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO("Label is deleted", 200));
        }
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO("Something went wrong", 400));
    }

    @GetMapping("/alllabel")
    public ResponseEntity<ResponseDTO> getAllLabel(@RequestHeader("token") String token)
    {
        List<Label> labelList = iLabelService.getAllLabel(token);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(200, "all labels of user", labelList));
    }
    /*
     * API to map label to note
     */
//    @PostMapping("/label/maptonote")
//    public ResponseEntity<ResponseDTO> mapToNote(@RequestBody LabelDTO labelDTO,@RequestHeader("token") String token, @PathVariable("noteId") Long noteId)
//    {
//        Label result = iLabelService.createOrMapWithNote(labelDTO, noteId, token);
//        if(result != null)
//            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO("Label is mapped to note", 200));
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDTO("The label you are trying to create is already exist!!!", 400));
//    }

    /*
     * API to add some note to a label
     */
//    @PostMapping("/label/addLabelsToNote")
//    public ResponseEntity<ResponseDTO> addLabels(@RequestHeader("token") String token, @RequestParam("labelId") long labelId, @RequestParam("noteId") long noteId)
//    {
//        Label result = iLabelService.addLabelsToNote(token, labelId, noteId);
//        if(result != null)
//            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO("label added", 200));
//        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO("Something went wrong", 400));
//    }
}
