package com.bridgelabz.fundoonotes.service;

import com.bridgelabz.fundoonotes.dto.LoginDTO;
import com.bridgelabz.fundoonotes.dto.UserDTO;
import com.bridgelabz.fundoonotes.model.User;

import java.util.List;

public interface IUserService {


    List<User> getUserData();

    User getUserDataById(String token);

    User register(UserDTO userDTO);

    User login(LoginDTO loginDTO);

    User verify(String token);

    User updateUserData(String token, UserDTO userDTO);

    String deleteUserData(String token);

    String Search(LoginDTO loginDTO);
}
