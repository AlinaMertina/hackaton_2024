package com.hackaton.hariart.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "tags_publication")
public class TagsPublication {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_tag_publication")
	Integer idTagPublication;

	@JoinColumn(name = "id_publication")
	@ManyToOne
	Publication publication;

	@JoinColumn(name = "tag")
	@ManyToOne
	Tags tags;


	public TagsPublication(){}
	public Integer getIdTagPublication(){
		return this.idTagPublication;
	}
	public void setIdTagPublication(Integer idTagPublication){
		this.idTagPublication = idTagPublication;
	}
	public Publication getPublication(){
		return this.publication;
	}
	public void setPublication(Publication publication){
		this.publication = publication;
	}
	public Tags getTags(){
		return this.tags;
	}
	public void setTags(Tags tags){
		this.tags = tags;
	}

}
