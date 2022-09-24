package com.bridgelabz.fundoonotes.service;

import com.bridgelabz.fundoonotes.dto.LabelDTO;
import com.bridgelabz.fundoonotes.dto.ResponseDTO;
import com.bridgelabz.fundoonotes.model.Label;

import java.util.List;

public interface ILabelService {

    public int createLabel(LabelDTO labelDTO ,String token);

    public boolean updateLabel(LabelDTO labelDTO,long labelId , String token);

    public boolean deleteLabelById(long labelId, String token);

    List<Label> getAllLabel(String token);

//    Label createOrMapWithNote(LabelDTO labelDTO, long notesId, String token);
//
//    Label addLabelsToNote(String token, long labelId, long notesId);
}
