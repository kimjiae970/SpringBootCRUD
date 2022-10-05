package com.example.board.entity;

import com.example.board.dto.BoardRequestDto;

import java.time.LocalDateTime;

public interface BoardDetail {

    Long getId();
    String getTitle();
    String getUsername();
    String getContent();
    LocalDateTime getCreatedAt();


}
