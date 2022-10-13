package com.example.board.entity;


import com.example.board.dto.CommentRequestDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idx;

    @Column(length = 100, nullable = false)
    private String content;

    @Column(length = 100, nullable = false)
    private String writer;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Users user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    @OnDelete(action = OnDeleteAction.CASCADE) //연관된 보드가 삭제시 같이 삭제된다
    private Board board;

   public Comment(CommentRequestDto requestDto, Users user, Board board){
       this.content = requestDto.getContent();
       this.writer = user.getUsername();
       this.user = user;
       this.board = board;
   }
   public void updateComment(CommentRequestDto requestDto){

       this.content = requestDto.getContent(); //게시물내용렂게리츠
   }
}
