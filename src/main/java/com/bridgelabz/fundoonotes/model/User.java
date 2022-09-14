package com.bridgelabz.fundoonotes.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
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
    private String gender;
    private String mobileNumber;
    private LocalDateTime registrationDate;
    private boolean isVerified;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Notes>  notesList = new ArrayList<>();

}
