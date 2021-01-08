package com.proj.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.Temporal;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Enfant implements Serializable{
	
	@Id @GeneratedValue
	private long id;
	
	@NotNull
	@Size(min=3,max=15)
	private String nom;
	
	@NotNull
	@Size(min=3,max=15)
	private String prenom;
	
	@NotNull
	private String sexe;
	
	@NotNull
	@Size(min=3,max=30)
	private String nom_prenom_pere;
	
	@NotNull
	@Size(min=3,max=30)
	private String nom_prenom_mere;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date naissance;
	
	@NotNull
	@Size(min=3,max=15)
	private String lieu_naissance;
	
	@NotNull
	@Size(min=3,max=50)
	private String adresse;
	
	@NotNull
	@Size(min=8,max=10)
	private String cin_tuteur;
	
	private int tele_tuteur;
	
	@OneToOne
	private CalendrierVaccination calendrierVaccination ;

	
	@ManyToOne
	private CentreSante centreSante ;


	public Enfant() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Enfant(@NotNull @Size(min = 3, max = 15) String nom, @NotNull @Size(min = 3, max = 15) String prenom,
			@NotNull String sexe, @NotNull @Size(min = 3, max = 30) String nom_prenom_pere,
			@NotNull @Size(min = 3, max = 30) String nom_prenom_mere, Date naissance,
			@NotNull @Size(min = 3, max = 15) String lieu_naissance, @NotNull @Size(min = 3, max = 50) String adresse,
			@NotNull @Size(min = 8, max = 10) String cin_tuteur, int tele_tuteur,
			CalendrierVaccination calendrierVaccination, CentreSante centreSante) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
		this.nom_prenom_pere = nom_prenom_pere;
		this.nom_prenom_mere = nom_prenom_mere;
		this.naissance = naissance;
		this.lieu_naissance = lieu_naissance;
		this.adresse = adresse;
		this.cin_tuteur = cin_tuteur;
		this.tele_tuteur = tele_tuteur;
		this.calendrierVaccination = calendrierVaccination;
		this.centreSante = centreSante;
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


	public String getSexe() {
		return sexe;
	}


	public void setSexe(String sexe) {
		this.sexe = sexe;
	}


	public String getNom_prenom_pere() {
		return nom_prenom_pere;
	}


	public void setNom_prenom_pere(String nom_prenom_pere) {
		this.nom_prenom_pere = nom_prenom_pere;
	}


	public String getNom_prenom_mere() {
		return nom_prenom_mere;
	}


	public void setNom_prenom_mere(String nom_prenom_mere) {
		this.nom_prenom_mere = nom_prenom_mere;
	}


	public Date getNaissance() {
		return naissance;
	}


	public void setNaissance(Date naissance) {
		this.naissance = naissance;
	}


	public String getLieu_naissance() {
		return lieu_naissance;
	}


	public void setLieu_naissance(String lieu_naissance) {
		this.lieu_naissance = lieu_naissance;
	}


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public String getCin_tuteur() {
		return cin_tuteur;
	}


	public void setCin_tuteur(String cin_tuteur) {
		this.cin_tuteur = cin_tuteur;
	}


	public int getTele_tuteur() {
		return tele_tuteur;
	}


	public void setTele_tuteur(int tele_tuteur) {
		this.tele_tuteur = tele_tuteur;
	}


	public CalendrierVaccination getCalendrierVaccination() {
		return calendrierVaccination;
	}


	public void setCalendrierVaccination(CalendrierVaccination calendrierVaccination) {
		this.calendrierVaccination = calendrierVaccination;
	}


	public CentreSante getCentreSante() {
		return centreSante;
	}


	public void setCentreSante(CentreSante centreSante) {
		this.centreSante = centreSante;
	}
	
	
	
	
}