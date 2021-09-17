package com.lojadegames.lojadegames.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lojadegames.lojadegames.controler.produtoControler;
import com.lojadegames.lojadegames.model.produtoModel;
@Repository


public interface produtoRepository extends JpaRepository<produtoModel, Long> {
	List<produtoModel> findAllByNomeProdutoContainingIgnoreCase(String nomeProduto);
}
