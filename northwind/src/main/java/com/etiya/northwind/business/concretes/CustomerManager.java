package com.etiya.northwind.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.northwind.business.abstracts.CustomerService;
import com.etiya.northwind.business.requests.customers.CreateCustomerRequest;
import com.etiya.northwind.business.requests.customers.DeleteCustomerRequest;
import com.etiya.northwind.business.requests.customers.UpdateCustomerRequest;
import com.etiya.northwind.business.responses.customers.ListCustomerResponse;
import com.etiya.northwind.business.responses.customers.ReadCustomerResponse;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.dataAccess.abstracts.CustomerRepository;
import com.etiya.northwind.entities.concretes.Customer;

@Service
public class CustomerManager implements CustomerService {

	private CustomerRepository customerRepository;
	private ModelMapperService modelMapperService;

	@Autowired
	public CustomerManager(CustomerRepository customerRepository, ModelMapperService modelMapperService) {
		super();
		this.customerRepository = customerRepository;
		this.modelMapperService = modelMapperService;
		}


	@Override
	public List<ListCustomerResponse> getAll() {
		List<Customer> result = this.customerRepository.findAll();
		List<ListCustomerResponse> response = 
				result.stream().map(customer -> this.modelMapperService.forResponse().
						map(result, ListCustomerResponse.class)).collect(Collectors.toList());
		return response;
	}


	@Override
	public void add(CreateCustomerRequest createCustomerRequest) {
		Customer customer = this.modelMapperService.forRequest().map(createCustomerRequest, Customer.class);
		this.customerRepository.save(customer);
	}


	@Override
	public void update(UpdateCustomerRequest updateCustomerRequest) {
		Customer customer = this.modelMapperService.forRequest().map(updateCustomerRequest, Customer.class);
		this.customerRepository.save(customer);
		
	}


	@Override
	public void delete(DeleteCustomerRequest deleteCustomerRequest) {
		Customer customer = this.modelMapperService.forRequest().map(deleteCustomerRequest, Customer.class);
		this.customerRepository.delete(customer);
	}


	@Override
	public ReadCustomerResponse findById(String customerId) {
		Customer customer = this.customerRepository.findById(customerId).get();
		ReadCustomerResponse response = this.modelMapperService.forRequest().map(customer, ReadCustomerResponse.class);
		return response;
	}


}
