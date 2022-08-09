package com.etiya.northwind.business.requests.orderdetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrderDetailRequest {
	private int orderId;
	private int productId;
	private int quantity;

}
