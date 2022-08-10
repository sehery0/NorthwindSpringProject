package com.etiya.northwind.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.northwind.business.abstracts.OrderDetailService;
import com.etiya.northwind.business.requests.orderdetails.CreateOrderDetailRequest;
import com.etiya.northwind.business.requests.orderdetails.DeleteOrderDetailRequest;
import com.etiya.northwind.business.requests.orderdetails.UpdateOrderDetailRequest;
import com.etiya.northwind.business.responses.orderdetails.ListOrderDetailResponse;
import com.etiya.northwind.business.responses.orderdetails.ReadOrderDetailResponse;

@RestController
@RequestMapping("/api/orderdetails")
public class OrderDetailsController {
	private OrderDetailService orderDetailService;

	public OrderDetailsController(OrderDetailService orderDetailService) {
		this.orderDetailService = orderDetailService;
	}
	
	@GetMapping("/getall")
	public List<ListOrderDetailResponse> getAll(){
		return this.orderDetailService.getAll();
	}

	@PostMapping("/add")
	public void add(@RequestBody CreateOrderDetailRequest createOrderDetailRequest){
		this.orderDetailService.add(createOrderDetailRequest);
	}
	
	@PostMapping("/delete")
	public void delete(@RequestBody DeleteOrderDetailRequest deleteOrderDetailRequest){
		this.orderDetailService.delete(deleteOrderDetailRequest);
	}
	
	@PostMapping("/update")
	public void update(@RequestBody UpdateOrderDetailRequest updateOrderDetailRequest){
		this.orderDetailService.update(updateOrderDetailRequest);
	}
	
	
	@GetMapping("/getbyid")
	public ReadOrderDetailResponse findById(@RequestParam int orderId,@RequestParam int productId){
		return this.orderDetailService.findById(orderId,productId);
	}
}
