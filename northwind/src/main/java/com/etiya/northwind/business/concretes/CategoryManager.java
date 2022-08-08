package com.etiya.northwind.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.northwind.business.abstracts.CategoryService;
import com.etiya.northwind.business.responses.categories.CategoryListResponse;
import com.etiya.northwind.dataAccess.abstracts.CategoryRepository;
import com.etiya.northwind.entities.concretes.Category;

@Service
public class CategoryManager implements CategoryService{

	private CategoryRepository categoryRepository;
	
	@Autowired
	public CategoryManager(CategoryRepository categoryRepository) {
		super();
		this.categoryRepository = categoryRepository;
	}


	@Override
	public List<CategoryListResponse> getAll() {
		List<Category> result = this.categoryRepository.findAll();
		List<CategoryListResponse> response = new ArrayList<CategoryListResponse>();
		
		for (Category category : result) {
			CategoryListResponse responseCategory = new CategoryListResponse();
			responseCategory.setCategoryId(category.getCategoryId());
			responseCategory.setCategoryName(category.getCategoryName());
			
			response.add(responseCategory);
		}
		return response;
	}

}
