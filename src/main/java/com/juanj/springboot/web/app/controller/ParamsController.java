package com.juanj.springboot.web.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class ParamsController {
	
	@GetMapping("/")
	public String index() {
		return "/params/index";
		
	}
	
	@GetMapping("/string")
	public String param(@RequestParam(defaultValue = "nulo") String texto, Model model) {
		model.addAttribute("resultado", "El texto enviado es ".concat(texto));
		return "/params/ver";
		
	}

}
