package com.example.board.service;

import com.example.board.dto.CommentRequestDto;
import com.example.board.dto.ResponseDto;
import com.example.board.entity.Board;
import com.example.board.entity.Comment;
import com.example.board.entity.Users;
import com.example.board.repository.BoardRepository;
import com.example.board.repository.CommentRepository;
import com.example.board.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    private final BoardRepository boardRepository;
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;

    @Autowired
    public CommentService(BoardRepository boardRepository, CommentRepository commentRepository, UserRepository userRepository) {
        this.boardRepository = boardRepository;
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
    }

    public ResponseDto<?> addComment(CommentRequestDto requestDto, Users user ) {
        Board board = boardRepository.findById( requestDto.getPostId() )
                .orElseThrow( () -> new NullPointerException("게시글이 존재하지 않습니다") );

        Comment comment = new Comment( requestDto, user , board );

        commentRepository.save( comment );

        return ResponseDto.success( comment );



    }

    public ResponseDto<?> getComments( Long id ) {

        Board board = boardRepository.findById( id )
                .orElseThrow( () -> new NullPointerException("게시글이 존재하지 않습니다") );

        List<Comment> commentList = commentRepository.findAllByBoard( board );

        return ResponseDto.success( commentList );

    }

    public ResponseDto<?> updateComment(Long id, CommentRequestDto requestDto , Users user) {

        Board board = boardRepository.findById( requestDto.getPostId() )
                .orElseThrow(() -> new RuntimeException("게시글이 없습니다."));

        Comment comment = commentRepository.findById( id )
                .orElseThrow(() -> new RuntimeException("댓글이 없습니다."));

        if( !comment.getUser().getUsername().equals( user.getUsername() ) ){
            throw new RuntimeException("본인이 작성한 댓글이 아닙니다.");
        }

        comment.updateComment( requestDto );

        commentRepository.save( comment );

        return ResponseDto.success(comment);
    }

    public ResponseDto<?> deleteComment( Long id , Users user) {

        Comment comment = commentRepository.findById( id )
                .orElseThrow(() -> new RuntimeException("댓글이 없습니다."));

        if( !comment.getUser().getUsername().equals( user.getUsername() ) ){
            throw new RuntimeException("본인이 작성한 댓글이 아닙니다.");
        }
        commentRepository.deleteById( id );

        return ResponseDto.success("delete success");

    }
}