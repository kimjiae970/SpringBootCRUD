package com.example.board.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BoardRequestDto {
    private String password;
    private String title;
    private String username;
    private String content;
    private LocalDateTime createdAt;

}
