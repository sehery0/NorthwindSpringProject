package com.etiya.northwind.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.northwind.business.abstracts.ProductService;
import com.etiya.northwind.business.responses.products.ProductListResponse;
import com.etiya.northwind.dataAccess.abstracts.ProductRepository;
import com.etiya.northwind.entities.concretes.Product;
@Service
public class ProductManager implements ProductService {

	private ProductRepository productRepository;

	@Autowired // git somutunu bul enjekte et.(dependency enjection)
	public ProductManager(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public List<ProductListResponse> getAll(){ 
		List<Product> result = this.productRepository.findAll();
		List<ProductListResponse> response = new ArrayList<ProductListResponse>();

		for (Product product : result) {
			ProductListResponse responseProduct = new ProductListResponse();
			responseProduct.setCategoryId(product.getCategory().getCategoryId());
			responseProduct.setProductName(product.getCategory().getCategoryName());
			responseProduct.setProductId(product.getProductId());
			responseProduct.setProductName(product.getProductName());
			responseProduct.setUnitPrice(product.getUnitPrice());
			responseProduct.setUnitsInStock(product.getUnitsInStock());
			
			
			response.add(responseProduct);

		}
		return response;
	}

}
