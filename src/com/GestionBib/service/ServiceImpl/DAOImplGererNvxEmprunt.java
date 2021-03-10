package com.GestionBib.service.ServiceImpl;

import com.GestionBib.connection.MyConnection;
import com.GestionBib.entities.Emprunt;
import com.GestionBib.service.IServiceDAO.IDAOGererNvxEmprunt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOImplGererNvxEmprunt implements IDAOGererNvxEmprunt {
    protected Connection connect = null;

    public DAOImplGererNvxEmprunt() {
        this.connect = MyConnection.getConnection();
    }

    @Override
    public boolean ajouter(Emprunt emprunt) throws SQLException {
        boolean ajout = false;

        try {


            PreparedStatement prepare = this.connect.prepareStatement("insert into Emprunt (idEtudiant,idExemplaire) values (?,?);");


            prepare.setString(1, String.valueOf(emprunt.getIdEtudiant()));
            prepare.setString(2, String.valueOf(emprunt.getIdExemplaire()));


            prepare.executeUpdate();
            ajout = true;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ajout;
    }

    @Override
    public boolean delete(int id) {
        boolean delete = false;


        try {


            PreparedStatement prepare = this.connect.prepareStatement("DELETE FROM Emprunt where idEmprunt=?;");


            prepare.setString(1, String.valueOf(id));


            prepare.executeUpdate();
            delete = true;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return delete;
    }

    @Override
    public boolean update(Emprunt emprunt) throws SQLException {
        boolean update = false;
        try {


            PreparedStatement prepare = this.connect.prepareStatement("update Emprunt set idEtudiant=?,idExemplaire=? where idEmprunt=?;");


            prepare.setString(1, String.valueOf(emprunt.getIdEmprunt()));
            prepare.setString(2, String.valueOf(emprunt.getIdEtudiant()));
            prepare.setString(3, String.valueOf(emprunt.getIdExemplaire()));


            prepare.executeUpdate();
            update = true;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return update;
    }

    @Override
    public Emprunt find(int id) {
        Emprunt a = null;
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Emprunt WHERE idEmprunt = " + id);
            if (result.first())
                a = new Emprunt(
                        id,
                        result.getInt("idEtudiant"),
                        result.getInt("idExemplaire"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a;
    }

    @Override
    public List<Emprunt> getAll() {
        List<Emprunt> a = new ArrayList<>();

        try {

            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Emprunt");
            while (result.next()) {
                a.add(new Emprunt(
                        result.getInt("idEmprunt"),
                        result.getInt("idEtudiant"),
                        result.getInt("idExemplaire")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return a;
    }
}
