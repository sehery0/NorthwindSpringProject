package com.etiya.northwind.business.responses.employees;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListEmployeeResponse {
	private String employeeId;
	
	private String firstName;
	
	private String lastName;

}
