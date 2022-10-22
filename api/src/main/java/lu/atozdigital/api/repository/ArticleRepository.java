package lu.atozdigital.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import lu.atozdigital.api.entities.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {

}
