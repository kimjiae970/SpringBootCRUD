package com.example.board.service;

import com.example.board.dto.*;
import com.example.board.entity.Board;
import com.example.board.entity.BoardDetail;
import com.example.board.entity.BoardList;
import com.example.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public GetListResponse get(){
        List<BoardList> boardLists = boardRepository.findAllByOrderByCreatedAtDesc(BoardList.class);
        return new GetListResponse(boardLists);
    }

    @Transactional
    public CreateAndDeleteResponse save(BoardRequestDto requestDto){
        Board board= new Board(requestDto);
        boardRepository.save(board);
        return new CreateAndDeleteResponse(board.getId());
    }

    @Transactional
    public GetDetailResponse getDetail(Long id){
        BoardDetail boardDetail = boardRepository.findById(id, BoardDetail.class);
        return new GetDetailResponse(boardDetail);

    }

    @Transactional
    public BoardResponse checkpw(Long id, PwRequestDto requestDto){
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디값이 없습니다")
        );
        boolean result = board.getPassword().equals(requestDto.getPassword());
        return new BoardResponse(result);
    }

    @Transactional
    public UpdateResponse update(Long id, BoardRequestDto requestDto){
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디값이 없습니다")
        );

        board.update(requestDto);
        return new UpdateResponse(board);
    }

    @Transactional
    public CreateAndDeleteResponse delete(Long id){
        boardRepository.deleteById(id);
        return new CreateAndDeleteResponse(id);
    }
}
