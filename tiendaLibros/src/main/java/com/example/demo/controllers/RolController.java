package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin
@Controller
@RequestMapping("/rol")
public class RolController {  
	@RequestMapping(value = "/")
	public String index() {
		return "categoria";
	}

}
