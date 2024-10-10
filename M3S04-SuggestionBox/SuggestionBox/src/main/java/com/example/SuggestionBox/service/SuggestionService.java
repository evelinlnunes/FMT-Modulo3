package com.example.SuggestionBox.service;

import com.example.SuggestionBox.dto.SuggestionRequest;
import com.example.SuggestionBox.dto.SuggestionResponse;
import com.example.SuggestionBox.model.Suggestion;
import com.example.SuggestionBox.repository.SuggestionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class SuggestionService {
    private final SuggestionRepository repository;

    public SuggestionResponse create(SuggestionRequest request) {
        log.info("Creating suggestion: {}", request.getTitle());

        Suggestion suggestion = new Suggestion(request);
        suggestion.setCreatedAt(LocalDateTime.now());
        suggestion.setUpdatedAt(LocalDateTime.now());
        SuggestionResponse response = save(suggestion);

        log.info("Suggestion created: {} (id: {})", response.getTitle(), response.getId());
        return response;
    }

    public List<SuggestionResponse> findAll(String title) {
        log.info("Finding all suggestions with filter({})", title);
        List<SuggestionResponse> suggestions = repository.findAllByTitleContainingIgnoreCaseOrderByUpdatedAtDesc(title).stream().map(SuggestionResponse::new).collect(Collectors.toList());
        log.info("{} suggestions found with filter({})", suggestions.size(), title);
        return suggestions;
    }

    private SuggestionResponse save(Suggestion suggestion) {
        log.info("Saving suggestion: {}", suggestion.getTitle());

        repository.save(suggestion);

        log.info("Suggestion saved: {} (id: {})", suggestion.getTitle(), suggestion.getId());
        return new SuggestionResponse(suggestion);
    }
}
