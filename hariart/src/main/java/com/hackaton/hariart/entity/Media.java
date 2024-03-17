package com.hackaton.hariart.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "media")
public class Media {
	@Column(name = "valeur")
	String valeur;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_media")
	Integer idMedia;
	@Column(name = "type")
	Integer type;


	public Media(){}
	public String getValeur(){
		return this.valeur;
	}
	public void setValeur(String valeur){
		this.valeur = valeur;
	}
	public Integer getIdMedia(){
		return this.idMedia;
	}
	public void setIdMedia(Integer idMedia){
		this.idMedia = idMedia;
	}
	public Integer getType(){
		return this.type;
	}
	public void setType(Integer type){
		this.type = type;
	}

}
