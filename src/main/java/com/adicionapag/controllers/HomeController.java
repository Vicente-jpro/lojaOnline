package com.adicionapag.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.adicionapag.model.Categoria;
import com.adicionapag.model.Produto;
import com.adicionapag.service.CategoriaServicedb;


@Controller
public class HomeController {
	
	@GetMapping("/")
	public String home() {
		
		// modelProduto.addAttribute("novoProduto", new Produto() );
		// modelCategoria.addAttribute("listaCategoria", this.categoriaServicedb.readAll() );
		
		return "index";
	}
	

}
