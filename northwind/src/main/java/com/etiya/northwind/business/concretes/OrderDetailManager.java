package com.etiya.northwind.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.northwind.business.abstracts.OrderDetailService;
import com.etiya.northwind.business.requests.orderdetails.CreateOrderDetailRequest;
import com.etiya.northwind.business.requests.orderdetails.DeleteOrderDetailRequest;
import com.etiya.northwind.business.requests.orderdetails.UpdateOrderDetailRequest;
import com.etiya.northwind.business.responses.orderdetails.ListOrderDetailResponse;
import com.etiya.northwind.business.responses.orderdetails.ReadOrderDetailResponse;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.dataAccess.abstracts.OrderDetailRepository;
import com.etiya.northwind.entities.concretes.OrderDetail;

@Service
public class OrderDetailManager implements OrderDetailService{

	private OrderDetailRepository orderDetailRepository;
	private ModelMapperService modelMapperService;
	
	@Autowired
	public OrderDetailManager(OrderDetailRepository orderDetailRepository, ModelMapperService modelMapperService) {
		super();
		this.orderDetailRepository = orderDetailRepository;
		this.modelMapperService = modelMapperService;
	}


	@Override
	public List<ListOrderDetailResponse> getAll() {
		List<OrderDetail> result = this.orderDetailRepository.findAll();
		List<ListOrderDetailResponse> response = result.stream().map(
				orderDetail -> this.modelMapperService.forResponse().map(orderDetail, ListOrderDetailResponse.class))
				.collect(Collectors.toList());
		return response;
	}


	@Override
	public void add(CreateOrderDetailRequest createOrderDetailRequest) {
		OrderDetail orderDetail = this.modelMapperService.forRequest().map(createOrderDetailRequest, OrderDetail.class);
		this.orderDetailRepository.save(orderDetail);
	}

	@Override
	public void update(UpdateOrderDetailRequest updateOrderDetailRequest) {
		OrderDetail orderDetail = this.modelMapperService.forRequest().map(updateOrderDetailRequest, OrderDetail.class);
		this.orderDetailRepository.save(orderDetail);
		
	}
	@Override
	public void delete(DeleteOrderDetailRequest deleteOrderDetailRequest) {
		OrderDetail orderDetail = this.modelMapperService.forRequest().map(deleteOrderDetailRequest, OrderDetail.class);
		this.orderDetailRepository.delete(orderDetail);
		
	}

	@Override
	public ReadOrderDetailResponse findById(int orderId, int productId) {
		OrderDetail orderDetail = this.orderDetailRepository.findByOrder_OrderIdAndProduct_ProductId(orderId,productId);
		ReadOrderDetailResponse response = this.modelMapperService.forResponse().map(orderDetail, ReadOrderDetailResponse.class);
		return response;
	}

}
