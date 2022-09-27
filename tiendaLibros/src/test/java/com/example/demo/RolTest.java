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

import com.example.demo.entity.Rol;

import com.example.demo.repositories.RolRepository;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class RolTest { 
	
	@Autowired
	private RolRepository roleRepo;
	
	@Test
	public void createrRole(){  
		
		//Definicion
		String roleName = "role_name";
		String roleDescription = "role_description";
		//Procesos
		Rol role = new Rol(roleName,roleDescription);
		Rol roleSaved = roleRepo.save(role);
		//Prueba
		assertNotNull(roleSaved.getId());
		assertTrue(roleSaved.getId() > 0);
		//Logs
		System.out.println(roleSaved.toString());
		
		
		
	}
	
	@Test
	public void findOneRole(){  
		
		//Definicion
		String roleName = "role_name";
		String roleDescription = "role_description";
		//Procesos
		Rol role = new Rol(roleName,roleDescription);
		Rol roleSaved = roleRepo.save(role);
		//buscar
		Optional<Rol>roleSearchedOptional = roleRepo.findById(roleSaved.getId());
		//Prueba
		assertTrue(roleSearchedOptional.isPresent());
		//Logs
		System.out.println(roleSearchedOptional.get().toString());
		
		
		
	}
	
	@Test
	public void updateRole(){ 
		
		//Definicion
		String roleName = "role_name";
		String roleDescription = "role_description";
		String newRoleName = "new_role_name";
		String newRoleDescription = "new_role_description";
		//Procesos
		//crear
		Rol role = new Rol(roleName,roleDescription);
		Rol roleSaved = roleRepo.save(role);
		//Buscar ese registro
		Optional<Rol> roleSearchedOptional = roleRepo.findById(roleSaved.getId());
		Rol roleSearched = roleSearchedOptional.get();
		//actualizar
		roleSearched.setDescripcion(newRoleDescription);
		roleSearched.setNombre(newRoleName);
		//actualizar
		Rol roleUpdated = roleRepo.save(roleSearched);
		//Prueba
		assertNotNull(roleUpdated.getId());
		assertTrue(roleUpdated.getId() > 0);
		assertTrue(roleUpdated.getNombre() == newRoleName);
		assertTrue(roleUpdated.getDescripcion() == newRoleDescription);
		//Logs
		System.out.println(roleUpdated.toString());
		
	}
	
	@Test
	public void deleteRole(){ 
		
		//Definicion
		String roleName = "role_name";
		String roleDescription = "role_description";
		//Crear
		Rol role = new Rol(roleName,roleDescription);
		Rol roleSaved = roleRepo.save(role);
		//Buscar ese registro
		Optional<Rol> roleSearchedOptional = roleRepo.findById(roleSaved.getId());
		Rol roleSearched = roleSearchedOptional.get();
		//Eliminar registro
		Integer roleId = roleSaved.getId();
		roleRepo.deleteById(roleSaved.getId());
		//volver abuscarlo
		Optional<Rol> roleDeletedOptional = roleRepo.findById(roleId);
		//Pruebas
		assertFalse(roleDeletedOptional.isPresent());
		//Logs
		System.out.println(roleSaved.toString());
		System.out.println(roleSearched.toString());
		
	} 
	
	@Test
	public void findAllRoles(){ 
		
		//Definicion
		String roleName1 = "role_name1";
		String roleDescription1 = "role_description1";
		String roleName2 = "role_name2";
		String roleDescription2 = "role_description2";
		String roleName3 = "role_name3";
		String roleDescription3 = "role_description3";
		//Crear
		Rol role1 = new Rol(roleName1,roleDescription1);
		Rol role2 = new Rol(roleName2,roleDescription2);
		Rol role3 = new Rol(roleName3,roleDescription3);
		List<Rol> listToSaved = new ArrayList<>();
		listToSaved.add(role1);
		listToSaved.add(role2);
		listToSaved.add(role3);
		roleRepo.saveAll(listToSaved);
		//Buscar todos los registros 
		List<Rol> listSearched = roleRepo.findAll();
		//Pruebas
		assertTrue(listSearched.size() > 0);
		//Logs
		listSearched.forEach(
				role ->{
					System.out.println(role.toString());
				});
		
		
		
		
	}
	
	
	
	
}
