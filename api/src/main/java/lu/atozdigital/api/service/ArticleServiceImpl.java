package lu.atozdigital.api.service;

import java.io.IOException;

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

		//upload directory 
		String uploadDir = "articles-images/";
		FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);

		return articleRepository.save(article);
	}

	@Override
	public Article updateInfos(Long id, ArticleDto articleDto) {
		Article article = articleRepository.findById(id).get();
		article.setName(articleDto.getName());
		article.setPrice(articleDto.getPrice());
		return articleRepository.save(article);
	}

}
