package lu.atozdigital.api.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lu.atozdigital.api.dto.ArticleDto;
import lu.atozdigital.api.entities.Article;
import lu.atozdigital.api.service.ArticleService;

@RestController
@RequestMapping("/api")
public class ArticleController {

	@Autowired
	ArticleService articleService;

	@PostMapping("/articles")
	public ResponseEntity<Article> createArticle(@ModelAttribute ArticleDto articleDto,
			@RequestParam("file") MultipartFile multipartFile) {

		try {
			Article article = articleService.addArticle(articleDto, multipartFile);
			return new ResponseEntity<>(article, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("articles/{id}")
	public ResponseEntity<Article> getArticle(@PathVariable("id") Long articleId) {

		Optional<Article> articleData = articleService.getArticleById(articleId);

		if (articleData.isPresent()) {
			return new ResponseEntity<>(articleData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}

}
