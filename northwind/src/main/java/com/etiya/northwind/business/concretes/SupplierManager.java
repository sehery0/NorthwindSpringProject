package com.etiya.northwind.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.northwind.business.abstracts.SupplierService;
import com.etiya.northwind.business.responses.suppliers.SupplierListResponse;
import com.etiya.northwind.dataAccess.abstracts.SupplierRepository;
import com.etiya.northwind.entities.concretes.Supplier;

@Service
public class SupplierManager implements SupplierService{
	
	private SupplierRepository supplierRepository;
	
	@Autowired
	public SupplierManager(SupplierRepository supplierRepository) {
		this.supplierRepository = supplierRepository;
	}


	@Override
	public List<SupplierListResponse> getAll() {
		List<Supplier> result = this.supplierRepository.findAll();
		List<SupplierListResponse> response = new ArrayList<SupplierListResponse>();
		
		for (Supplier supplier : result) {
			SupplierListResponse responseSupplier = new SupplierListResponse();
			responseSupplier.setSupplierId(supplier.getSupplierId());
			responseSupplier.setAddress(supplier.getAddress());
			responseSupplier.setRegion(supplier.getRegion());
			
			response.add(responseSupplier);
		}
		return response;
	}

}
