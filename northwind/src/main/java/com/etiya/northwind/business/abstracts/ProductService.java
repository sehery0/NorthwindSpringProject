package com.etiya.northwind.business.abstracts;

import java.util.List;

import com.etiya.northwind.business.requests.products.CreateProductRequest;
import com.etiya.northwind.business.requests.products.DeleteProductRequest;
import com.etiya.northwind.business.requests.products.UpdateProductRequest;
import com.etiya.northwind.business.responses.products.ListProductResponse;
import com.etiya.northwind.business.responses.products.ReadProductResponse;

public interface ProductService {
	List<ListProductResponse> getAll();
	void add(CreateProductRequest createProductRequest);
	void delete(DeleteProductRequest deleteProductRequest);
	void update(UpdateProductRequest updateProductRequest);
	ReadProductResponse findById(int id);

}
