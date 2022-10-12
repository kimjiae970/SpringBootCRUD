package com.example.board.controller;


import com.example.board.dto.CommentDto;
import com.example.board.dto.CommentRequestDto;
import com.example.board.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class CommentController {

    private final CommentService commentService;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/comments/{boardId}")
    public CommentDto writerComment(@PathVariable Long boardId, @RequestBody CommentRequestDto requestDto){
        return commentService.writeComment(boardId, requestDto);
    }
}
