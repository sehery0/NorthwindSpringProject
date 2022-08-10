package com.etiya.northwind.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.northwind.business.abstracts.SupplierService;
import com.etiya.northwind.business.requests.suppliers.CreateSupplierRequest;
import com.etiya.northwind.business.requests.suppliers.DeleteSupplierRequest;
import com.etiya.northwind.business.requests.suppliers.UpdateSupplierRequest;
import com.etiya.northwind.business.responses.suppliers.ListSupplierResponse;
import com.etiya.northwind.business.responses.suppliers.ReadSupplierResponse;

@RestController
@RequestMapping("/api/suppliers")
public class SupplierController {
	
	private SupplierService supplierService;

	@Autowired
	public SupplierController(SupplierService supplierService) {
		this.supplierService = supplierService;
	}
	
	@GetMapping("/getall")
	public List<ListSupplierResponse> getAll(){
		return this.supplierService.getAll();
	}
	
	@PostMapping("/add")
    public void add(@RequestBody CreateSupplierRequest createSupplierRequest) {
        this.supplierService.add(createSupplierRequest);
    }

    @PostMapping("/delete")
    public void delete(@RequestBody DeleteSupplierRequest deleteSupplierRequest) {
        this.supplierService.delete(deleteSupplierRequest);
    }

    @PostMapping("/update")
    public void update(@RequestBody UpdateSupplierRequest updateSupplierRequest) {
        this.supplierService.update(updateSupplierRequest);
    }

    @GetMapping("/getbyid")
    public ReadSupplierResponse findById(@RequestParam int id) {
        return this.supplierService.findById(id);
    }

}
