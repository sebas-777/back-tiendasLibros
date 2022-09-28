package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin
@Controller
@RequestMapping("/pro")
public class ProductoController { 
	@RequestMapping(value = "/")
	public String index() {
		return "productos";
	}

}
