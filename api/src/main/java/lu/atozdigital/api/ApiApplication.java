package lu.atozdigital.api;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lu.atozdigital.api.entities.Article;
import lu.atozdigital.api.repository.ArticleRepository;

@SpringBootApplication
public class ApiApplication implements CommandLineRunner {
	@Autowired
	private ArticleRepository articleRepository;
	

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
		
		System.out.println("Done !");

		
		
	}

}
