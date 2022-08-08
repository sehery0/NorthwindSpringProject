package com.etiya.northwind.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.northwind.business.abstracts.CustomerService;
import com.etiya.northwind.business.responses.customers.CustomerListResponse;
import com.etiya.northwind.dataAccess.abstracts.CustomerRepository;
import com.etiya.northwind.entities.concretes.Customer;

@Service
public class CustomerManager implements CustomerService{
	
	private CustomerRepository customerRepository;
	
	@Autowired
	public CustomerManager(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}


	@Override
	public List<CustomerListResponse> getAll() {
		List<Customer> result = this.customerRepository.findAll();
		List<CustomerListResponse> response = new ArrayList<CustomerListResponse>();
		
		for (Customer customer : result) {
			CustomerListResponse responseCustomer = new CustomerListResponse();
			responseCustomer.setCustomerId(customer.getCustomerId());
			responseCustomer.setCompanyName(customer.getCompanyName());
			responseCustomer.setContactName(customer.getContactName());
			
			response.add(responseCustomer);
			
		}
		return response;
	}

}
