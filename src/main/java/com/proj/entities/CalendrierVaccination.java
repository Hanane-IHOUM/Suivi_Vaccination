package com.proj.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class CalendrierVaccination implements Serializable {
	
	@Id @GeneratedValue
	private long id;
	
	@OneToMany(targetEntity = FicheVaccin.class, mappedBy = "calendrierVaccination")
	private List<FicheVaccin> ficheVaccins;
	
	@OneToMany(targetEntity = FicheSuppVitamines.class, mappedBy = "calendrierVaccination")
	private List<FicheSuppVitamines> ficheSuppVitamines;
	
	@OneToOne
	private Enfant enfant;

	public CalendrierVaccination() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public CalendrierVaccination(List<FicheVaccin> ficheVaccins, List<FicheSuppVitamines> ficheSuppVitamines,
			Enfant enfant) {
		super();
		this.ficheVaccins = ficheVaccins;
		this.ficheSuppVitamines = ficheSuppVitamines;
		this.enfant = enfant;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<FicheVaccin> getFicheVaccins() {
		return ficheVaccins;
	}

	public void setFicheVaccins(List<FicheVaccin> ficheVaccins) {
		this.ficheVaccins = ficheVaccins;
	}

	public List<FicheSuppVitamines> getFicheSuppVitamines() {
		return ficheSuppVitamines;
	}

	public void setFicheSuppVitamines(List<FicheSuppVitamines> ficheSuppVitamines) {
		this.ficheSuppVitamines = ficheSuppVitamines;
	}

	
	public Enfant getEnfant() {
		return enfant;
	}



	public void setEnfant(Enfant enfant) {
		this.enfant = enfant;
	}

	
	
	
}
