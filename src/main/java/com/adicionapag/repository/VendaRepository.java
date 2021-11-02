package com.adicionapag.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adicionapag.model.Venda;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long>{

}
