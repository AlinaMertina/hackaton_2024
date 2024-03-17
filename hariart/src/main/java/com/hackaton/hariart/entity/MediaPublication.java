package com.hackaton.hariart.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;


@Entity
@Table(name = "media_publication")
public class MediaPublication {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_media_publication")
	Integer idMediaPublication;

	@JoinColumn(name = "id_publication")
	@ManyToOne
	Publication publication;

	@JoinColumn(name = "id_media")
	@ManyToOne
	Media media;


	public MediaPublication(){}
	public Integer getIdMediaPublication(){
		return this.idMediaPublication;
	}
	public void setIdMediaPublication(Integer idMediaPublication){
		this.idMediaPublication = idMediaPublication;
	}
	public Publication getPublication(){
		return this.publication;
	}
	public void setPublication(Publication publication){
		this.publication = publication;
	}
	public Media getMedia(){
		return this.media;
	}
	public void setMedia(Media media){
		this.media = media;
	}

}
