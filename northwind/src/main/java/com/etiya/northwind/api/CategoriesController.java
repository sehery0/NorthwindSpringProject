package com.etiya.northwind.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.northwind.business.abstracts.CategoryService;
import com.etiya.northwind.business.requests.categories.CreateCategoryRequest;
import com.etiya.northwind.business.requests.categories.DeleteCategoryRequest;
import com.etiya.northwind.business.requests.categories.UpdateCategoryRequest;
import com.etiya.northwind.business.responses.categories.ListCategoryResponse;
import com.etiya.northwind.business.responses.categories.ReadCategoryResponse;



@RestController
@RequestMapping("/api/categories")
public class CategoriesController {
	
	private CategoryService categoryService;

	public CategoriesController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	@GetMapping("/getall")
	public List<ListCategoryResponse> getAll(){
		return this.categoryService.getAll();
	}
	
	@PostMapping("/add")
	public void add(@RequestBody CreateCategoryRequest createCategoryRequest) {
		this.categoryService.add(createCategoryRequest);
	}
	
	@PostMapping("/update")
	public void update(@RequestBody UpdateCategoryRequest updateCategoryRequest) {
		this.categoryService.update(updateCategoryRequest);
	}
	
	@PostMapping("/delete")
	public void delete(@RequestBody DeleteCategoryRequest deleteCategoryRequest) {
		this.categoryService.delete(deleteCategoryRequest);
	}
	
	@GetMapping("/getbyıd")
	public ReadCategoryResponse findById(@RequestParam int id) {
		return this.categoryService.findById(id);
	}

}
