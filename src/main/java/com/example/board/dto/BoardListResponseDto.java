package com.example.board.dto;


import com.example.board.entity.Board;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class BoardListResponseDto {

    private String title;
    private String username;
    private LocalDateTime createdAt;

    public BoardListResponseDto(Board board){
        this.title =board.getTitle();
        this.username = board.getUsername();
        this.createdAt = board.getCreatedAt();
    }
}
