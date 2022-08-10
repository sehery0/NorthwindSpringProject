package com.etiya.northwind.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.northwind.business.abstracts.CustomerService;
import com.etiya.northwind.business.requests.customers.CreateCustomerRequest;
import com.etiya.northwind.business.requests.customers.DeleteCustomerRequest;
import com.etiya.northwind.business.requests.customers.UpdateCustomerRequest;
import com.etiya.northwind.business.responses.customers.ListCustomerResponse;
import com.etiya.northwind.business.responses.customers.ReadCustomerResponse;

@RestController
@RequestMapping("/api/customers")
public class CustomersController {
	private CustomerService customerService;

	@Autowired
	public CustomersController(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@GetMapping("/getall")
	public List<ListCustomerResponse> getAll(){
		return this.customerService.getAll();
	}
	
	@PostMapping("/add")
    public void add(@RequestBody CreateCustomerRequest createCustomerRequest) {
        this.customerService.add(createCustomerRequest);
    }

    @PostMapping("/delete")
    public void delete(@RequestBody DeleteCustomerRequest deleteCustomerRequest) {
        this.customerService.delete(deleteCustomerRequest);
    }

    @PostMapping("/update")
    public void update(@RequestBody UpdateCustomerRequest updateCustomerRequest) {
        this.customerService.update(updateCustomerRequest);
    }

    @GetMapping("/getbyid")
    public ReadCustomerResponse findById(@RequestParam String customerId) {
        return this.customerService.findById(customerId);
    }
	

}
