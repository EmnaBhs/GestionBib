package com.GestionBib.entities;

public class Livre {
    private int id;
    private String ISBN;
    private String titre;
    private String theme;
    private String auteur;

    public Livre() {

    }

    public Livre(int id, String ISBN, String theme, String auteur, String titre) {
        this.id = id;
        this.ISBN = ISBN;
        this.theme = theme;
        this.auteur = auteur;
        this.titre = titre;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }
}
