package com.etiya.northwind.business.abstracts;

import java.util.List;

import com.etiya.northwind.business.requests.suppliers.CreateSupplierRequest;
import com.etiya.northwind.business.requests.suppliers.DeleteSupplierRequest;
import com.etiya.northwind.business.requests.suppliers.UpdateSupplierRequest;
import com.etiya.northwind.business.responses.suppliers.ReadSupplierResponse;
import com.etiya.northwind.business.responses.suppliers.ListSupplierResponse;

public interface SupplierService {
	List<ListSupplierResponse> getAll();
	void add(CreateSupplierRequest createSupplierRequest);
	void delete(DeleteSupplierRequest deleteSupplierRequest);
	void update(UpdateSupplierRequest updateSupplierRequest);
	ReadSupplierResponse findById(int id);

}
