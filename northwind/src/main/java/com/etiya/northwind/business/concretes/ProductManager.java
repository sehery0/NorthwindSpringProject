package com.etiya.northwind.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.etiya.northwind.business.abstracts.ProductService;
import com.etiya.northwind.business.requests.products.CreateProductRequest;
import com.etiya.northwind.business.requests.products.DeleteProductRequest;
import com.etiya.northwind.business.requests.products.UpdateProductRequest;
import com.etiya.northwind.business.responses.products.ListProductResponse;
import com.etiya.northwind.business.responses.products.ReadProductResponse;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.dataAccess.abstracts.ProductRepository;
import com.etiya.northwind.entities.concretes.Product;

@Service
public class ProductManager implements ProductService {

	private ProductRepository productRepository;
	private ModelMapperService modelMapperService;
	private int totalPages;
	private int totalDatas;
	private int currentPage;

	@Autowired // git somutunu bul enjekte et.(dependency enjection)
	public ProductManager(ProductRepository productRepository, ModelMapperService modelMapperService) {
		this.productRepository = productRepository;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public List<ListProductResponse> getAll() {
		List<Product> result = this.productRepository.findAll();
		List<ListProductResponse> response = result.stream()
				.map(product -> this.modelMapperService.forResponse().map(product, ListProductResponse.class))
				.collect(Collectors.toList());
		return response;
	}

	@Override
	public void add(CreateProductRequest createProductRequest) {
		Product product = this.modelMapperService.forRequest().map(createProductRequest, Product.class);
		this.productRepository.save(product);
	}

	@Override
	public void delete(DeleteProductRequest deleteProductRequest) {
		Product product = this.modelMapperService.forRequest().map(deleteProductRequest, Product.class);
		this.productRepository.delete(product);
	}

	@Override
	public void update(UpdateProductRequest updateProductRequest) {
		Product product = this.modelMapperService.forRequest().map(updateProductRequest, Product.class);
		this.productRepository.save(product);
	}

	@Override
	public ReadProductResponse findById(int id) {
		Product product = this.productRepository.findById(id).get();
		ReadProductResponse productResponse = this.modelMapperService.forResponse().map(product,
				ReadProductResponse.class);
		return productResponse;
	}

	@Override
	public List<ListProductResponse> getAll(Integer pageNo, Integer pageSize) {
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
		List<Product> products = this.productRepository.findAll(pageable).getContent();
		List<ListProductResponse> responces = products.stream()
				.map(item -> modelMapperService.forResponse().map(item, ListProductResponse.class))
				.collect(Collectors.toList());
		currentPage = pageNo;
		totalDatas = products.size();
		totalPages = (int) Math.ceil(totalDatas / pageSize);
		return responces;

	}

	@Override
	public List<ListProductResponse> getAll(Integer pageNo, Integer pageSize, String field) {
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, Sort.by(field));
		List<Product> products = this.productRepository.findAll(pageable).getContent();
		List<ListProductResponse> responces = products.stream()
				.map(item -> modelMapperService.forResponse().map(item, ListProductResponse.class))
				.collect(Collectors.toList());
		currentPage = pageNo;
		totalDatas = products.size();
		totalPages = products.size();
		return responces;

	}

	@Override
	public List<ListProductResponse> getAll(Integer pageNo, Integer pageSize, String field, boolean isStateDescending) {
		Pageable pageable;
		if (isStateDescending) {
			pageable = PageRequest.of(pageNo - 1, pageSize, Sort.by(field).descending());
		} else {
			pageable = PageRequest.of(pageNo - 1, pageSize, Sort.by(field).ascending());
		}

		List<Product> products = this.productRepository.findAll(pageable).getContent();
		List<ListProductResponse> responces = products.stream()
				.map(item -> modelMapperService.forResponse().map(item, ListProductResponse.class))
				.collect(Collectors.toList());
		currentPage = pageNo;
		totalDatas = products.size();
		return responces;

	}

}
