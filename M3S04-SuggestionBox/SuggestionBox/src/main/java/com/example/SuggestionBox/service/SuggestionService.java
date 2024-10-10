package com.example.SuggestionBox.service;

import com.example.SuggestionBox.dto.*;
import com.example.SuggestionBox.exception.notFound.SuggestionNotFound;
import com.example.SuggestionBox.model.Reply;
import com.example.SuggestionBox.model.Suggestion;
import com.example.SuggestionBox.repository.ReplyRepository;
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
    private final SuggestionRepository suggestionRepository;
    private final ReplyRepository replyRepository;

    public SuggestionResponse createSuggestion(SuggestionRequest request) {
        log.info("Creating suggestion: {}", request.getTitle());

        Suggestion suggestion = new Suggestion(request);
        suggestion.setCreatedAt(LocalDateTime.now());
        suggestion.setUpdatedAt(LocalDateTime.now());
        SuggestionResponse response = save(suggestion);

        log.info("Suggestion created: {} (id: {})", response.getTitle(), response.getId());
        return response;
    }

    public ReplyResponse createReply(Long id, ReplyRequest replyRequest) {
        log.info("Creating reply to Suggestion with id: {}", id);
        Suggestion suggestion = findSuggestionById(id);

        Reply reply = new Reply(replyRequest);
        reply.setRepliedAt(LocalDateTime.now());
        reply.setSuggestion(suggestion);

        suggestion.setUpdatedAt(LocalDateTime.now());

        suggestionRepository.save(suggestion);
        replyRepository.save(reply);

        log.info("Reply created to Suggestion with id: {}", id);
        return new ReplyResponse(reply, id);
    }

    // READ
    public List<SuggestionResponse> findAll(String titleFilter) {
        log.info("Finding all suggestions with filter({})", titleFilter);
        List<SuggestionResponse> suggestions =
                suggestionRepository
                        .findAllByTitleContainingIgnoreCaseOrderByUpdatedAtDesc(titleFilter)
                        .stream()
                        .map(SuggestionResponse::new)
                        .collect(Collectors.toList());

        log.info("{} suggestions found with filter({})", suggestions.size(), titleFilter);
        return suggestions;
    }

    public SuggestionWithRepliesResponse findById(Long id) {
        log.info("Finding suggestion with id {} and replies", id);

        SuggestionWithRepliesResponse response =
                new SuggestionWithRepliesResponse(findSuggestionById(id));

        log.info("Finding replies of suggestion with id:{}", id);

        response.setReplies(
                replyRepository.findAllBySuggestionIdOrderByRepliedAtDesc(id).stream()
                        .map((item) -> new ReplyResponse(item, id))
                        .collect(Collectors.toList()));

        log.info("{} replies found of suggestion with id:{}", response.getReplies().size(), id);
        log.info("Suggestion found with id {} and replies", id);

        return response;
    }

    private SuggestionResponse save(Suggestion suggestion) {
        log.info("Saving suggestion: {}", suggestion.getTitle());

        suggestionRepository.save(suggestion);

        log.info("Suggestion saved: {} (id: {})", suggestion.getTitle(), suggestion.getId());
        return new SuggestionResponse(suggestion);
    }

    private Suggestion findSuggestionById(Long id) {
        log.info("Finding suggestion with id {} (ENTITY)", id);

        Suggestion suggestion =
                suggestionRepository.findById(id).orElseThrow(() -> new SuggestionNotFound(id));

        log.info("Suggestion found with id {} (ENTITY)", id);
        return suggestion;

    }
}
