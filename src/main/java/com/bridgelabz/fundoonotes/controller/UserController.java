package com.bridgelabz.fundoonotes.controller;

import com.bridgelabz.fundoonotes.dto.ResponseDTO;
import com.bridgelabz.fundoonotes.dto.UserDTO;
import com.bridgelabz.fundoonotes.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private IUserService iUserService;

    @GetMapping("/users")
    public ResponseEntity<ResponseDTO> getAllUsers() {
        ResponseDTO responseDTO = iUserService.getAllUsers();
        return new ResponseEntity<>(responseDTO, HttpStatus.ACCEPTED);
    }

    @PostMapping("/users")
    public ResponseEntity<ResponseDTO> createNewUser(@RequestBody UserDTO userDTO){
        ResponseDTO responseDTO = iUserService.registerUser(userDTO);
        return new ResponseEntity<>(responseDTO,HttpStatus.CREATED);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<ResponseDTO> changeUserData(@PathVariable int id,@RequestBody UserDTO userDTO) {
        ResponseDTO responseDTO = iUserService.UpdateUserData(id, userDTO);
        return new ResponseEntity<>(responseDTO,HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<ResponseDTO> deleteUserById(@PathVariable int id) {
        ResponseDTO responseDTO = iUserService.deleteUserDataById(id);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<ResponseDTO> getUserById(@PathVariable int id) {
        ResponseDTO responseDTO = iUserService.getUserById(id);
        return new ResponseEntity<>(responseDTO,HttpStatus.ACCEPTED);
    }
}
