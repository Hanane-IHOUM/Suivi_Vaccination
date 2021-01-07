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
import javax.validation.constraints.Size;
import javax.persistence.Temporal;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Enfant implements Serializable{
	
	@Id @GeneratedValue
	private long id;
	
	@NotNull
	@Size(min=3,max=15)
	private String Nom;
	
	@NotNull
	@Size(min=3,max=15)
	private String Prénom;
	
	@NotNull
	private String Sexe;
	
	@NotNull
	@Size(min=3,max=30)
	private String Nom_Prénom_Père;
	
	@NotNull
	@Size(min=3,max=30)
	private String Nom_Prénom_Mère;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date naissance;
	
	@NotNull
	@Size(min=3,max=15)
	private String Lieu_Naiss;
	
	@NotNull
	@Size(min=3,max=50)
	private String Adresse;
	
	@NotNull
	@Size(min=8,max=10)
	private String cin_tuteur;
	
	private int tele_tuteur;
	
	@ManyToOne
	private FicheVaccination ficheVaccination ;

	
	public Enfant() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Enfant(@NotNull @Size(min = 3, max = 15) String nom, @NotNull @Size(min = 3, max = 15) String prénom,
			@NotNull String sexe, @NotNull @Size(min = 3, max = 30) String nom_Prénom_Père,
			@NotNull @Size(min = 3, max = 30) String nom_Prénom_Mère, Date naissance,
			@NotNull @Size(min = 3, max = 15) String lieu_Naiss, @NotNull @Size(min = 3, max = 50) String adresse,
			@NotNull @Size(min = 8, max = 10) String cin_tuteur, int tele_tuteur, FicheVaccination ficheVaccination) {
		super();
		Nom = nom;
		Prénom = prénom;
		Sexe = sexe;
		Nom_Prénom_Père = nom_Prénom_Père;
		Nom_Prénom_Mère = nom_Prénom_Mère;
		this.naissance = naissance;
		Lieu_Naiss = lieu_Naiss;
		Adresse = adresse;
		this.cin_tuteur = cin_tuteur;
		this.tele_tuteur = tele_tuteur;
		this.ficheVaccination = ficheVaccination;
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


	public String getPrénom() {
		return Prénom;
	}


	public void setPrénom(String prénom) {
		Prénom = prénom;
	}


	public String getSexe() {
		return Sexe;
	}


	public void setSexe(String sexe) {
		Sexe = sexe;
	}


	public String getNom_Prénom_Père() {
		return Nom_Prénom_Père;
	}


	public void setNom_Prénom_Père(String nom_Prénom_Père) {
		Nom_Prénom_Père = nom_Prénom_Père;
	}


	public String getNom_Prénom_Mère() {
		return Nom_Prénom_Mère;
	}


	public void setNom_Prénom_Mère(String nom_Prénom_Mère) {
		Nom_Prénom_Mère = nom_Prénom_Mère;
	}


	public Date getNaissance() {
		return naissance;
	}


	public void setNaissance(Date naissance) {
		this.naissance = naissance;
	}


	public String getLieu_Naiss() {
		return Lieu_Naiss;
	}


	public void setLieu_Naiss(String lieu_Naiss) {
		Lieu_Naiss = lieu_Naiss;
	}


	public String getAdresse() {
		return Adresse;
	}


	public void setAdresse(String adresse) {
		Adresse = adresse;
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


	public FicheVaccination getFicheVaccination() {
		return ficheVaccination;
	}


	public void setFicheVaccination(FicheVaccination ficheVaccination) {
		this.ficheVaccination = ficheVaccination;
	}
	
	
	
	
	
	
	
	
}