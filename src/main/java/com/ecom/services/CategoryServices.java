package com.ecom.services;

import java.util.List;

import com.ecom.dtos.CategoryDto;

public interface CategoryServices {

	//add
	CategoryDto addCategoryDto(CategoryDto categoryDto);
	
	//update
	CategoryDto updateCategoryDto(CategoryDto categoryDto, String categoryStringId);
	
	//get one
	CategoryDto getOne(String catrgoryStringId);
	
	//get all
	List<CategoryDto> getAll();
	
	//search
	List<CategoryDto> searchCategoryDto(String keywords);
	
	//delete
	void delete(String categoryStringId);
}
