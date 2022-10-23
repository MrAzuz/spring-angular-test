package lu.atozdigital.api.web;

import static org.hamcrest.Matchers.*;

import static org.mockito.Mockito.doReturn;
import static org.mockito.ArgumentMatchers.any;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.math.BigDecimal;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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

import lu.atozdigital.api.dto.OrderDto;
import lu.atozdigital.api.entities.Article;
import lu.atozdigital.api.entities.Order;
import lu.atozdigital.api.repository.ArticleRepository;
import lu.atozdigital.api.repository.OrderRepository;
import lu.atozdigital.api.service.OrderService;
import lu.atozdigital.api.util.RandomString;

@ExtendWith(SpringExtension.class)
@WebMvcTest(OrderContoller.class)
public class OrderControllerTest {

	@Autowired
	MockMvc mockMvc;
	@Autowired
	ObjectMapper mapper;
	@MockBean
	OrderService orderService;
	@MockBean
	OrderRepository orderRepository;
	@MockBean
	ArticleRepository articleRepository;

	Article article1 = new Article(1L, "Camera", BigDecimal.valueOf(999), "1.png");
	Article article2 = new Article(2L, "Phone", BigDecimal.valueOf(999), "2.png");

	List<Article> articles = Arrays.asList(article1, article2);

	Order order1 = new Order(1L, RandomString.getAlphaNumericString(10), new Date(), articles);
	Order order2 = new Order(2L, RandomString.getAlphaNumericString(10), new Date(), articles);
	Order order3 = new Order(3L, RandomString.getAlphaNumericString(10), new Date(), articles);

	@Test
	public void testGetAllOrders() throws Exception {

		List<Order> orders = Arrays.asList(order1, order2, order3);

		Mockito.when(orderService.getOrders()).thenReturn(orders);

		mockMvc.perform(MockMvcRequestBuilders.get("/api/orders").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(3))).andExpect(jsonPath("$[2].id", is(3)));
	}

	@Test
	public void testCreateOrder() throws Exception {

		String randomStr = RandomString.getAlphaNumericString(10);
		Date date = new Date();
		OrderDto orderToPost = new OrderDto(randomStr, date, articles);
		Order orderToReturn = new Order(1L, orderToPost.getReference(), orderToPost.getDate(),
				orderToPost.getArticles());

		doReturn(orderToReturn).when(orderService).addOrder(any());

		// Execute the POST request
		mockMvc.perform(post("/api/orders").contentType(MediaType.APPLICATION_JSON)
				.content(this.mapper.writeValueAsString(orderToPost)))

				.andExpect(status().isCreated()).andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().is(201)).andExpect(jsonPath("$.id", is(1)))
				.andExpect(jsonPath("$.reference", is(randomStr)));

	}

	/*
	 * @Test public void testUpdateOrder() throws Exception { // Setup our mocked
	 * service String randomStr = RandomString.getAlphaNumericString(10); Date date
	 * = new Date();
	 * 
	 * OrderDto orderToPut = new OrderDto(randomStr, date, articles);
	 * 
	 * Order orderToReturnFindBy = new Order(1L, orderToPut.getReference(),
	 * orderToPut.getDate(), orderToPut.getArticles());
	 * 
	 * Order orderToReturnSave = new Order(1L, orderToPut.getReference(),
	 * orderToPut.getDate(), orderToPut.getArticles());
	 * 
	 * doReturn(Optional.of(orderToReturnFindBy)).when(orderService).getOrderById(1L
	 * );
	 * 
	 * doReturn(orderToReturnSave).when(orderService).addOrder(any());
	 * 
	 * // Execute the POST request mockMvc.perform(put("/api/orders/" +
	 * 1).contentType(MediaType.APPLICATION_JSON)
	 * .content(this.mapper.writeValueAsString(orderToPut)))
	 * 
	 * // Validate the response code and content type
	 * .andExpect(status().isOk()).andExpect(content().contentType(MediaType.
	 * APPLICATION_JSON)) // Validate the returned fields
	 * .andExpect(jsonPath("$.id", is(1))).andExpect(jsonPath("$.reference",
	 * is(randomStr))); }
	 */

}
