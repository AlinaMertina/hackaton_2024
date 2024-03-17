package com.hackaton.hariart.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "publication")
public class Publication {

	@JoinColumn(name = "id_profil")
	@ManyToOne
	Profil profil;

	@Column(name = "nombre_vue")
	Integer nombreVue;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_publication")
	Integer idPublication;

	@Column(name = "latitude")
	Double latitude;

	@Column(name = "date_debut")
	Date dateDebut;

	@Column(name = "description")
	String description;
	
	@Column(name = "date_fin")
	Date dateFin;
	
	@Column(name = "longitude")
	Double longitude;


	@ManyToMany
	@JoinTable(
		name = "media_publication",
		joinColumns = @JoinColumn(name = "id_publication"),
		inverseJoinColumns = @JoinColumn(name = "id_media")
	)
	List<Media> medias;


	@ManyToMany
	@JoinTable(
		name = "tags_publication",
		joinColumns = @JoinColumn(name = "id_publication"),
		inverseJoinColumns = @JoinColumn(name = "tag")
	)
	List<Tags> tags;

	public Publication(){}
	public Profil getProfil(){
		return this.profil;
	}
	public void setProfil(Profil profil){
		this.profil = profil;
	}
	public Integer getNombreVue(){
		return this.nombreVue;
	}
	public void setNombreVue(Integer nombreVue){
		this.nombreVue = nombreVue;
	}
	public Integer getIdPublication(){
		return this.idPublication;
	}
	public void setIdPublication(Integer idPublication){
		this.idPublication = idPublication;
	}
	public Double getLatitude(){
		return this.latitude;
	}
	public void setLatitude(Double latitude){
		this.latitude = latitude;
	}
	public Date getDateDebut(){
		return this.dateDebut;
	}
	public void setDateDebut(Date dateDebut){
		this.dateDebut = dateDebut;
	}
	public String getDescription(){
		return this.description;
	}
	public void setDescription(String description){
		this.description = description;
	}
	public Date getDateFin(){
		return this.dateFin;
	}
	public void setDateFin(Date dateFin){
		this.dateFin = dateFin;
	}
	public Double getLongitude(){
		return this.longitude;
	}
	public void setLongitude(Double longitude){
		this.longitude = longitude;
	}
	public List<Media> getMedias() {
		return medias;
	}
	public void setMedias(List<Media> medias) {
		this.medias = medias;
	}
	public List<Tags> getTags() {
		return tags;
	}
	public void setTags(List<Tags> tags) {
		this.tags = tags;
	}

}
