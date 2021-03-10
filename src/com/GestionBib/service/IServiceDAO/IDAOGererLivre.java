package com.GestionBib.service.IServiceDAO;


import com.GestionBib.entities.Livre;

import java.sql.SQLException;

public interface IDAOGererLivre {

    boolean ajouter(Livre livre) throws SQLException;


    boolean delete(int id) throws SQLException;


    boolean update(Livre livre) throws SQLException;


    Livre find(int id);
}

