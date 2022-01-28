package fr.mspr;

import java.util.ArrayList;
import java.util.List;

public class Agent{

    private String nom;
    private String prenom;
    private String role;
    private String mdp;
    private String id;
    private List<String> equipements;

    public Agent (String id) {

        this.id = id;
        this.equipements = new ArrayList<>();
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<String> getEquipements() {
		return equipements;
	}

	public void addEquipement(String equipement) {
		this.equipements.add(equipement);
	}
    

}