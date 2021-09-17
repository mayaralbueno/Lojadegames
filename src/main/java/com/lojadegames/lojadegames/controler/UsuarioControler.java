package com.lojadegames.lojadegames.controler;


import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lojadegames.lojadegames.model.UsuarioModel;
import com.lojadegames.lojadegames.model.utilites.UsuarioLogin;
import com.lojadegames.lojadegames.repository.RepositoryUsuario;
import com.lojadegames.lojadegames.servico.UsuarioService;

@RestController
@RequestMapping("usuario")
public class UsuarioControler {
	private @Autowired RepositoryUsuario repository;
	private  @Autowired    UsuarioService servicos;
	 
	@PostMapping("/salvar")
	public ResponseEntity<Object> salvar(@Valid @RequestBody UsuarioModel novoUsuario){
		Optional<Object> objetoSalvar = servicos.cadastrarUsuario(novoUsuario);
		
		if(objetoSalvar.isEmpty()) {
			return ResponseEntity.status(400).build();
		}
		else {
		    return ResponseEntity.status(201).body(objetoSalvar.get());
		}
	}
	 
	@PutMapping("/credenciais")
	public ResponseEntity<Object> credenciais(@Valid @RequestBody UsuarioLogin usuarioAutenticar){
		Optional<?> objetoCredenciais =servicos.autenticador(usuarioAutenticar);
		
		if(objetoCredenciais.isEmpty()) {
			return ResponseEntity.status(400).build();
		} else {
			return ResponseEntity.status(201).body(objetoCredenciais.get());
		}
	}
	 
	 

}
