package com.hackaton.hariart.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "profil")
public class Profil {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_profil")
	Integer idProfil;
	@Column(name = "nom")
	String nom;
	@Column(name = "prenom")
	String prenom;
	@Column(name = "date_naissance")
	Date dateNaissance;
	@JoinColumn(name = "id_genre")
	@ManyToOne
	Genre genre;
	@JoinColumn(name = "id_nationalite")
	@ManyToOne
	Nationalite nationalite;


	public Profil(){}
	public Integer getIdProfil(){
		return this.idProfil;
	}
	public void setIdProfil(Integer idProfil){
		this.idProfil = idProfil;
	}
	public String getNom(){
		return this.nom;
	}
	public void setNom(String nom){
		this.nom = nom;
	}
	public String getPrenom(){
		return this.prenom;
	}
	public void setPrenom(String prenom){
		this.prenom = prenom;
	}
	public Date getDateNaissance(){
		return this.dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance){
		this.dateNaissance = dateNaissance;
	}
	public Genre getGenre(){
		return this.genre;
	}
	public void setGenre(Genre genre){
		this.genre = genre;
	}
	public Nationalite getNationalite(){
		return this.nationalite;
	}
	public void setNationalite(Nationalite nationalite){
		this.nationalite = nationalite;
	}

}
