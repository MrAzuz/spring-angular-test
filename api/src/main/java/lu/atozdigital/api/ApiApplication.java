package lu.atozdigital.api;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lu.atozdigital.api.entities.Article;
import lu.atozdigital.api.entities.Order;
import lu.atozdigital.api.repository.ArticleRepository;
import lu.atozdigital.api.repository.OrderRepository;
import lu.atozdigital.api.util.RandomString;

@SpringBootApplication
public class ApiApplication implements CommandLineRunner {
	@Autowired
	private ArticleRepository articleRepository;
	@Autowired
	private OrderRepository orderRepository;
	

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Article a1 = new Article("Phone", BigDecimal.valueOf(140000L), "image1");
		Article a2 = new Article("Laptop", BigDecimal.valueOf(140000L), "image2");
		Article a3 = new Article("Camera", BigDecimal.valueOf(140000L), "image3");
		
		articleRepository.save(a1);
		articleRepository.save(a2);
		articleRepository.save(a3);
		
		List<Article> articles = new ArrayList<>();
		articles.add(a1);
		articles.add(a2);
		articles.add(a3);

		
		Order o1 = new Order();
		o1.setDate(new Date());
		o1.setReference(RandomString.getAlphaNumericString(10));
		o1.setArticles(articles);
		
		Order o2 = new Order();
		o2.setDate(new Date());
		o2.setReference(RandomString.getAlphaNumericString(10));
		o2.setArticles(articles);
		
		orderRepository.save(o2);
		
		//System.out.println(o1.toString());

		
		
	}

}
