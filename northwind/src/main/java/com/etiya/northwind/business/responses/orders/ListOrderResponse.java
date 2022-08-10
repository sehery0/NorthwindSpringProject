package com.etiya.northwind.business.responses.orders;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListOrderResponse {
	private int orderId;
	private Date orderDate;
	private String companyName;
	private String contactName;
	private String firstName;
	private String lastName;


}
