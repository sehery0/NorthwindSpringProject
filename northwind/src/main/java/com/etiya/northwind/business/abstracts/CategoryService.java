package com.etiya.northwind.business.abstracts;

import java.util.List;

import com.etiya.northwind.business.requests.categories.CreateCategoryRequest;
import com.etiya.northwind.business.requests.categories.DeleteCategoryRequest;
import com.etiya.northwind.business.requests.categories.UpdateCategoryRequest;
import com.etiya.northwind.business.responses.categories.ListCategoryResponse;
import com.etiya.northwind.business.responses.categories.ReadCategoryResponse;

public interface CategoryService {
	List<ListCategoryResponse> getAll();
	void add(CreateCategoryRequest createCategoryRequest);
	void update(UpdateCategoryRequest updateCategoryRequest);
	void delete(DeleteCategoryRequest deleteCategoryRequest);
	ReadCategoryResponse findById(int id);

}
