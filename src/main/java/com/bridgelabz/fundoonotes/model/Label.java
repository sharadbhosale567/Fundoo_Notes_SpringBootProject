package com.bridgelabz.fundoonotes.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Label {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long labelId;
    private String labelTitle;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User userLabel;

    @ManyToMany(mappedBy = "labels")
    @JsonIgnore
    private List<Notes> listnote;

    public Label(long labelId, String labelTitle) {
        this.labelId = labelId;
        this.labelTitle = labelTitle;
    }

//    public Label(long labelId, String labelTitle, User user, List<Notes> listNote) {
//        this.labelId = labelId;
//        this.labelTitle = labelTitle;
//        this.user = user;
//        this.listNote = listNote;
//    }
}
