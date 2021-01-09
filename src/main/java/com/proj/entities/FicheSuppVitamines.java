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
public class FicheSuppVitamines implements Serializable {
	
	@Id @GeneratedValue
	private long id;
	
	@NotNull
	@Size(min=3,max=50)
	private String type_supp;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date date;
	
	@NotNull
	private boolean etat;
	
	@ManyToOne
	private CalendrierVaccination calendrierVaccination ;

	public FicheSuppVitamines() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public FicheSuppVitamines(@NotNull @Size(min = 3, max = 50) String type_supp, Date date, @NotNull boolean etat,
			CalendrierVaccination calendrierVaccination) {
		super();
		this.type_supp = type_supp;
		this.date = date;
		this.etat = etat;
		this.calendrierVaccination = calendrierVaccination;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getType_supp() {
		return type_supp;
	}

	public void setType_supp(String type_supp) {
		this.type_supp = type_supp;
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

	public CalendrierVaccination getCalendrierVaccination() {
		return calendrierVaccination;
	}

	public void setCalendrierVaccination(CalendrierVaccination calendrierVaccination) {
		this.calendrierVaccination = calendrierVaccination;
	}

	
}
