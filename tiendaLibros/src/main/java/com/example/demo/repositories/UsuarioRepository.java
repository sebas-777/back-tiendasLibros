package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Rol;
import com.example.demo.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	
	public abstract java.util.List<Usuario> findAllByRole(Rol role);
}
