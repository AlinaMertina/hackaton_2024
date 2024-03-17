package com.hackaton.hariart.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "genre")
public class Genre {
	@Column(name = "valeur")
	String valeur;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_genre")
	Integer idGenre;


	public Genre(){}
	public String getValeur(){
		return this.valeur;
	}
	public void setValeur(String valeur){
		this.valeur = valeur;
	}
	public Integer getIdGenre(){
		return this.idGenre;
	}
	public void setIdGenre(Integer idGenre){
		this.idGenre = idGenre;
	}

}
