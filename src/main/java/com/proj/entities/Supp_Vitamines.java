package com.proj.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Supp_Vitamines implements Serializable {
	
	@Id @GeneratedValue
	private long id;
	
	@NotNull
	@Size(min=3,max=15)
	private String Nom;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date date;
	
	@NotNull
	private boolean etat;
	
	@ManyToOne
	private FicheVaccination ficheSupp ;

	public Supp_Vitamines() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Supp_Vitamines(@NotNull @Size(min = 3, max = 15) String nom, Date date, @NotNull boolean etat,
			FicheVaccination ficheSupp) {
		super();
		Nom = nom;
		this.date = date;
		this.etat = etat;
		this.ficheSupp = ficheSupp;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public boolean isEtat() {
		return etat;
	}

	public void setEtat(boolean etat) {
		this.etat = etat;
	}

	public FicheVaccination getFicheVaccination() {
		return ficheSupp;
	}

	public void setFicheVaccination(FicheVaccination ficheSupp) {
		this.ficheSupp = ficheSupp;
	}

	
	
}
