package com.hackaton.hariart.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "action")
public class Action {
	@Column(name = "note")
	Double note;
	@Column(name = "valeur")
	Integer valeur;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_action")
	Integer idAction;


	public Action(){}
	public Double getNote(){
		return this.note;
	}
	public void setNote(Double note){
		this.note = note;
	}
	public Integer getValeur(){
		return this.valeur;
	}
	public void setValeur(Integer valeur){
		this.valeur = valeur;
	}
	public Integer getIdAction(){
		return this.idAction;
	}
	public void setIdAction(Integer idAction){
		this.idAction = idAction;
	}

}
