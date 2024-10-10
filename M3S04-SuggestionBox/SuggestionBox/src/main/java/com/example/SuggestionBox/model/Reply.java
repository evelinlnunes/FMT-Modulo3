package com.example.SuggestionBox.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "replies")
@Getter
@Setter
public class Reply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String comment;
    private LocalDateTime repliedAt;

    @OneToOne
    @JoinColumn(name = "suggestion_id", nullable = false)
    private Suggestion suggestion;


}
