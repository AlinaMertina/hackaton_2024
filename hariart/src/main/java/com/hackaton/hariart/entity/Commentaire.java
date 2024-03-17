package com.hackaton.hariart.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "commentaire")
public class Commentaire {
	@JoinColumn(name = "id_profil")
	@ManyToOne
	Profil profil;
	@Column(name = "valeur")
	String valeur;
	@JoinColumn(name = "id_publication")
	@ManyToOne
	Publication publication;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_commentaire")
	Integer idCommentaire;


	public Commentaire(){}
	public Profil getProfil(){
		return this.profil;
	}
	public void setProfil(Profil profil){
		this.profil = profil;
	}
	public String getValeur(){
		return this.valeur;
	}
	public void setValeur(String valeur){
		this.valeur = valeur;
	}
	public Publication getPublication(){
		return this.publication;
	}
	public void setPublication(Publication publication){
		this.publication = publication;
	}
	public Integer getIdCommentaire(){
		return this.idCommentaire;
	}
	public void setIdCommentaire(Integer idCommentaire){
		this.idCommentaire = idCommentaire;
	}

}
