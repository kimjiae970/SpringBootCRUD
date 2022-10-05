package com.example.board.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateAndDeleteResponse {

    private boolean success;
    private String error;
    private String result;

    public CreateAndDeleteResponse(Long id){
        this.success =true;
        this.error = "";
        this.result ="처리 완료";

    }

}
