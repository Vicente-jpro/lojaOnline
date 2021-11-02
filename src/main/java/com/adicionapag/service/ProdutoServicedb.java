package com.adicionapag.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adicionapag.model.Produto;
import com.adicionapag.repository.ProdutoRepository;


@Service
public class ProdutoServicedb implements ProdutoService{

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Override
	public void salvarProduto(Produto produto) {
	
		produtoRepository.save( produto );
		
	}

	@Override
	public List<Produto> readAll() {
		
		return produtoRepository.findAll();
	}

	@Override
	public void deleteProduto(Long id) {
		
		produtoRepository.deleteById(id);
		
	}

	@Override
	public Produto getProduto(Long id) {
		Produto produto = null;
		try {
			Optional<Produto> p = produtoRepository.findById(id);
			produto = p.get(); 
		} catch (Exception e) {
			System.out.println("Não foi possivel encontrar o produto "+e);
		}
	  
		return produto;
	}

}
