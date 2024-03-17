package com.hackaton.hariart.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "nationalite")
public class Nationalite {
	@Column(name = "valeur")
	String valeur;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_nationalite")
	Integer idNationalite;


	public Nationalite(){}
	public String getValeur(){
		return this.valeur;
	}
	public void setValeur(String valeur){
		this.valeur = valeur;
	}
	public Integer getIdNationalite(){
		return this.idNationalite;
	}
	public void setIdNationalite(Integer idNationalite){
		this.idNationalite = idNationalite;
	}

}
