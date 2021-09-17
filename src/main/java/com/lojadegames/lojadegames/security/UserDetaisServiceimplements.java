package com.lojadegames.lojadegames.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.lojadegames.lojadegames.model.UsuarioModel;
import com.lojadegames.lojadegames.repository.RepositoryUsuario;
import com.lojadegames.lojadegames.servico.UsuarioService;

@Service

public class UserDetaisServiceimplements implements UserDetailsService {
	
	private  @Autowired   RepositoryUsuario repository;

	@Override
	public UserDetails loadUserByUsername(String username ) throws UsernameNotFoundException {
		
		 Optional<UsuarioModel> objetoOpitional = repository.findByEmail(username);
		 
		if(objetoOpitional.isPresent()) {
			return new UserDetaisimplements(objetoOpitional.get());
		}else {
			throw new UsernameNotFoundException(username +"não existe!");
		}
		
	}

}
