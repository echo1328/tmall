package com.tmall.search.repositories;

import com.tmall.search.entity.Article;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ArticleRepository extends ElasticsearchRepository<Article, Integer> {

    List<Article> findByTitle(String title);

    List<Article> findByTitleLike(String title);

    List<Article> findByTitleOrContent(String title, String content);

    List<Article> findByTitleOrContent(String title, String content, Pageable pageable);

}
