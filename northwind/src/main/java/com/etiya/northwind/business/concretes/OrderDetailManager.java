package com.etiya.northwind.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.northwind.business.abstracts.OrderDetailService;
import com.etiya.northwind.business.responses.orderdetails.OrderDetailListResponse;
import com.etiya.northwind.dataAccess.abstracts.OrderDetailRepository;
import com.etiya.northwind.entities.concretes.OrderDetail;

@Service
public class OrderDetailManager implements OrderDetailService{

	private OrderDetailRepository orderDetailRepository;
	
	@Autowired
	public OrderDetailManager(OrderDetailRepository orderDetailRepository) {
		this.orderDetailRepository = orderDetailRepository;
	}


	@Override
	public List<OrderDetailListResponse> getAll() {
		List<OrderDetail> result = this.orderDetailRepository.findAll();
		List<OrderDetailListResponse> response = new ArrayList<OrderDetailListResponse>();
		
		for (OrderDetail orderDetail: result) {
			OrderDetailListResponse responseOrderDetail = new OrderDetailListResponse();
			responseOrderDetail.setProductId(orderDetail.getProduct().getProductId());
			responseOrderDetail.setProductName(orderDetail.getProduct().getProductName());
			responseOrderDetail.setOrderId(orderDetail.getOrder().getOrderId());
			responseOrderDetail.setContactName(orderDetail.getOrder().getContactName());
			
			response.add(responseOrderDetail);
		}
		return response;
	}

}
