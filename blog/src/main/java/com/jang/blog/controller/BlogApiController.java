package com.jang.blog.controller;

import com.jang.blog.domain.Article;
import com.jang.blog.dto.AddArticleRequest;
import com.jang.blog.dto.ArticleResponse;
import com.jang.blog.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController //http Response Body에 객체 데이터를 json 형식으로 반환하는(return) 컨트롤러
public class BlogApiController {

    private final BlogService blogService;

    @PostMapping("/api/articles") //ResponseEntity - HttpEntity 이며, @RequestBody는 body 내용을 가져온다.
    public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest request) {
        Article savedArticle = blogService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedArticle);
    }

    @GetMapping("/api/articles")
    public ResponseEntity<List<ArticleResponse>> findAllArticles() {
        List<ArticleResponse> articles = blogService.findAll() //Article로 반환되고 stream으로 변경하고 ArticleResponse로 변경하고 List로 변경
                .stream()
                .map(ArticleResponse::new)
                .toList();

        return ResponseEntity.ok().body(articles);

    }
}
