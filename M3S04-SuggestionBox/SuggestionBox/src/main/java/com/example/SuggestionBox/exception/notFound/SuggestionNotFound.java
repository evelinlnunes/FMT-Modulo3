package com.example.SuggestionBox.exception.notFound;

public class SuggestionNotFound extends NotFoundException {
    public SuggestionNotFound(Long id) {
        super("Suggestion", id);
    }
}