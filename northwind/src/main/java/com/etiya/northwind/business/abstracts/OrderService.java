package com.etiya.northwind.business.abstracts;

import java.util.List;

import com.etiya.northwind.business.requests.orders.CreateOrderRequest;
import com.etiya.northwind.business.requests.orders.DeleteOrderRequest;
import com.etiya.northwind.business.requests.orders.UpdateOrderRequest;
import com.etiya.northwind.business.responses.orders.ListOrderResponse;
import com.etiya.northwind.business.responses.orders.ReadOrderResponse;

public interface OrderService {
	List<ListOrderResponse> getAll();
	void add(CreateOrderRequest createOrderRequest);
	void delete(DeleteOrderRequest deleteOrderRequest);
	void update(UpdateOrderRequest updateOrderRequest);	
	ReadOrderResponse findById(int id);
}
