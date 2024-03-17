package com.hackaton.hariart.entity;

import jakarta.persistence.*;
import java.sql.Date;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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

	@JsonManagedReference
	@OneToMany
	@JoinTable(
		name = "preference",
		joinColumns = @JoinColumn(name = "id_profil"),
		inverseJoinColumns = @JoinColumn(name = "id_preference")
	)
	List<Preference> preferences; 

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
	
	public Date getDateNaissance() {
		return this.dateNaissance;
	}
	
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public Genre getGenre() {
		return this.genre;
	}


	public List<Preference> getPreferences() {
		return preferences;
	}

	public void setPreferences(List<Preference> preferences) {
		this.preferences = preferences;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public Nationalite getNationalite() {
		return this.nationalite;
	}

	public void setNationalite(Nationalite nationalite) {
		this.nationalite = nationalite;
	}

	public Publication[] proposer(String nombre) {
		Publication publication = new Publication();
		publication.setDescription("Plongez dans un monde de saveurs exquises avec notre nouvelle collection de recettes gastronomiques. De l'entrée au dessert, laissez-vous envoûter par des créations culinaires uniques et raffinées.");
		
		return null;
	}

}