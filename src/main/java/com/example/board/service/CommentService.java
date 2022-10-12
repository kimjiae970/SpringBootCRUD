package com.example.board.service;

import com.example.board.dto.CommentDto;
import com.example.board.dto.CommentRequestDto;
import com.example.board.entity.Board;
import com.example.board.entity.Comment;
import com.example.board.repository.BoardRepository;
import com.example.board.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;

    @Transactional
    public CommentDto writeComment(Long boardId, CommentRequestDto requestDto){
        Comment comment = new Comment();
        comment.setContent(comment.getContent());

        Board board = boardRepository.findById(boardId).orElseThrow(
                ()  -> new IllegalArgumentException("게시물을 찾을 수 없습니다")
      );

        comment.setWriter(requestDto.getWriter());
        comment.setBoard(board);
        commentRepository.save(comment);

        return new CommentDto(comment);

}
}
