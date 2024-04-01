package com.estsoft.for1person.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long articleId; // 게시글 아이디 (PK)

    @Column(nullable = false)
    private String title; // 제목

    @Column(nullable = false)
    private String content; // 내용

    @Column(nullable = false)
    private Long views; // 조회수

    @Column(nullable = false)
    private Boolean anonymous; // 익명 여부

    @CreationTimestamp
    @Column(nullable = false)
    private Timestamp createdAt; // 생성 날짜

    @Column(nullable = false)
    private Integer need; // 필요

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "article_writer_id")
    private User user; // 작성자 정보 (FK)

    @Builder
    public Article(String title,String content, Long views,Boolean anonymous,Integer need,User user)
    {
        this.title = title;
        this.content = content;
        this.views = views;
        this.anonymous = anonymous;
        this.need = need;
        this.user = user;
    }
}


