package com.example.SuggestionBox.dto;

import com.example.SuggestionBox.model.Reply;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class ReplyResponse extends ReplyAbstract {

    @Schema(description = "The unique ID of the reply", example = "1")
    private Long id;

    @Schema(description = "The timestamp when the reply was created", example = "2024-09-20 14:30:00")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime repliedAt;

    @Schema(description = "The ID of the suggestion that this reply belongs to", example = "1")
    private Long suggestionId;

    public ReplyResponse(Reply reply, Long id) {
        BeanUtils.copyProperties(reply, this);
        this.suggestionId = id;
    }
}
