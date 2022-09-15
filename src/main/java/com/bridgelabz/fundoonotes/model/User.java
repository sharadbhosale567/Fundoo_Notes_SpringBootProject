package com.bridgelabz.fundoonotes.model;

import com.bridgelabz.fundoonotes.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String firstName;
    private String lastName;
    private String emailId;
    private String password;
    private LocalDate dob;
    private LocalDate registerDate;
    private LocalDate updatedDate;


    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Notes>  notesList = new ArrayList<>();

    public void createUser(UserDTO userDTO) {
        this.firstName = userDTO.getFirstName();
        this.lastName = userDTO.getLastName();
        this.emailId = userDTO.getEmailId();
        this.password = userDTO.getPassword();
        this.dob = userDTO.getDob();
        this.registerDate = userDTO.getRegisterDate();
    }

    public void updateUser(UserDTO userDTO) {
        this.firstName = userDTO.getFirstName();
        this.lastName = userDTO.getLastName();
        this.emailId = userDTO.getEmailId();
        this.password = userDTO.getPassword();
        this.dob = userDTO.getDob();
        this.registerDate = userDTO.getRegisterDate();
        this.updatedDate = userDTO.getUpdatedDate();
    }
}
