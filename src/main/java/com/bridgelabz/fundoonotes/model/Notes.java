package com.bridgelabz.fundoonotes.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String description;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private User user;

//    private boolean isArchived;
//    private boolean isPinned;
//    private boolean isTrashed;
//    private String color;
//    private LocalDateTime registrationDate;
//    private LocalDateTime updatedDate;
//    private LocalDateTime reminderDate;
}
