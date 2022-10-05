package com.example.board.dto;

import com.example.board.entity.BoardList;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class GetListResponse {

    private boolean success;
    private String error;
    private List<BoardList> boardList;

    public GetListResponse(List<BoardList> boardLists){
        this.success =true;
        this.error = "";
        this.boardList = boardLists;
    }
}
