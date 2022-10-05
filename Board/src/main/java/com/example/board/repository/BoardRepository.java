package com.example.board.repository;

import com.example.board.entity.Board;
import com.example.board.entity.BoardDetail;
import com.example.board.entity.BoardList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {

    List<BoardList> findAllByOrderByCreatedAtDesc(Class<BoardList> boardListClass);

    BoardDetail findById(Long id, Class<BoardDetail> boardDetailClass);
}
