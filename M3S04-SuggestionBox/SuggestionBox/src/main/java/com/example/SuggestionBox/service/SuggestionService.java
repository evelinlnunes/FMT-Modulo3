package com.example.SuggestionBox.service;

import com.example.SuggestionBox.dto.SuggestionRequest;
import com.example.SuggestionBox.dto.SuggestionResponse;
import com.example.SuggestionBox.model.Suggestion;
import com.example.SuggestionBox.repository.SuggestionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class SuggestionService {
    private final SuggestionRepository repository;

    public SuggestionResponse create(SuggestionRequest request) {
        log.info("Creating suggestion: {}", request.getTitle());

        Suggestion suggestion = new Suggestion(request);
        suggestion.setCreatedAt(LocalDateTime.now());
        SuggestionResponse response = save(suggestion);

        log.info("Suggestion created: {} (id: {})", response.getTitle(), response.getId());
        return response;
    }


    // privates
    private SuggestionResponse save(Suggestion suggestion) {
        log.info("Saving suggestion: {}", suggestion.getTitle());

        repository.save(suggestion);

        log.info("Suggestion saved: {} (id: {})", suggestion.getTitle(), suggestion.getId());
        return new SuggestionResponse(suggestion);
    }
}
