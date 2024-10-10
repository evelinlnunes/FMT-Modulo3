package com.example.SuggestionBox.repository;

import com.example.SuggestionBox.model.Reply;
import com.example.SuggestionBox.model.Suggestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
    List<Suggestion> findAllByTitleContainingIgnoreCaseOrderByUpdatedAtDesc(String title);
    @Query(
            "SELECT s FROM Suggestion s WHERE LOWER(s.title) LIKE LOWER(CONCAT('%', :title, '%')) ORDER BY s.updatedAt DESC")
    List<Suggestion> findAllByTitleContaining(@Param("title") String title);
}
