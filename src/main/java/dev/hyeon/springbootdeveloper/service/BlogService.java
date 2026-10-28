package dev.hyeon.springbootdeveloper.service;

import dev.hyeon.springbootdeveloper.domain.Article;
import dev.hyeon.springbootdeveloper.dto.AddArticleRequest;
import dev.hyeon.springbootdeveloper.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BlogService {
    private final BlogRepository blogRepository;

    public Article save(AddArticleRequest dto) {
        return blogRepository.save(dto.toEntity());
    }
}
