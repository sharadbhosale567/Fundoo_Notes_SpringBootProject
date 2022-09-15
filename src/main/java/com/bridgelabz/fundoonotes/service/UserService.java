package com.bridgelabz.fundoonotes.service;

import com.bridgelabz.fundoonotes.dto.ResponseDTO;
import com.bridgelabz.fundoonotes.dto.UserDTO;
import com.bridgelabz.fundoonotes.model.User;
import com.bridgelabz.fundoonotes.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public ResponseDTO registerUser(UserDTO userDTO) {
        User user = new User();
        user.createUser(userDTO);
        userRepository.save(user);
        System.out.println(user.toString());
        return new ResponseDTO("User Added successfully",user);
    }

    @Override
    public ResponseDTO getAllUsers() {
        return new ResponseDTO("Get All Users",userRepository.findAll());

    }

    @Override
    public ResponseDTO UpdateUserData(int id, UserDTO userDTO) {
        User user = new User();
        user.updateUser(userDTO);
        userRepository.save(user);
        return new ResponseDTO("Update user",user);
    }

    @Override
    public ResponseDTO deleteUserDataById(int id) {
        return new ResponseDTO("Delete user by id",userRepository.deleteUserById(id));
    }

    @Override
    public ResponseDTO getUserById(int id) {
        return new ResponseDTO("Get user by id",userRepository.getById(id));
    }
}
