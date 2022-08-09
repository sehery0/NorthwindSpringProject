package com.etiya.northwind.business.requests.employees;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateEmployeeRequest {
	private String employeeId;

	private String firstName;

	
	private String lastName;

}
