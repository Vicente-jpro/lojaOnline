package com.adicionapag.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@ToString
@Entity
@NoArgsConstructor
@Getter
@Setter
@Table( name = "vendas")
public class Venda {
	
	@Id @GeneratedValue( strategy = GenerationType.IDENTITY)
	@Column( name = "id_venda")
	private Long idVenda;
	
	@Column(name = "data_venda", columnDefinition = "TIMESTAMP")
	private LocalDateTime dataVenda;
	
	@Column ( name = "nome_cliente")
	private String nomeCliente;
	private String email;
	private String mensagem;
	private int quantidade;
	@ManyToMany( cascade = {CascadeType.ALL})
	@JoinTable( 
	name = "venda_produto",
	joinColumns = {@JoinColumn( name = "venda_id")},
	inverseJoinColumns = {@JoinColumn ( name = "produto_id" )}
	
	)
	List<Produto> produtos = new ArrayList<>();
}
