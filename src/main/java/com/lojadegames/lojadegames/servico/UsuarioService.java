package com.lojadegames.lojadegames.servico;

import java.nio.charset.Charset;
import java.util.Map;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.lojadegames.lojadegames.model.UsuarioModel;
import com.lojadegames.lojadegames.model.utilites.UsuarioLogin;
import com.lojadegames.lojadegames.repository.RepositoryUsuario;

@Service
public class UsuarioService {
	
    private @Autowired RepositoryUsuario repository;
    
    public Optional<Object> cadastrarUsuario(UsuarioModel novoUsuario){
    	return repository.findByEmail(novoUsuario.getEmail()).map(UsuarioExistente  ->{
    		return Optional.empty();
    	}).orElseGet(() ->{
    		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    		String result = encoder.encode(novoUsuario.getSenha());
    		novoUsuario.setSenha(result);
    		return Optional.ofNullable(repository.save(novoUsuario));
    	});
	}
    public Optional<?> autenticador ( UsuarioLogin usuarioAutenticar ){
    	return repository.findByEmail(usuarioAutenticar.getEmail()).map(usuarioExistente ->{
    		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    		
    		if(encoder.matches(usuarioAutenticar.getSenha(),usuarioExistente.getSenha())) {
    	    String estruturaBasic =usuarioAutenticar.getEmail()+ ":" + usuarioAutenticar.getSenha();
    		byte[] autorizacaoBase64 =Base64.encodeBase64(estruturaBasic.getBytes(Charset.forName("US-ASCII")));
    		String autorizacaoHeader = "basic  " + new String (autorizacaoBase64);	  
    		
    		usuarioAutenticar.setToken(autorizacaoHeader);
			usuarioAutenticar.setId(usuarioExistente.getIdUsuario());
			usuarioAutenticar.setNome(usuarioExistente.getNome());
			usuarioAutenticar.setSenha(usuarioExistente.getSenha());
			return Optional.ofNullable(usuarioAutenticar);
    		
    		}
    		else {
    			return Optional.empty();
    		}
    	}).orElseGet(() -> {
    		return Optional.empty();
    	});
    	
 
    }

}
