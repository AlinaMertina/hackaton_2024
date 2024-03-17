package com.hackaton.hariart.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;


@Entity
@Table(name = "preference")
public class Preference {

	@JoinColumn(name = "id_profil")
	@ManyToOne
	@JsonBackReference
	Profil profil;

	@Column(name = "note")
	Integer note;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_preference")
	Integer idPreference;

	@JoinColumn(name = "tag")
	@ManyToOne
	Tags tags;


	public Preference(){}

	public Profil getProfil(){
		return this.profil;
	}
	public void setProfil(Profil profil){
		this.profil = profil;
	}
	public Integer getNote(){
		return this.note;
	}
	public void setNote(Integer note){
		this.note = note;
	}
	public Integer getIdPreference(){
		return this.idPreference;
	}
	public void setIdPreference(Integer idPreference){
		this.idPreference = idPreference;
	}
	public Tags getTags(){
		return this.tags;
	}
	public void setTags(Tags tags){
		this.tags = tags;
	}

}
