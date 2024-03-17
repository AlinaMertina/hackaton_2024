package com.hackaton.hariart.entity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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

	public double getPercent() {
		return ((this.getNote() * 100) / this.getProfil().getNoteTotal());
	}

	public Publication[] proposer(Connection connection) throws SQLException {
		String sql = "SELECT * FROM publication WHERE id_tags = '%s'";
		List<Publication> publications = new ArrayList<>();
		try (Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(String.format(sql, this.getTags().getIdTag()))) {
			Publication publication = new Publication();
			publication.setDescription(resultSet.getString(1));
			publication.setDateDebut(resultSet.getDate(2));
			publication.setDateFin(resultSet.getDate(3));
			publications.add(publication);
		}
		return null;
	}

}