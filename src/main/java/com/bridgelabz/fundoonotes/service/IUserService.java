package com.bridgelabz.fundoonotes.service;

import com.bridgelabz.fundoonotes.dto.ResponseDTO;
import com.bridgelabz.fundoonotes.dto.UserDTO;

public interface IUserService {

    public ResponseDTO registerUser(UserDTO userDTO);
    public ResponseDTO getAllUsers();
    public ResponseDTO UpdateUserData(int id, UserDTO userDTO);
    public ResponseDTO deleteUserDataById(int id);
    public ResponseDTO getUserById(int id);

}
