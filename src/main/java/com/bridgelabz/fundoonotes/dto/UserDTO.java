package com.bridgelabz.fundoonotes.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    public String firstName;
    public  String lastName;
    public String email;
    public String password;
    public String address;
    public String username;
}
