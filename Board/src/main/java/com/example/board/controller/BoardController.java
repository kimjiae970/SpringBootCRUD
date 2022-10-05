package com.example.board.controller;

import com.example.board.dto.*;
import com.example.board.repository.BoardRepository;
import com.example.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class BoardController {

    private final BoardRepository boardRepository;
    private final BoardService boardService;


    @GetMapping("/api/board") //메인 리스트를 가져오는 api
    public GetListResponse getlist(){ //불러오는 메소드
        return boardService.get(); //결국 반환되어야 하는 것
    }

    @PostMapping("/api/board")
    public CreateAndDeleteResponse createlist(@RequestBody BoardRequestDto requestDto){
        return boardService.save(requestDto);
    }

    @GetMapping("/api/board/{id}")
    public GetDetailResponse getdetail(@PathVariable Long id){
        return boardService.getDetail(id);
    }


    @PostMapping("/api/board/{id}")
    public BoardResponse chechpw(@PathVariable Long id, @RequestBody PwRequestDto requestDto){
        return boardService.checkpw(id, requestDto);
    }

    @PutMapping("/api/board/{id}")
    public UpdateResponse updatelist(@PathVariable Long id, @RequestBody BoardRequestDto requestDto){
        return boardService.update(id, requestDto);
    }

    @DeleteMapping("/api/board/{id}")
    public CreateAndDeleteResponse deletelist(@PathVariable Long id){
        return boardService.delete(id);
    }
}
