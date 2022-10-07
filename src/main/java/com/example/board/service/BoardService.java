package com.example.board.service;

import com.example.board.dto.*;
import com.example.board.entity.Board;
import com.example.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;


    public List <BoardListResponseDto> findAllBoard(){
        List<Board> board = boardRepository.findAllByOrderByCreatedAtDesc();
        return board.stream().map(BoardListResponseDto::new).collect(Collectors.toList());
    }


    public BoardResponseDto save(BoardRequestDto requestDto){
        Board board= new Board(requestDto);
        boardRepository.save(board);
        return new BoardResponseDto(board);
    }


    public BoardResponseDto getDetail(Long id){
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디값이 없습니다")
        );
        return new BoardResponseDto(board);
    }


    public BoardResponseDto checkpw(Long id, PwRequestDto requestDto){
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디값이 없습니다")
        );
        if(!board.getPassword().equals(requestDto.getPassword())){
            throw new IllegalArgumentException("비밀번호 에러!");
        }
        return new BoardResponseDto(board);
    }

    @Transactional
    public BoardResponseDto update(Long id, BoardRequestDto requestDto){
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디값이 없습니다")
        );

        board.update(requestDto);
        return new BoardResponseDto(board);
    }


    public BoardListResponseDto delete(Long id){
        boardRepository.deleteById(id);
        return new BoardListResponseDto();
    }
}
