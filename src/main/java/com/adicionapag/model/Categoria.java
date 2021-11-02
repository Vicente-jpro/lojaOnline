package com.adicionapag.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table( name = "categorias")
public class Categoria {

	@Id @GeneratedValue( strategy = GenerationType.IDENTITY)
	@Column(name = "id_categoria")
	private Long idCategoria;
	
	@Column( name = "nome_categoria")
	private String nomeCategoria;
	
	@OneToMany(mappedBy = "categoria")
	private List<Produto> produtos = new ArrayList<>();


	public Categoria(Long idCategoria, String nomeCategoria) {
	
		this.idCategoria = idCategoria;
		this.nomeCategoria = nomeCategoria;
		
	}
	
	public Categoria() {
		
	
	}
	
	public Categoria(Long idCategoria) {
	
		this.idCategoria = idCategoria;
	
	}

	public Long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}

	@Override
	public String toString() {
		return "Categoria [idCategoria=" + idCategoria + ", nomeCategoria=" + nomeCategoria + "]";
	}

	

	
	
}
