package com.proj.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class FicheVaccination implements Serializable {
	
	@Id @GeneratedValue
	private long id;
	
	@OneToMany(targetEntity = Vaccin.class, mappedBy = "ficheVaccin")
	private List<Vaccin> viccins;
	
	@OneToMany(targetEntity = Supp_Vitamines.class, mappedBy = "ficheSupp")
	private List<Supp_Vitamines> supp;

	public FicheVaccination() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FicheVaccination(List<Vaccin> viccins, List<Supp_Vitamines> supp) {
		super();
		this.viccins = viccins;
		this.supp = supp;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<Vaccin> getViccins() {
		return viccins;
	}

	public void setViccins(List<Vaccin> viccins) {
		this.viccins = viccins;
	}

	public List<Supp_Vitamines> getSupp() {
		return supp;
	}

	public void setSupp(List<Supp_Vitamines> supp) {
		this.supp = supp;
	}

	
	
}
