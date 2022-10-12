package com.example.board.dto;


import com.example.board.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto {

    private Long id;
    private String content;
    private String writer;

    public CommentDto(Comment comment){
        this.id = comment.getIdx();
        this.content = comment.getContent();
        this.writer = comment.getWriter();
    }
}
