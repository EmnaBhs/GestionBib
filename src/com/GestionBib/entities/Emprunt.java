package com.GestionBib.entities;

public class Emprunt {
    private int idEmprunt;

    private int idExemplaire;

    private int idEtudiant;

    public Emprunt() {

    }

    public Emprunt(int idEmprunt, int idExemplaire, int idEtudiant) {
        this.idEmprunt = idEmprunt;
        this.idExemplaire = idExemplaire;
        this.idEtudiant = idEtudiant;
    }

    public int getIdEmprunt() {
        return idEmprunt;
    }

    public void setIdEmprunt(int idEmprunt) {
        this.idEmprunt = idEmprunt;
    }

    public int getIdExemplaire() {
        return idExemplaire;
    }

    public void setIdExemplaire(int idExemplaire) {
        this.idExemplaire = idExemplaire;
    }

    public int getIdEtudiant() {
        return idEtudiant;
    }

    public void setIdEtudiant(int idEtudiant) {
        this.idEtudiant = idEtudiant;
    }
}
