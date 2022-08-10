package com.etiya.northwind.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.northwind.business.abstracts.SupplierService;
import com.etiya.northwind.business.requests.suppliers.CreateSupplierRequest;
import com.etiya.northwind.business.requests.suppliers.DeleteSupplierRequest;
import com.etiya.northwind.business.requests.suppliers.UpdateSupplierRequest;
import com.etiya.northwind.business.responses.suppliers.ListSupplierResponse;
import com.etiya.northwind.business.responses.suppliers.ReadSupplierResponse;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.dataAccess.abstracts.SupplierRepository;
import com.etiya.northwind.entities.concretes.Supplier;

@Service
public class SupplierManager implements SupplierService{
	
	private SupplierRepository supplierRepository;
	private ModelMapperService modelMapperService;
	
	@Autowired
	public SupplierManager(SupplierRepository supplierRepository, ModelMapperService modelMapperService) {
		super();
		this.supplierRepository = supplierRepository;
		this.modelMapperService = modelMapperService;
	}



	@Override
	public List<ListSupplierResponse> getAll() {
		List<Supplier> result = this.supplierRepository.findAll();
		List<ListSupplierResponse> response = result.stream()
				.map(supplier -> this.modelMapperService.forResponse().map(supplier, ListSupplierResponse.class))
				.collect(Collectors.toList());
		return response;
	}


	@Override
	public void add(CreateSupplierRequest createSupplierRequest) {
		Supplier supplier = this.modelMapperService.forRequest()
                .map(createSupplierRequest, Supplier.class);

        this.supplierRepository.save(supplier);
		
	}


	@Override
	public void delete(DeleteSupplierRequest deleteSupplierRequest) {
		Supplier supplier = this.modelMapperService.forRequest().map(deleteSupplierRequest, Supplier.class);
		supplierRepository.delete(supplier);
		
	}


	@Override
	public void update(UpdateSupplierRequest updateSupplierRequest) {
		Supplier supplier = this.modelMapperService.forRequest()
                .map(updateSupplierRequest, Supplier.class);
        this.supplierRepository.save(supplier);
	}


	@Override
	public ReadSupplierResponse findById(int id) {
		Supplier supplier =this.supplierRepository.findById(id).get();
        ReadSupplierResponse response = this.modelMapperService.forResponse()
                .map(supplier, ReadSupplierResponse.class);
        return response;
	}

}
