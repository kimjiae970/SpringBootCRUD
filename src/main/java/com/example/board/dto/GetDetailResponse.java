package com.example.board.dto;

import com.example.board.entity.Board;
import com.example.board.entity.BoardDetail;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class GetDetailResponse {

    private boolean success;
    private String error;
    private BoardDetail data;

    public GetDetailResponse(BoardDetail boardDetail){
        this.success =true;
        this.error ="";
        this.data = boardDetail;

    }
}
