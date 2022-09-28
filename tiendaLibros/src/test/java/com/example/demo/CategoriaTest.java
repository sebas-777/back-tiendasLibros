package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.demo.entity.Categoria;

import com.example.demo.repositories.CategoriaRepository;
import com.example.demo.repositories.ProductoRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class CategoriaTest { 
	
	@Autowired
	CategoriaRepository catRepo;
	
	@Autowired
	ProductoRepository proRepo; 
	
	@Test
	public void createCategoria() {
		
				//Definicion
				String categoriaName = "categoria_name";
				String categoriaDescription = "categoria_description";
				//Procesos
				Categoria categoria = new Categoria(categoriaName,categoriaDescription);
				Categoria categoriaSaved = catRepo.save(categoria);
				//Prueba
				assertNotNull(categoriaSaved.getId());
				assertTrue(categoriaSaved.getId() > 0);
				//Logs
				System.out.println(categoriaSaved.toString());
				
				
				
			}
			
			@Test
			public void findOneCategoria(){  
				
				//Definicion
				String categoriaName = "categoria_name";
				String categoriaDescription = "categoria_description";
				//Procesos
				Categoria categoria = new Categoria(categoriaName,categoriaDescription);
				Categoria categoriaSaved = catRepo.save(categoria);
				//buscar
				Optional<Categoria>categoriaSearchedOptional = catRepo.findById(categoriaSaved.getId());
				//Prueba
				assertTrue(categoriaSearchedOptional.isPresent());
				//Logs
				System.out.println(categoriaSearchedOptional.get().toString());
				
				
				
			}
			
			@Test
			public void updateRole(){ 
				
				//Definicion
				String categoriaName = "categoria_name";
				String categoriaDescription = "categoria_description";
				String newCategoriaName = "new_categoria_name";
				String newCategoriaDescription = "new_categoria_description";
				//Procesos
				//crear
				Categoria categoria = new Categoria(categoriaName,categoriaDescription);
				Categoria categoriaSaved = catRepo.save(categoria);
				//Buscar ese registro
				Optional<Categoria>categoriaSearchedOptional = catRepo.findById(categoriaSaved.getId());
				Categoria categoriaSearched = categoriaSearchedOptional.get();
				//actualizar
				categoriaSearched.setDescripcion(newCategoriaDescription);
				categoriaSearched.setNombre(newCategoriaName);
				Categoria categoriaUpdated = catRepo.save(categoriaSearched);
				
				//Prueba
				assertNotNull(categoriaUpdated.getId());
				assertTrue(categoriaUpdated.getId() > 0);
				assertTrue(categoriaUpdated.getNombre() == newCategoriaName);
				assertTrue(categoriaUpdated.getDescripcion() == newCategoriaDescription);
				//Logs
				System.out.println(categoriaUpdated.toString());
				
			}
			
			@Test
			public void deleteRole(){ 
				
				//Definicion
				String categoriaName = "categoria_name";
				String categoriaDescription = "categoria_description";
				//Crear
				Categoria categoria = new Categoria(categoriaName,categoriaDescription);
				Categoria categoriaSaved = catRepo.save(categoria);
				//Buscar ese registro
				Optional<Categoria>categoriaSearchedOptional = catRepo.findById(categoriaSaved.getId());
				Categoria categoriaSearched = categoriaSearchedOptional.get();
				//Eliminar registro
				Integer categoriaId = categoriaSaved.getId();
				catRepo.deleteById(categoriaSaved.getId());
				//volver abuscarlo
				Optional<Categoria> categoriaDeletedOptional = catRepo.findById(categoriaId);
				//Pruebas
				assertFalse(categoriaDeletedOptional.isPresent());
				//Logs
				System.out.println(categoriaSaved.toString());
				System.out.println(categoriaSearched.toString());
				
			} 
			
			@Test
			public void findAllRoles(){ 
				
				//Definicion
				String categoriaName1 = "categoria_name1";
				String categoriaDescription1 = "categoria_description1";
				String categoriaName2 = "categoria_name2";
				String categoriaDescription2 = "categoria_description2";
				String categoriaName3 = "categoria_name3";
				String categoriaDescription3 = "categoria_description3";
				//Crear
				Categoria categoria1 = new Categoria(categoriaName1,categoriaDescription1);
				Categoria categoria2 = new Categoria(categoriaName2,categoriaDescription2);
				Categoria categoria3 = new Categoria(categoriaName3,categoriaDescription3);
				List<Categoria> listToSaved = new ArrayList<>();
				listToSaved.add(categoria1);
				listToSaved.add(categoria2);
				listToSaved.add(categoria3);
				catRepo.saveAll(listToSaved);
				//Buscar todos los registros 
				List<Categoria> listSearched = catRepo.findAll();
				//Pruebas
				assertTrue(listSearched.size() > 0);
				//Logs
				listSearched.forEach(
						categoria ->{
							System.out.println(categoria.toString());
						});
				
				
				
	}
}
