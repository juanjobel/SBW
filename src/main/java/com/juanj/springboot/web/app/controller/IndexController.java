package com.juanj.springboot.web.app.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.juanj.springboot.web.app.model.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {

	@Value("${index}")
	private String textoIndex;
	
	@Value("${perfil}")
	private String textoPerfil;
	
	@Value("${listar}")
	private String textoListar;
	
	@GetMapping({"/index", "/", "", "/home"})
	public String index(Model model) {
		model.addAttribute("titulo", textoIndex);
		return "index";
	}
	
	@GetMapping("/perfil")
	public String perfil(Model model) {
		Usuario usuario = new Usuario("Juan José", "Beltrán Martín");
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", textoPerfil.concat(usuario.getNombre()
				.concat(" ").concat(usuario.getApellido())));

		return "perfil";
	}

	@GetMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("titulo", textoListar);

		return "listar";
	}

	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuarios() {
		List<Usuario> usuarios = Arrays.asList(new Usuario("Juan José", "Beltrán Martín"),
				new Usuario("Silvia", "García Virella"),
				new Usuario("Daniel", "Beltrán García"));

		return usuarios;
	}
}
