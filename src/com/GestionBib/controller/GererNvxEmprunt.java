package com.GestionBib.controller;

import com.GestionBib.entities.Emprunt;
import com.GestionBib.service.IServiceDAO.IDAOGererNvxEmprunt;

import java.sql.SQLException;
import java.util.List;

public class GererNvxEmprunt {
    IDAOGererNvxEmprunt _DBNvxEmprunt;

    public GererNvxEmprunt(IDAOGererNvxEmprunt db) {
        _DBNvxEmprunt = db;
    }

    public boolean ajouter(Emprunt emprunt) {
        try {
            return _DBNvxEmprunt.ajouter(emprunt);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean modifier(Emprunt emprunt) {
        try {
            return _DBNvxEmprunt.update(emprunt);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean delete(int id) {
        try {
            return _DBNvxEmprunt.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public Emprunt find(int id) {
        Emprunt emprunt = _DBNvxEmprunt.find(id);
        return emprunt;

    }

    public List<Emprunt> findAll() {
        return _DBNvxEmprunt.getAll();

    }
}

