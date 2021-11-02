package com.adicionapag.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adicionapag.model.Venda;
import com.adicionapag.repository.VendaRepository;

@Service
public class VendaServicedb implements VendaService{
	
	@Autowired
	private VendaRepository vendaRepository;

	@Override
	public void create(Venda venda) {
		
		vendaRepository.save(venda);
		
	}
	
	
	
}
