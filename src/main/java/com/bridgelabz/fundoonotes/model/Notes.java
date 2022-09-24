package com.bridgelabz.fundoonotes.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long notesId;
    private String title;
    private String description;
    @Column(columnDefinition = "boolean default false")
    private boolean isArchived;
    @Column(columnDefinition = "boolean default false")
    private boolean isDeleted;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @ManyToMany
    @JsonIgnore
    private List<Label> labels;

    public Notes(String title, String description, boolean isArchived, boolean isDeleted) {
        this.title = title;
        this.description = description;
        this.isArchived = isArchived;
        this.isDeleted = isDeleted;
    }

    //    private boolean isArchived;
//    private boolean isPinned;
//    private boolean isTrashed;
//    private String color;
//    private LocalDateTime registrationDate;
//    private LocalDateTime updatedDate;
//    private LocalDateTime reminderDate;
}
