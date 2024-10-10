package com.example.SuggestionBox.controller;

import com.example.SuggestionBox.dto.SuggestionRequest;
import com.example.SuggestionBox.dto.SuggestionResponse;
import com.example.SuggestionBox.service.SuggestionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("suggestions")
@RequiredArgsConstructor
@Slf4j
public class SuggestionController {
    private final SuggestionService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SuggestionResponse create(@RequestBody SuggestionRequest request) {
        log.info("POST: /reminder -> Begin");
        SuggestionResponse response = service.create(request);
        log.info("POST: /reminder -> End");
        return response;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<SuggestionResponse> findAll(
            @RequestParam(defaultValue = "") String title
    ) {
        log.info("GET: /reminder -> Begin");
        List<SuggestionResponse> suggestions = service.findAll(title);

        log.info("GET: /reminder -> End");
        return suggestions;
    }
}