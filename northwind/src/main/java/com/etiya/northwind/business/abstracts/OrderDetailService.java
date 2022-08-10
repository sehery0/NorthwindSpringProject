package com.etiya.northwind.business.abstracts;

import java.util.List;

import com.etiya.northwind.business.requests.orderdetails.CreateOrderDetailRequest;
import com.etiya.northwind.business.requests.orderdetails.DeleteOrderDetailRequest;
import com.etiya.northwind.business.requests.orderdetails.UpdateOrderDetailRequest;
import com.etiya.northwind.business.responses.orderdetails.ListOrderDetailResponse;
import com.etiya.northwind.business.responses.orderdetails.ReadOrderDetailResponse;

public interface OrderDetailService {
	List<ListOrderDetailResponse> getAll();
	void add(CreateOrderDetailRequest createOrderDetailRequest);
	void update(UpdateOrderDetailRequest updateOrderDetailRequest);
	void delete(DeleteOrderDetailRequest deleteOrderDetailRequest);
	ReadOrderDetailResponse findById(int orderId,int productId);

}
