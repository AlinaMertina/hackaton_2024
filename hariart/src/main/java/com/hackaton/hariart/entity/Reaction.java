package com.hackaton.hariart.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "reaction")
public class Reaction {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_reaction")
	Integer idReaction;
	@JoinColumn(name = "id_profil")
	@ManyToOne
	Profil profil;
	@Column(name = "valeur")
	Integer valeur;
	@JoinColumn(name = "id_publication")
	@ManyToOne
	Publication publication;


	public Reaction(){}
	public Integer getIdReaction(){
		return this.idReaction;
	}
	public void setIdReaction(Integer idReaction){
		this.idReaction = idReaction;
	}
	public Profil getProfil(){
		return this.profil;
	}
	public void setProfil(Profil profil){
		this.profil = profil;
	}
	public Integer getValeur(){
		return this.valeur;
	}
	public void setValeur(Integer valeur){
		this.valeur = valeur;
	}
	public Publication getPublication(){
		return this.publication;
	}
	public void setPublication(Publication publication){
		this.publication = publication;
	}

}
