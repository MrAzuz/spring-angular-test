package lu.atozdigital.api.web;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import lu.atozdigital.api.entities.Article;
import lu.atozdigital.api.repository.ArticleRepository;
import lu.atozdigital.api.repository.OrderRepository;
import lu.atozdigital.api.service.ArticleService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ArticleController.class)

public class ArticleControllerTest {

	@Autowired
	MockMvc mockMvc;
	@Autowired
	ObjectMapper mapper;
	@MockBean
	ArticleService articleService;
	@MockBean
	ArticleRepository articleRepository;
	@MockBean
	OrderRepository orderRepository;

	Article article1 = new Article(1L, "Camera", BigDecimal.valueOf(999), "1.png");
	Article article2 = new Article(2L, "Phone", BigDecimal.valueOf(999), "2.png");
	Article article3 = new Article(3L, "Laptop", BigDecimal.valueOf(999), "3.png");

	@Test
	public void testGetAllArticles() throws Exception {

		List<Article> articles = Arrays.asList(article1, article2, article3);

		Mockito.when(articleService.getArticles()).thenReturn(articles);

		mockMvc.perform(MockMvcRequestBuilders.get("/api/articles").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(3)))
				.andExpect(jsonPath("$[2].name", is("Laptop")));
	}

	@Test
	public void testGetArticle() throws Exception {

		Mockito.when(articleService.getArticleById(1L)).thenReturn(java.util.Optional.of(article1));

		mockMvc.perform(MockMvcRequestBuilders.get("/api/articles/1").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(jsonPath("$", notNullValue()))
				.andExpect(jsonPath("$.name", is("Camera")));
	}

}
