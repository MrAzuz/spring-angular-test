package lu.atozdigital.api.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lu.atozdigital.api.dto.ArticleDto;
import lu.atozdigital.api.entities.Article;
import lu.atozdigital.api.repository.ArticleRepository;
import lu.atozdigital.api.util.FileUploadUtil;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private ArticleRepository articleRepository;

	@Override
	public Article addArticle(ArticleDto articleDto, MultipartFile multipartFile) throws IOException {

		Article article = new Article();

		String fileName = articleRepository.save(article).getId().toString() + ".png";

		article.setName(articleDto.getName());
		article.setPrice(articleDto.getPrice());
		article.setPicture(fileName);

		// upload directory
		String uploadDir = "articles-images/";
		FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);

		return articleRepository.save(article);
	}

	@Override
	public Optional<Article> getArticleById(Long id) {
		
		return articleRepository.findById(id);
	}

	@Override
	public List<Article> getArticles() {
		
		List<Article> articles = new ArrayList<Article>();
		articleRepository.findAll().forEach(articles::add);
		return articles;
	}


}
