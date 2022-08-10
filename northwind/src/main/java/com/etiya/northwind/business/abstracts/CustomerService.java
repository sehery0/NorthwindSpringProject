package com.etiya.northwind.business.abstracts;

import java.util.List;

import com.etiya.northwind.business.requests.customers.CreateCustomerRequest;
import com.etiya.northwind.business.requests.customers.DeleteCustomerRequest;
import com.etiya.northwind.business.requests.customers.UpdateCustomerRequest;
import com.etiya.northwind.business.responses.customers.ListCustomerResponse;
import com.etiya.northwind.business.responses.customers.ReadCustomerResponse;

public interface CustomerService {
	List<ListCustomerResponse> getAll();
	void add(CreateCustomerRequest createCustomerRequest);
	void update(UpdateCustomerRequest updateCustomerRequest);
	void delete(DeleteCustomerRequest deleteCustomerRequest);
	ReadCustomerResponse findById(String id);

}
