package dev.hyeon.springbootdeveloper.repository;

import dev.hyeon.springbootdeveloper.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BlogRepository extends JpaRepository<Article, Long> {
}
