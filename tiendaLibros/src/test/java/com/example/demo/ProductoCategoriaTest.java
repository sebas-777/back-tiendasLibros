package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.demo.entity.Categoria;
import com.example.demo.entity.Producto;
import com.example.demo.repositories.CategoriaRepository;
import com.example.demo.repositories.ProductoRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class ProductoCategoriaTest { 
	
	@Autowired
	ProductoRepository proRepo;
	
	@Autowired
	CategoriaRepository catRepo;
	
	@Test
	public void createCategoriesForProducts(){ 
		//Definicion
		String productName = "pro_name";
		String productBrand = "pro_brand";
		Float productPrice = 10.0f;
		String catName1 = "cat_pro_1";
		String catDescription1 = "cat_pro_description_1";
		String catName2 = "cat_pro_2";
		String catDescription2 = "cat_pro_description_2";
		//Procesos
		Producto product = new Producto(productName,productBrand,productPrice);
		Producto productSaved = proRepo.save(product); 
		Categoria cat1 = new Categoria(catName1,catDescription1);
		Categoria cat2 = new Categoria(catName2,catDescription2);
		Categoria cat1Saved = catRepo.save(cat1);
		Categoria cat2Saved = catRepo.save(cat2);
		productSaved.addCategory(cat1Saved);
		productSaved.addCategory(cat2Saved);
		//pruebas
		Optional<Producto> productSearchedOptional = proRepo.findById(productSaved.getId());
		Producto productSearched = productSearchedOptional.get();
		assertTrue(productSearched.getCategories().size() == 2);
		//Log 
		System.out.println(productSearched.toString());
		
	}
	
   
}
