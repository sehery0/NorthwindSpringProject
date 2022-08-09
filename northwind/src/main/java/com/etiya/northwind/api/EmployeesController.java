package com.etiya.northwind.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.northwind.business.abstracts.EmployeeService;

import com.etiya.northwind.business.requests.employees.CreateEmployeeRequest;
import com.etiya.northwind.business.requests.employees.DeleteEmployeeRequest;
import com.etiya.northwind.business.requests.employees.UpdateEmployeeRequest;
import com.etiya.northwind.business.responses.employees.ListEmployeeResponse;
import com.etiya.northwind.business.responses.employees.ReadEmployeeResponse;

@RestController
@RequestMapping("/api/employees")
public class EmployeesController {
	private EmployeeService employeeService;

	@Autowired
	public EmployeesController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping("/getall")
	public List<ListEmployeeResponse> getAll(){
		return this.employeeService.getAll();
	}
	
	@PostMapping("/add")
	public void add(@RequestBody CreateEmployeeRequest createEmployeeRequest) {
		this.employeeService.add(createEmployeeRequest);
	}
	
	@PostMapping("/update")
	public void update(@RequestBody UpdateEmployeeRequest updateEmployeeRequest) {
		this.employeeService.update(updateEmployeeRequest);
	}
	
	@PostMapping("/delete")
	public void delete(@RequestBody DeleteEmployeeRequest deleteEmployeeRequest) {
		this.employeeService.delete(deleteEmployeeRequest);
	}
	
	@GetMapping("/getbyıd")
	public ReadEmployeeResponse findById(@RequestParam int id) {
		return this.employeeService.findById(id);
	}

}
