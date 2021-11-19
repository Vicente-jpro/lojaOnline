package com.adicionapag.controllers;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.adicionapag.model.Produto;
import com.adicionapag.model.Venda;
import com.adicionapag.service.ProdutoServicedb;
import com.adicionapag.service.VendaServicedb;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
public class VendaController {

	@Autowired
	public VendaServicedb vendaServicedb;
	
	@Autowired
	public ProdutoServicedb produtoServicedb;
	
	@GetMapping("/produtos-com-varias-categorias")
	public String create(Model modelProduto) {
		
		modelProduto.addAttribute("listaProdutos", produtoServicedb.readAll());
		return "venda_iniciar_compra";
	}
	
	@GetMapping("/comprar-produto/{id}")
	public String descricaoProduto(@PathVariable Long id,Model modelVenda, Model modelProduto, Model modelProdutoObject) {

		modelVenda.addAttribute("salvarObject", new Venda() );
		
		System.out.println("\n\n"+produtoServicedb.getProduto(id)+"\n\n");
		
		modelProduto.addAttribute("produtoSelecionado", produtoServicedb.getProduto(id) );
		return "venda_finalizar_compra";
	}
	
	@PostMapping("/finalizar-compra")
	public String finalizarCompra(@ModelAttribute("produtoSelecionado") Produto produto, 
			@ModelAttribute("salvarObject") Venda venda) {
		
		LocalDateTime date = LocalDateTime.now();
		venda.setDataVenda(date);
		List<Produto> list = new ArrayList<>();
		list.add(produto) ;
		venda.setProdutos( list );
		log.info("\n\n"+produto+"\n\n"+ venda);
		vendaServicedb.create(venda);
		log.info("\n\n");
		
		return "index";
	}
	
 }
