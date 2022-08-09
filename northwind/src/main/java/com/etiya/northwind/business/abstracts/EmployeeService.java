package com.etiya.northwind.business.abstracts;

import java.util.List;

import com.etiya.northwind.business.requests.employees.CreateEmployeeRequest;
import com.etiya.northwind.business.requests.employees.DeleteEmployeeRequest;
import com.etiya.northwind.business.requests.employees.UpdateEmployeeRequest;
import com.etiya.northwind.business.responses.employees.ListEmployeeResponse;
import com.etiya.northwind.business.responses.employees.ReadEmployeeResponse;

public interface EmployeeService {
	List<ListEmployeeResponse> getAll();
	void add(CreateEmployeeRequest createEmployeeRequest);
	void update(UpdateEmployeeRequest updateEmployeeRequest);
	void delete(DeleteEmployeeRequest deleteEmployeeRequest);
	ReadEmployeeResponse findById(int id);

}
