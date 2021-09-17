package com.lojadegames.lojadegames.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.lojadegames.lojadegames.model.UsuarioModel;
import com.lojadegames.lojadegames.model.utilites.UsuarioLogin;


public class UserDetaisimplements implements UserDetails {

	
	private static final long serialVersionUID = 1L;
	private String email;
	private String senha;
	private List<GrantedAuthority> autorizacao;
	

	public UserDetaisimplements( UsuarioModel user) {
		super();
		this.email = user.getEmail();
		this.senha = user.getSenha();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return autorizacao ;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return senha;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	 

	
	}
	
	



