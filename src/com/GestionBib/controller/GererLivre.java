package com.GestionBib.controller;

import com.GestionBib.entities.Livre;
import com.GestionBib.service.IServiceDAO.IDAOGererLivre;

import java.sql.SQLException;

public class GererLivre {
    IDAOGererLivre _DBLivre;

    public GererLivre(IDAOGererLivre db) {
        _DBLivre = db;
    }

    public boolean ajouter(Livre livre) {
        try {
            return _DBLivre.ajouter(livre);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean modifier(Livre livre) {
        try {
            return _DBLivre.update(livre);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean delete(int id) {
        try {
            return _DBLivre.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public Livre find(int id) {
        Livre livre = _DBLivre.find(id);
        return livre;

    }
}
