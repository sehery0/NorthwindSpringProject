package com.etiya.northwind.business.responses.orderdetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReadOrderDetailResponse {
	private int orderId;
	private int productId;

}
