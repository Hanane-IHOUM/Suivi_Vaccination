package com.proj.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class CentreSante implements Serializable{

	@Id @GeneratedValue
	private long id;
	
	@NotNull
	@Size(min=3,max=15)
	private String nom;
	
	@OneToMany(targetEntity = Enfant.class, mappedBy = "centreSante")
	private List<Enfant> enfants;
	
	@ManyToOne
	private Region region ;
	
	@OneToMany(targetEntity = User.class, mappedBy = "centreSante")
	private List<User> users;

	public CentreSante() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	


	public CentreSante(@NotNull @Size(min = 3, max = 15) String nom, List<Enfant> enfants, Region region,
			List<User> users) {
		super();
		this.nom = nom;
		this.enfants = enfants;
		this.region = region;
		this.users = users;
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

	public List<Enfant> getEnfants() {
		return enfants;
	}

	public void setEnfants(List<Enfant> enfants) {
		this.enfants = enfants;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}




	public List<User> getUsers() {
		return users;
	}




	public void setUsers(List<User> users) {
		this.users = users;
	}

	
}
