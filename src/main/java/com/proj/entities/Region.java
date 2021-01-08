package com.proj.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Region implements Serializable{
	
	@Id @GeneratedValue
	private long id;
	
	@NotNull
	@Size(min=3,max=15)
	private String nom;
	
	@OneToMany(targetEntity = CentreSante.class, mappedBy = "region")
	private List<CentreSante> centres;

	public Region() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Region(@NotNull @Size(min = 3, max = 15) String nom, List<CentreSante> centres) {
		super();
		this.nom = nom;
		this.centres = centres;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<CentreSante> getCentres() {
		return centres;
	}

	public void setCentres(List<CentreSante> centres) {
		this.centres = centres;
	}
	
	

}
