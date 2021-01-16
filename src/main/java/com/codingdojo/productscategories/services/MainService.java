package com.codingdojo.productscategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.productscategories.models.Category;
import com.codingdojo.productscategories.models.CategoryProduct;
import com.codingdojo.productscategories.models.Product;
import com.codingdojo.productscategories.repositories.CategoryProductRepository;
import com.codingdojo.productscategories.repositories.CategoryRepository;
import com.codingdojo.productscategories.repositories.ProductRepository;

@Service
public class MainService {
private final CategoryRepository categoryRepo;

@Autowired
private ProductRepository productRepo;

@Autowired
private CategoryProductRepository catProRepo;

	
	public MainService(CategoryRepository categoryRepo) {
		this.categoryRepo = categoryRepo;
	}
	
	public List<Category> allCategories(){
		return categoryRepo.findAll();
	}
	
	public Category createCategory(Category category) {
		return categoryRepo.save(category);
	}
	
	public Category findCategoryById(Long id) {
		Optional<Category> optionalCategory = categoryRepo.findById(id);
		if(optionalCategory.isPresent()) {
			return optionalCategory.get();
		}else {
			return null;
		}
	}
	
	public List<Product> allProducts(){
		return productRepo.findAll();
	}
	
	public Product createProduct(Product product) {
		return productRepo.save(product);
	}
	
	public Product findProductById(Long id) {
		Optional<Product> optionalProduct = productRepo.findById(id);
		if(optionalProduct.isPresent()) {
			return optionalProduct.get();
		}else {
			return null;
		}
	}

	public void createCategoryProduct(CategoryProduct categoryProduct) {
		catProRepo.save(categoryProduct);
		
	}

	public List<Product> findByCatNotContains(Category category) {
		return productRepo.findByCategoriesNotContains(category);
	}
	
	public List<Category> findByCatNotContains(Product product){
		return categoryRepo.findByProductsNotContains(product);
	}
}
