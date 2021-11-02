package com.adicionapag.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table( name = "produtos")
public class Produto {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_produto")
	private Long idProduto;
	
	@Column( name = "nome_produto")
	private String nomeProduto;
	
	private Double preco;
	
	private String descricao;

	@Column( name ="data_cadastro")
	private LocalDate dataCadastro;
	
	@ManyToOne(cascade = {CascadeType.PERSIST})
	@JoinColumn(name = "categoria_id" )
	private Categoria categoria;
	
	@ManyToMany( mappedBy = "produtos")
	private List<Venda> vendas = new ArrayList<>();
	
}
