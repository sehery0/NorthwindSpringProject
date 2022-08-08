package com.etiya.northwind.business.abstracts;

import java.util.List;

import com.etiya.northwind.business.responses.orderdetails.OrderDetailListResponse;

public interface OrderDetailService {
	List<OrderDetailListResponse> getAll();

}
