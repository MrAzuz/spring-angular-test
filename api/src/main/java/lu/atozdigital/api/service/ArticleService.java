package lu.atozdigital.api.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import lu.atozdigital.api.dto.ArticleDto;
import lu.atozdigital.api.entities.Article;

public interface ArticleService {
	public Article addArticle(ArticleDto articleDto, MultipartFile multipartFile) throws IOException;
	public Optional<Article> getArticleById(Long id);

}
