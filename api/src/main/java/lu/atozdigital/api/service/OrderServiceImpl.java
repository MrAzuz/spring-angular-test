package lu.atozdigital.api.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lu.atozdigital.api.entities.Order;
import lu.atozdigital.api.repository.OrderRepository;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepository orderRepository;

	@Override
	public List<Order> getOrders() {
		List<Order> orders = new ArrayList<Order>();
		orderRepository.findAll().forEach(orders::add);
		return orders;
	}

}
