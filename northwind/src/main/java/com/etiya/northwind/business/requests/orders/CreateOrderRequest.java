package com.etiya.northwind.business.requests.orders;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrderRequest {

	private LocalDate orderDate;
	private String contactName;
	private int employeeId;
	private String customerId;

}
