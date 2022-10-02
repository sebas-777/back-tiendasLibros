package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin
@Controller
@RequestMapping("/")
public class IndexController { 
	@RequestMapping(value = "")
	public String index() {
		return "index";
	}
	
	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = "/nosotros")
	public String nosostros() {
		return "nosotros";
	}
	
	@RequestMapping(value = "/libros")
	public String libros() {
		return "libros";
	} 
	
	@RequestMapping(value = "/libros-detail")
	public String librosDetail() {
		return "libros-detail";
	}
	
	@RequestMapping(value = "/contactanos")
	public String contactanos() {
		return "contactanos";
	}
	
	@RequestMapping(value = "/comprar")
	public String comprar() {
		return "comprar";
	}
}
