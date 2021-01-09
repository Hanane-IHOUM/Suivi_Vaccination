package com.proj.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Stock implements Serializable{

	@Id @GeneratedValue
	private long id;
	
	@OneToMany(targetEntity = Vaccin.class, mappedBy = "stock")
	private List<Vaccin> vaccins;

	@OneToOne
	private CentreSante centreSante;
	
	
	public Stock() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Stock(List<Vaccin> vaccins, CentreSante centreSante) {
		super();
		this.vaccins = vaccins;
		this.centreSante = centreSante;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<Vaccin> getVaccins() {
		return vaccins;
	}

	public void setVaccins(List<Vaccin> vaccins) {
		this.vaccins = vaccins;
	}



	public CentreSante getCentreSante() {
		return centreSante;
	}



	public void setCentreSante(CentreSante centreSante) {
		this.centreSante = centreSante;
	}
	
	

}
