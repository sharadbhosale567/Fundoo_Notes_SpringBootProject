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

    private String firstName;
    private String lastName;
    private String emailId;
    private String password;
    private String mobileNumber;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate registerDate = LocalDate.now();
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate updatedDate = LocalDate.now();
}
