package com.example.board.dto;

import com.example.board.entity.Board;
import com.example.board.entity.BoardDetail;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UpdateResponse {

    private boolean success;
    private String error;
    private Board board;

    public UpdateResponse(Board board){
        this.success = true;
        this.error ="";
        this.board = board;
    }
}
