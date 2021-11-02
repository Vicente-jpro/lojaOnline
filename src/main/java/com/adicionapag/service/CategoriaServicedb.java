package com.adicionapag.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adicionapag.model.Categoria;
import com.adicionapag.repository.CategoriaRepository;
@Service
public class CategoriaServicedb implements CategoriaService{

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Override
	public List<Categoria> readAll() {
	
		return categoriaRepository.findAll();
	}

}
