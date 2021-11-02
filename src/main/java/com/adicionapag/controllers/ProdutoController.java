package com.adicionapag.controllers;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.adicionapag.model.Categoria;
import com.adicionapag.model.Produto;
import com.adicionapag.service.CategoriaServicedb;
import com.adicionapag.service.ProdutoServicedb;

import lombok.extern.java.Log;

@Controller
public class ProdutoController {

	@Autowired
	private CategoriaServicedb categoriaServicedb;
	
	@Autowired
	private ProdutoServicedb produtoServicedb;
	
	@GetMapping("/novo-produto")
	public String formularioSalvarProduto(Model modelProduto, Model modelCategoria, Model modelObejctCategoria) {
		
		
		modelProduto.addAttribute("novoProduto", new Produto() );
		modelObejctCategoria.addAttribute("categoriaObject" , new Categoria());
		modelCategoria.addAttribute("listaCategoria", categoriaServicedb.readAll() );
		
		return "produto_save";
	}
	
	@PostMapping("/salvar-produto")
	public String salvarProduto(@ModelAttribute("novoProduto") Produto produto, 
			@ModelAttribute("categoriaObject") Categoria categoria) {
		
		produto.setCategoria(new Categoria( categoria.getIdCategoria() ));
		LocalDate date = LocalDate.now();
		produto.setDataCadastro(date);
		produtoServicedb.salvarProduto( produto );
		
		return "redirect:/visualisar-produtos";
		
	}
	
	
	@GetMapping("/visualisar-produtos")
	public String readProdutos(Model modelProduto, Model modelCategoria) {
		
		modelProduto.addAttribute("listaProdutos", produtoServicedb.readAll());
		
		return "produto_view";
	}
	
	@GetMapping("/eliminar-produto/{id}")
	public String eliminarProduto(@PathVariable Long id) {
		
		produtoServicedb.deleteProduto(id);
		
		return "redirect:/visualisar-produtos";
	}
	
	
	@GetMapping("/actualizar-produto/{id}")
	public String formActualizarProduto(@PathVariable Long id, Model modelProduto, Model modelCategoria, Model modelObejctCategoria) {
		
		Produto produto = produtoServicedb.getProduto(id);
		modelProduto.addAttribute("updateProduto", produto );
		
		Categoria categoria = produto.getCategoria();
		modelObejctCategoria.addAttribute("categoriaObject" , categoria );
		modelCategoria.addAttribute("listaCategoria", categoriaServicedb.readAll() );
		
		return "produto_update";
	}
	
	
}
