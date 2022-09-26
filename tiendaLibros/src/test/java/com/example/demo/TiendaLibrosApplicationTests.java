package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertNotNull;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.repositories.CategoriaRepository;
import com.example.demo.repositories.ProductoRepository;
import com.example.demo.repositories.RolRepository;
import com.example.demo.repositories.UsuarioRepository;

@SpringBootTest
class TiendaLibrosApplicationTests {

	@Autowired
	private UsuarioRepository userRepo;
	@Autowired
	private RolRepository rolRepo;
	@Autowired
	private CategoriaRepository categoriaRepo;
	@Autowired
	private ProductoRepository productoRepo;
	
	@Test
	void contextLoads() { 
		
		Long numRoles = rolRepo.count();
		assertNotNull(numRoles);
		Long numUsrs = userRepo.count();
		assertNotNull(numUsrs);
		Long numCats = categoriaRepo.count();
		assertNotNull(numCats);
		Long numPdts = productoRepo.count();
		assertNotNull(numPdts);
	}

}
