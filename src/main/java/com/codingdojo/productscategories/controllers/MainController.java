package com.codingdojo.productscategories.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.productscategories.models.Category;
import com.codingdojo.productscategories.models.CategoryProduct;
import com.codingdojo.productscategories.models.Product;
import com.codingdojo.productscategories.services.MainService;

@Controller
public class MainController {
	
	@Autowired
	private MainService mainService;
	
	
	@GetMapping("/")
	public String home() {
		return "index.jsp";
	}
	
	@GetMapping("/products/new")
	public String newProducts(@ModelAttribute("product") Product product, Model model) {
		List<Product> allProducts = mainService.allProducts();
		model.addAttribute("allProducts", allProducts);
		return "newProduct.jsp";
	}
	
	@PostMapping("/products/create")
	public String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "newProduct.jsp";
		}else {
			mainService.createProduct(product);
			return "redirect:/";
		}
	}
	
	@GetMapping("/categories/new")
	public String newCategory(@ModelAttribute("category") Category category, Model model) {
		List<Category> allCategories = mainService.allCategories();
		model.addAttribute("allCategories", allCategories);
		return "newCategory.jsp";
	}
	
	@PostMapping("/categories/create")
	public String createCategory(@Valid @ModelAttribute("category") Category category, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "newCategory.jsp";
		}else {
			mainService.createCategory(category);
			return "redirect:/";
		}
	}
	
	@GetMapping("/products/{id}")
	public String showProduct(@PathVariable("id") Long id, Model model, @ModelAttribute("categoryProduct") CategoryProduct categoryProduct) {
		Product product = mainService.findProductById(id);
		List<Category> category = mainService.findByCatNotContains(product);
		model.addAttribute("product", product);
		model.addAttribute("category", category);
		return "showProduct.jsp";
	}
	
	@GetMapping("/categories/{id}")
	public String showCategory(@PathVariable("id") Long id, Model model, @ModelAttribute("categoryProduct") CategoryProduct categoryProduct) {
		Category category = mainService.findCategoryById(id);
		List<Product> product = mainService.findByCatNotContains(category);
		model.addAttribute("product", product);
		model.addAttribute("category", category);
		return "showCategory.jsp";
	}
	
	@PostMapping("/add/category")
	public String addCategory(@ModelAttribute("categoryProduct") CategoryProduct categoryProduct, Model model) {
		mainService.createCategoryProduct(categoryProduct);
		Long catId = categoryProduct.getProduct().getId();
		String id = String.valueOf(catId);
		return "redirect:/products/" + id;
	}
	
	@PostMapping("/add/product")
	public String addProduct(@ModelAttribute("categoryProduct") CategoryProduct categoryProduct, Model model) {
		mainService.createCategoryProduct(categoryProduct);
		Long proId = categoryProduct.getCategory().getId();
		String id = String.valueOf(proId);
		return "redirect:/categories/" + id;
	}
}
