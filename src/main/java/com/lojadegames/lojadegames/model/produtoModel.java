package com.lojadegames.lojadegames.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;


public class produtoModel {
	
	public @Id @GeneratedValue(strategy  =GenerationType.IDENTITY) long produto;
	private Long idProduto;
	private String nome;
	private String fabricante;
	public long getProduto() {
		return produto;
	}
	public void setProduto(long produto) {
		this.produto = produto;
	}
	public Long getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getFabricante() {
		return fabricante;
	}
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	 @ManyToOne
	 @JoinColumn(name = "origin_id")
	 @JsonIgnoreProperties({"meusprodutos"})
	 private categoriaModel origin;
	

}
