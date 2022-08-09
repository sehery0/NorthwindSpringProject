package com.etiya.northwind.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.northwind.business.abstracts.CategoryService;
import com.etiya.northwind.business.requests.categories.CreateCategoryRequest;
import com.etiya.northwind.business.requests.categories.DeleteCategoryRequest;
import com.etiya.northwind.business.requests.categories.UpdateCategoryRequest;
import com.etiya.northwind.business.responses.categories.ListCategoryResponse;
import com.etiya.northwind.business.responses.categories.ReadCategoryResponse;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.dataAccess.abstracts.CategoryRepository;
import com.etiya.northwind.entities.concretes.Category;

@Service
public class CategoryManager implements CategoryService {

	private CategoryRepository categoryRepository;
	private ModelMapperService modelMapperService;

	@Autowired
	public CategoryManager(CategoryRepository categoryRepository, ModelMapperService modelMapperService) {
		this.categoryRepository = categoryRepository;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public List<ListCategoryResponse> getAll() {
		List<Category> result = this.categoryRepository.findAll();
		List<ListCategoryResponse> response = result.stream()
				.map(category -> this.modelMapperService.forResponse().map(result, ListCategoryResponse.class))
				.collect(Collectors.toList());

		return response;
	}

	@Override
	public void add(CreateCategoryRequest createCategoryRequest) {
		Category category = this.modelMapperService.forRequest().map(createCategoryRequest, Category.class);
		categoryRepository.save(category);
	}

	@Override
	public void update(UpdateCategoryRequest updateCategoryRequest) {
		Category category = this.modelMapperService.forRequest().map(updateCategoryRequest, Category.class);
		categoryRepository.save(category);
	}

	@Override
	public void delete(DeleteCategoryRequest deleteCategoryRequest) {
		Category category = this.modelMapperService.forRequest().map(deleteCategoryRequest, Category.class);
		categoryRepository.delete(category);
	}

	@Override
	public ReadCategoryResponse findById(int id) {
		Category category = this.categoryRepository.findById(id).get();
		ReadCategoryResponse response = this.modelMapperService.forResponse().map(category, ReadCategoryResponse.class);
		return response;
	}

}
