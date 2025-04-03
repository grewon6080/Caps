package com.jang.blog.dto;

import com.jang.blog.domain.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor //기본 생성자 추가
@AllArgsConstructor //모든 필드 값을 파라미터로 받는 생성자 추가
@Getter
public class AddArticleRequest {

    private String title;
    private String content;

    public Article toEntity() { //블로그 글을 추가할 때 저장할 엔티티로 변환하는 용도로 사용됨
        return Article.builder()
                .title(title)
                .content(content)
                .build();
    }

}
