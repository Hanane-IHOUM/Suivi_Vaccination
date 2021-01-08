package com.proj.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class User implements Serializable {
	
	@Id @GeneratedValue
	private long id;
	
	@NotNull
	@Size(min=3,max=15)
	private String nom;
	
	@NotNull
	@Size(min=3,max=15)
	private String prenom;
	
	
	@NotNull
	@Size(min=3,max=30)
	private String email;
	
	
	@NotNull
	@Size(min=3,max=50)
	private String password;
	
	@NotNull
	@Size(min=8,max=10)
	private String role;
	
	private boolean active;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(@NotNull @Size(min = 3, max = 15) String nom, @NotNull @Size(min = 3, max = 15) String prenom,
			@NotNull @Size(min = 3, max = 30) String email, @NotNull @Size(min = 3, max = 50) String password,
			@NotNull @Size(min = 8, max = 10) String role, boolean active) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
		this.role = role;
		this.active = active;
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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	
	

}
