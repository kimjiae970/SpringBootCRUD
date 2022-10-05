package com.example.board.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardResponse {

    private boolean success;
    private String error;

    public BoardResponse(boolean result){

        if(result == true){
            this.error = "";
        }else {
            this.error = "비밀번호 틀림";
        }
        this.success = true;
    }
}
