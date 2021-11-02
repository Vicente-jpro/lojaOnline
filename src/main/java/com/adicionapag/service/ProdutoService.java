package com.adicionapag.service;

import java.util.List;

import com.adicionapag.model.Produto;

public interface ProdutoService {

	void salvarProduto( Produto produto);
	List<Produto> readAll();
	void deleteProduto(Long id);
	Produto getProduto(Long id);
}
