package com.hackaton.hariart.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "tags")
public class Tags {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "tag")
	Integer tag;


	public Tags(){}
	public Integer getTag(){
		return this.tag;
	}
	public void setTag(Integer tag){
		this.tag = tag;
	}

}
