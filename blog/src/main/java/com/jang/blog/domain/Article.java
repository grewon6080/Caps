package com.jang.blog.domain;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

@Entity //엔티티로 지정
@Getter
public class Article {

    @Id// id 필드를 기본키로 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) //기본키를 자동으로 1씩 증가
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    protected Article() {}


    @Builder// 빌터 패던으로 객체 생성
    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }

}
