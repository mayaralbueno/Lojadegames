package com.lojadegames.lojadegames.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;


@Entity
public class categoriaModel {
	
	public @Id @GeneratedValue(strategy = GenerationType.IDENTITY ) Long idcategoria;
	public  String nome;
	private String idCategoria;
	public String idDescricao;
	private String objetocategoria;
	public Long getIdcategoria() {
		return idcategoria;
	}
	public void setIdcategoria(Long idcategoria) {
		this.idcategoria = idcategoria;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(String idCategoria) {
		this.idCategoria = idCategoria;
	}
	public String getIdDescricao() {
		return idDescricao;
	}
	public void setIdDescricao(String idDescricao) {
		this.idDescricao = idDescricao;
	}
	public String getObjetocategoria() {
		return objetocategoria;
	}
	public void setObjetocategoria(String objetocategoria) {
		this.objetocategoria = objetocategoria;
	}
	@OneToMany(mappedBy =  "origin", cascade =  CascadeType.REMOVE)
	@JsonIgnoreProperties({"origin"})
	private List<produtoModel> meusproduros = new ArrayList<>();
	
	

}
