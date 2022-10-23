package lu.atozdigital.api;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import lu.atozdigital.api.web.ArticleController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ApiApplicationTests {

	@Autowired
	ArticleController articleController;
	
	
	@Test
	void contextLoads() {
				
	}

}
