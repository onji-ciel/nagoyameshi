package com.example.nagoyameshi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.nagoyameshi.entity.Category;
import com.example.nagoyameshi.form.CategoryEditForm;
import com.example.nagoyameshi.form.CategoryRegisterForm;
import com.example.nagoyameshi.repository.CategoryRepository;

@Service
public class CategoryService {
	private final CategoryRepository categoryRepository;
	
	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	
	public Page<Category> findAllCategories(Pageable pageable) {
		return categoryRepository.findAll(pageable);
	}
	
	public Page<Category> findCategoriesByNameLike(String keyword, Pageable pageable) {
		return categoryRepository.findByNameLike("%" + keyword + "%", pageable);
	}
	
	public Optional<Category> findCategoryById(Integer id) {
		return categoryRepository.findById(id);
	}
	
	public long countCategories() {
		return categoryRepository.count();
	}
	
	public List<Category> findAllCategories() {
		return categoryRepository.findAll();
	}
	
	@Transactional
	public void createCategory(CategoryRegisterForm categoryRegisterForm) {
		Category category = new Category();

		category.setName(categoryRegisterForm.getName());
		categoryRepository.save(category);
	}
	
	public void updateCategory(CategoryEditForm categoryEditForm, Category category) {
		category.setName(categoryEditForm.getName());
		categoryRepository.save(category);
	}
	
	@Transactional
	public void deleteCategory(Category category) {
		categoryRepository.delete(category);
	}

}
