package com.giyun.errorsearch.domain;

import com.giyun.errorsearch.domain.enums.LanguageType;
import com.giyun.errorsearch.domain.enums.SolveType;
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
    private LanguageType languageType;

    @Column
    private LocalDateTime createdDate;

    @Column
    private LocalDateTime updatedDate;

    @Column
    private SolveType solveType;

    @OneToOne(fetch = FetchType.LAZY)
    private User user;

    @Builder
    public Board(String title, String content, LanguageType languageType,
                 LocalDateTime createdDate, LocalDateTime updatedDate, User user, SolveType solveType){
        this.title=title;
        this.content=content;
        this.languageType = languageType;
        this.createdDate=createdDate;
        this.updatedDate=updatedDate;
        this.user= user;
        this.solveType=solveType;
    }

}
