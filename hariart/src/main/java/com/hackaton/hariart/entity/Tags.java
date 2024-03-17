package com.hackaton.hariart.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "tags")
public class Tags {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_tag")
	Integer idTag;
	@Column(name = "tag")
	String tag;


	public Tags(){}
	
	public Integer getIdTag(){
		return this.idTag;
	}
	public void setIdTag(Integer id){
		this.idTag = id;
	}
	public String getTag(){
		return this.tag;
	}
	public void setTag(String tag){
		this.tag = tag;
	}

	public double getPercent(Profil profil) {
		profil.getPercent();
		return 0.0;
	}

}
