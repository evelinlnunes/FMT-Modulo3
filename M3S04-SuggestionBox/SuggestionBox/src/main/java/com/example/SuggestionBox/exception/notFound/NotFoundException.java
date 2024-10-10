package com.example.SuggestionBox.exception.notFound;

public abstract class NotFoundException extends RuntimeException {
    public NotFoundException(String entityName, Long id) {
        super("Not found entity " + entityName + " with id " + id);
    }
}
