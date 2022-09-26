package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;



import com.example.demo.entity.Rol;
import com.example.demo.entity.Usuario;
import com.example.demo.repositories.RolRepository;
import com.example.demo.repositories.UsuarioRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class UsuarioTest {
	
	@Autowired
	private UsuarioRepository usrRepo;
	
	@Autowired
	private RolRepository roleRepo;
	
	@Test
	public void createUser(){ 
		
		Rol role = new Rol("nombre","descripcion");
		Rol rolecreated = roleRepo.save(role);
		Usuario usr = new Usuario("username","password",rolecreated,new Date());
		Usuario created = usrRepo.save(usr);
		System.out.println(role.toString());
		System.out.println(created.toString());
		assertNotNull(created.getId());
		assertTrue(created.getId() > 0);
	}
	
	@Test
	public void updateUser(){ 
		
		String newUsername = "username _change";
		String newPassword = "password_change";
		
		//Create Role
		Rol role = new Rol("nombre","descripcion");
		Rol rolecreated = roleRepo.save(role);
		//Create User 
		Usuario usr = new Usuario("username","password",rolecreated,new Date());
		Usuario created = usrRepo.save(usr);
		//Search User
		Usuario usrSearched;
		Optional<Usuario> usrSearchedOptional = usrRepo.findById(created.getId());
		assertTrue(usrSearchedOptional.isPresent());
		usrSearched = usrSearchedOptional.get();
		//Update User
		usrSearched.setPassword(newPassword);
		usrSearched.setUsername(newUsername);
		Usuario usrUpdated = usrRepo.save(usrSearched);
		//Test changes
		assertNotNull(usrUpdated.getId());
		assertTrue(usrUpdated.getId() > 0);
		assertEquals(newPassword, usrUpdated.getPassword());
		assertEquals(newUsername, usrUpdated.getUsername());
		//Log
		System.out.println(rolecreated.toString());
		System.out.println(usrUpdated.toString());
		
	}
	
	@Test
	public void deleteUser(){ 
		
		String newUsername = "username _change";
		String newPassword = "password_change";
		
		//Create Role
		Rol role = new Rol("nombre","descripcion");
		Rol rolecreated = roleRepo.save(role);
		//Create User 
		Usuario usr = new Usuario("username","password",rolecreated,new Date());
		Usuario created = usrRepo.save(usr);
		//Search User
		Usuario usrSearched;
		Optional<Usuario> usrSearchedOptional = usrRepo.findById(created.getId());
		assertTrue(usrSearchedOptional.isPresent());
		usrSearched = usrSearchedOptional.get();
		//delete User
		usrRepo.delete(usrSearched);
		//Test changes
		usrSearchedOptional = usrRepo.findById(created.getId());
		assertFalse(usrSearchedOptional.isPresent());
		//Log
		System.out.println(rolecreated.toString());
		System.out.println(usrSearchedOptional.toString());
		
	} 
	
	@Test
	public void findAllUsers(){ 
		
		
		
		//Create Role
		Rol role = new Rol("nombre","descripcion");
		Rol rolecreated = roleRepo.save(role);
		//Create User 
		Usuario usr1 = new Usuario("username1","password1",rolecreated,new Date());
		Usuario usr2 = new Usuario("username2","password2",rolecreated,new Date());
		Usuario usr3 = new Usuario("username3","password3",rolecreated,new Date());
		Usuario created1 = usrRepo.save(usr1);
		Usuario created2 = usrRepo.save(usr2);
		Usuario created3 = usrRepo.save(usr3);
		// find all by role
		List<Usuario> usr = usrRepo.findAllByRole(rolecreated);
		assertTrue(usr.size() >0);
		//Search User
		//Usuario usrSearched;
		//Optional<Usuario> usrSearchedOptional = usrRepo.findById(created.getId());
		//assertTrue(usrSearchedOptional.isPresent());
		//usrSearched = usrSearchedOptional.get();
		//Update User
		//usrSearched.setPassword(newPassword);
		//usrSearched.setUsername(newUsername);
		//Usuario usrUpdated = usrRepo.save(usrSearched);
		//Test changes
		//assertNotNull(usrUpdated.getId());
		//assertTrue(usrUpdated.getId() > 0);
		//assertEquals(newPassword, usrUpdated.getPassword());
		//assertEquals(newUsername, usrUpdated.getUsername());
		//Log
		//System.out.println(rolecreated.toString());
		//System.out.println(usrUpdated.toString());
		
	}
	
	
	
	

}
