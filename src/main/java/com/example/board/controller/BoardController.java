package com.example.board.controller;

import com.example.board.dto.*;
import com.example.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/api/board")
    public List<BoardListResponseDto> getlist() {
        return boardService.findAllBoard();
    }

    @PostMapping("/api/board")
    public BoardResponseDto createlist(@RequestBody BoardRequestDto requestDto){
        return boardService.save(requestDto);
    }

    @GetMapping("/api/board/{id}")
    public BoardResponseDto getdetail(@PathVariable Long id){
        return boardService.getDetail(id);
    }

   @PostMapping("/api/board/{id}")
    public BoardResponseDto chechpw(@PathVariable Long id, @RequestBody PwRequestDto requestDto){
        return boardService.checkpw(id, requestDto);
    }

    @PutMapping("/api/board/{id}")
    public BoardResponseDto updatelist(@PathVariable Long id, @RequestBody BoardRequestDto requestDto){
        return boardService.update(id, requestDto);
    }

    @DeleteMapping("/api/board/{id}")
    public BoardListResponseDto deletelist(@PathVariable Long id){
        return boardService.delete(id);
    }
}
