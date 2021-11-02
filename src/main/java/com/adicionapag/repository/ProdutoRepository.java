package com.adicionapag.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adicionapag.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
