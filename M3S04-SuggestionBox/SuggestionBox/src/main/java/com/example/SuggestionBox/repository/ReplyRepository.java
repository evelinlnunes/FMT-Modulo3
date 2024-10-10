package com.example.SuggestionBox.repository;

import com.example.SuggestionBox.model.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
    List<Reply> findAllBySuggestionIdOrderByRepliedAtDesc(Long suggestionId);

}
