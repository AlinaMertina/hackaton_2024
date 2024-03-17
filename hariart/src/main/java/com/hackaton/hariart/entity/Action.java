package com.hackaton.hariart.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "action")
public class Action {
	@Column(name = "note")
	int note;
	@Column(name = "valeur")
	String valeur;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_action")
	Integer idAction;


	public Action(){}
	public int getNote(){
		return this.note;
	}
	public void setNote(int note){
		this.note = note;
	}
	public String getValeur(){
		return this.valeur;
	}
	public void setValeur(String valeur){
		this.valeur = valeur;
	}
	public Integer getIdAction(){
		return this.idAction;
	}
	public void setIdAction(Integer idAction){
		this.idAction = idAction;
	}

}
