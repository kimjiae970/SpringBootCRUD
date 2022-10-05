package com.example.board.entity;

import java.time.LocalDateTime;

public interface BoardList{

    String getTitle();
    String getUsername();
    LocalDateTime getCreatedAt();

}
