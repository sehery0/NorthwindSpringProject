package com.etiya.northwind.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.northwind.business.abstracts.OrderService;
import com.etiya.northwind.business.responses.orders.OrderListResponse;
import com.etiya.northwind.dataAccess.abstracts.OrderRepository;
import com.etiya.northwind.entities.concretes.Order;

@Service
public class OrderManager implements OrderService{
	private OrderRepository orderRepository;

	@Autowired
	public OrderManager(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	@Override
	public List<OrderListResponse> getAll() {
		List<Order> result = this.orderRepository.findAll();
		List<OrderListResponse> response = new ArrayList<OrderListResponse>();
		
		for (Order order : result) {
			OrderListResponse responseOrder = new OrderListResponse();
			responseOrder.setCompanyName(order.getCustomer().getCompanyName());
			responseOrder.setContactName(order.getCustomer().getContactName());
			responseOrder.setFirstName(order.getEmployee().getFirstName());
			responseOrder.setLastName(order.getEmployee().getLastName());
			responseOrder.setOrderId(order.getOrderId());
			responseOrder.setOrderDate(order.getOrderDate());	
			
			response.add(responseOrder);
			
		}
		return response;
	}
	
	
}
