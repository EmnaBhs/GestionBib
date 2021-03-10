package com.GestionBib.service.ServiceImpl;

import com.GestionBib.connection.MyConnection;
import com.GestionBib.entities.Livre;
import com.GestionBib.service.IServiceDAO.IDAOGererLivre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOImplGererLivre implements IDAOGererLivre {
    protected Connection connect = null;

    public DAOImplGererLivre() {
        this.connect = MyConnection.getConnection();
    }

    @Override
    public boolean ajouter(Livre livre) throws SQLException {
        boolean ajout = false;

        try {


            PreparedStatement prepare = this.connect.prepareStatement("insert into livre (ISBN,theme,auteur,titre) values (?,?,?,?);");


            prepare.setString(1, livre.getISBN());
            prepare.setString(2, livre.getTheme());
            prepare.setString(3, livre.getAuteur());
            prepare.setString(4, livre.getTitre());


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


            PreparedStatement prepare = this.connect.prepareStatement("DELETE FROM livre where id=?;");


            prepare.setString(1, String.valueOf(id));


            prepare.executeUpdate();
            delete = true;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return delete;
    }

    @Override
    public boolean update(Livre livre) throws SQLException {
        boolean update = false;
        try {


            PreparedStatement prepare = this.connect.prepareStatement("update livre set ISBN=?,titre=?,theme=?,auteur=? where id=?;");


            prepare.setString(1, livre.getISBN());
            prepare.setString(2, livre.getTitre());
            prepare.setString(3, livre.getTheme());
            prepare.setString(4, livre.getAuteur());
            prepare.setString(5, String.valueOf(livre.getId()));


            prepare.executeUpdate();
            update = true;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return update;
    }

    @Override
    public Livre find(int id) {
        Livre a = null;
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM livre WHERE id = " + id);
            if (result.first())
                a = new Livre(
                        id,
                        result.getString("ISBN"),
                        result.getString("theme"),
                        result.getString("auteur"),
                        result.getString("titre"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a;
    }
}
