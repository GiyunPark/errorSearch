package com.giyun.errorsearch.domain;

import com.giyun.errorsearch.domain.enums.BoardType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table
@Getter
@NoArgsConstructor
@Entity
public class Board {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column
    private String title;

    @Column
    private String content;

    @Column
    @Enumerated(EnumType.STRING)
    private BoardType boardType;

    @Column
    private LocalDateTime createdDate;

    @Column
    private LocalDateTime updatedDate;

    @Builder
    public Board(String title, String content, BoardType boardType,
                 LocalDateTime createdDate, LocalDateTime updatedDate){
        this.title=title;
        this.content=content;
        this.boardType=boardType;
        this.createdDate=createdDate;
        this.updatedDate=updatedDate;
    }

}
