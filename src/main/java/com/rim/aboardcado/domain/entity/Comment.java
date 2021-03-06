package com.rim.aboardcado.domain.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @Column
    private String comment;

    @Column
    private String author;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    @Column
    private LocalDateTime modifiedDate;

    // 원 게시글
    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;

    // 유저 정보
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Member member;


    /* 댓글 수정을 위한 setter */
    public void update(String comment) {
        this.comment = comment;
    }


}
