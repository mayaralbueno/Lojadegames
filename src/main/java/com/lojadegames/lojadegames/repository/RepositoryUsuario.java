package com.lojadegames.lojadegames.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lojadegames.lojadegames.model.Usuario;
import com.lojadegames.lojadegames.model.UsuarioModel;


@Repository
public interface RepositoryUsuario extends JpaRepository<UsuarioModel, Long> {
 
      Optional<UsuarioModel> findByEmail (String email);
 
}
