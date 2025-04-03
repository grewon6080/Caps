package com.jang.blog.service;

import com.jang.blog.domain.Article;
import com.jang.blog.dto.AddArticleRequest;
import com.jang.blog.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BlogService {

    private final BlogRepository blogRepository;

    public Article save(AddArticleRequest request) {
        return blogRepository.save(request.toEntity()); //save는 CrudRepository.class 의 메소드 사용
    }

    public List<Article> findAll() {
        return blogRepository.findAll(); //findAll() 은 ListCrudRepository.class 의 메소드 사용
    }
}
