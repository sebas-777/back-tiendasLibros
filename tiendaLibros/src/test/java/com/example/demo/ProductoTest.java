package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.demo.entity.Producto;

import com.example.demo.repositories.ProductoRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class ProductoTest { 
	
	
	@Autowired
	private ProductoRepository proRepo;
	
	@Test
	public void createrProducto(){  
		
		//Definicion
		String productName = "pro_name";
		String productDescription = "pro_brand";
		Float productPrice = 10.0f;
		//Procesos
		Producto producto = new Producto(productName,productDescription,productPrice);
		Producto productoSaved = proRepo.save(producto);
		//Prueba
		assertNotNull(productoSaved.getId());
		assertTrue(productoSaved.getId() > 0);
		//Logs
		System.out.println(productoSaved.toString());
		
		
		
	} 
	
	@Test
	public void findByidProducto(){  
		
		//Definicion
		String productName = "pro_name";
		String productDescription = "pro_brand";
		Float productPrice = 10.0f;
		//Procesos
		Producto producto = new Producto(productName,productDescription,productPrice);
		Producto productoSaved = proRepo.save(producto);
		//buscar
		Optional<Producto> productSearched = proRepo.findById(productoSaved.getId());
		//Prueba
		assertNotNull(productoSaved.getId());
		assertTrue(productoSaved.getId() > 0);
		//Logs
		System.out.println(productoSaved.toString());
		
		
		
	}
	@Test
	public void updateProducto(){  
		
		//Definicion
		String productName = "pro_name";
		String productDescription = "pro_brand";
		Float productPrice = 10.0f;
		String newProductoName = "new_pro_name";
		String newProductBrand = "new_pro_brand";
		Float newProductPrice = 99.0f;
		//Procesos
		//crear
		Producto producto = new Producto(productName,productDescription,productPrice);
		Producto productoSaved = proRepo.save(producto);
		//buscar
		Optional<Producto> productoSearchedOptional = proRepo.findById(productoSaved.getId());
		Producto productSearched = productoSearchedOptional.get();
		//Actualizar	
		productSearched.setMarca(newProductBrand);
		productSearched.setNombre(newProductoName);
		productSearched.setPrecio(newProductPrice);
		Producto productUpdated = proRepo.save(productSearched);
		// Pruebas
		assertTrue(productUpdated.getMarca() == newProductBrand);
		assertTrue(productUpdated.getPrecio() == newProductPrice);
		assertTrue(productUpdated.getNombre() == newProductoName);
		//Logs
		System.out.println(productUpdated.toString());
		
		
		
	} 
	
	@Test
	public void deleteProducto(){  
		
		//Definicion
		String productName = "pro_name";
		String productDescription = "pro_brand";
		Float productPrice = 10.0f;
		//Procesos
		Producto producto = new Producto(productName,productDescription,productPrice);
		Producto productoSaved = proRepo.save(producto);
		Integer productId = productoSaved.getId();
		Optional<Producto> productSearchedOptional = proRepo.findById(productId);
		proRepo.deleteById(productSearchedOptional.get().getId());
		//volver  a buscar 
		Optional<Producto> productSearchedAfterDelete = proRepo.findById(productId);
		//Prueba
		assertFalse(productSearchedAfterDelete.isPresent());
		//Logs
		System.out.println(producto.toString());
		
		
		
	} 

}
