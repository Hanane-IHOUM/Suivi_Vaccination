package com.proj.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Vaccin implements Serializable{

	@Id @GeneratedValue
	private long id;
	
	@NotNull
	@Size(min=3,max=15)
	private String type_vaccin;
	
	@ManyToOne
	private Stock stock ;
	
	@OneToMany(targetEntity = Commande.class, mappedBy = "vaccin")
	private List<Commande> commandes;

	public Vaccin() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Vaccin(@NotNull @Size(min = 3, max = 15) String type_vaccin, Stock stock, List<Commande> commandes) {
		super();
		this.type_vaccin = type_vaccin;
		this.stock = stock;
		this.commandes = commandes;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getType_vaccin() {
		return type_vaccin;
	}

	public void setType_vaccin(String type_vaccin) {
		this.type_vaccin = type_vaccin;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}



	public List<Commande> getCommandes() {
		return commandes;
	}



	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}

	
	
	
}
