package com.lojadegames.lojadegames.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lojadegames.lojadegames.model.categoriaModel;

@Repository
public interface categoriaRepository extends JpaRepository<categoriaModel, Long> {
	
   List<categoriaModel> findAllBydescricaoContainingIgnoreCase(String descricao);

}
