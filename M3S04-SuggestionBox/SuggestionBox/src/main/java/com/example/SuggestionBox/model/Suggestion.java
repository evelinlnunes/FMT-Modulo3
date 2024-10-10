package com.example.SuggestionBox.model;

import com.example.SuggestionBox.dto.SuggestionRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;

@Entity
@Table(name = "suggestions")
@Getter
@Setter
@NoArgsConstructor
public class Suggestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String title;

    @Column(nullable = false, length = 500)
    private String description;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Suggestion(SuggestionRequest request) {
        BeanUtils.copyProperties(request, this);
    }
}