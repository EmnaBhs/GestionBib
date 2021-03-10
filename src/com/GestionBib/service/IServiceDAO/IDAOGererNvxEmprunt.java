package com.GestionBib.service.IServiceDAO;

import com.GestionBib.entities.Emprunt;
import java.sql.SQLException;
import java.util.List;

public interface IDAOGererNvxEmprunt {
    boolean ajouter(Emprunt em) throws SQLException;

    boolean delete(int id) throws SQLException;

    boolean update(Emprunt em) throws SQLException;

    Emprunt find(int id);

    List<Emprunt> getAll();

}
