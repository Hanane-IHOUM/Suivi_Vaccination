package com.proj.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Commande implements Serializable{
	
	@Id @GeneratedValue
	private long id;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date date;
	
	@NotNull
	private int quantite;
	
	@ManyToOne
	private Vaccin vaccin ;
	
	

	public Commande() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Commande(Date date, @NotNull int quantite, Vaccin vaccin) {
		super();
		this.date = date;
		this.quantite = quantite;
		this.vaccin = vaccin;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}



	public Vaccin getVaccin() {
		return vaccin;
	}



	public void setVaccin(Vaccin vaccin) {
		this.vaccin = vaccin;
	}

	
	

}
