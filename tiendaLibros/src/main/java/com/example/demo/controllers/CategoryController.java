package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repositories.CategoriaRepository;

@CrossOrigin
@Controller
@RequestMapping("/cat")
public class CategoryController { 
	
	@Autowired
	CategoriaRepository catrepo;
	
	@RequestMapping(value = "/")
	public String index() {
		return "categoria";
	}

}
