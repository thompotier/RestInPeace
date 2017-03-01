package com.M2ACSI.entity;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Demande {
	
	@Id
	@GeneratedValue
	private Long id;
	private String nom;
	private String prenom;
	private String adresse;
	private ArrayList<String> etatspossibles;
	private String etatactif;
	//private String etat;
	
	Demande(){
		//JPA
	}

	public Demande(String nom, String prenom, String adresse) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.etatspossibles = new ArrayList<>();
		etatspossibles.add("debut");
		etatspossibles.add("fin");
		etatspossibles.add("etude");
		etatspossibles.add("etudedetaillee");
		etatspossibles.add("approuvee");
		etatspossibles.add("rejet");
		this.etatactif = etatspossibles.get(0); //à l'initialisation l'état est "début"
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	@Override
	public String toString() {
		return "Demande [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", etat=" + etat
				+ "]";
	}

}
