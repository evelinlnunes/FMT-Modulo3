package com.example.SuggestionBox.model;

import com.example.SuggestionBox.dto.ReplyRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;

@Entity
@Table(name = "replies")
@Getter
@Setter
@NoArgsConstructor
public class Reply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String comment;
    private LocalDateTime repliedAt;

    @ManyToOne
    @JoinColumn(name = "suggestion_id", nullable = false)
    @JsonIgnore
    private Suggestion suggestion;

    public Reply(ReplyRequest request) {
        BeanUtils.copyProperties(request, this);
    }

}