package com.company.core.tennis.repository;

import com.company.core.tennis.DataSourceProvider;
import com.company.core.tennis.entity.Tournoi;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TournoisRepositoryImpl {

    Tournoi tournoi = new Tournoi();

    public void create(Tournoi tournoi){
        Connection conn = null;
        try{
            DataSource dataSource = DataSourceProvider.getSingleDataSourceInstance();

            conn = dataSource.getConnection();

            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO TOURNOI (NOM, CODE) VALUES(?, ?)", Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, tournoi.getNom());
            preparedStatement.setString(2, tournoi.getCode());

            preparedStatement.executeUpdate();

            ResultSet rs = preparedStatement.getGeneratedKeys();

            if(rs.next()){
                tournoi.setId(rs.getLong(1));
            }

            System.out.println("Tournoi crée");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (conn!=null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void update(Tournoi tournoi){
        Connection conn = null;
        try{
            DataSource dataSource = DataSourceProvider.getSingleDataSourceInstance();

            conn = dataSource.getConnection();

            PreparedStatement preparedStatement = conn.prepareStatement("UPDATE TOURNOI SET NOM=?, CODE=? WHERE ID=?");

            preparedStatement.setString(1, tournoi.getNom());
            preparedStatement.setString(2, tournoi.getCode());
            preparedStatement.setLong(3, tournoi.getId());

            preparedStatement.executeUpdate();

            System.out.println("Tournoi Modifié");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (conn!=null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public Tournoi getById(Long id){
        Connection conn = null;
        Tournoi tournoi = null;
        try{
            DataSource dataSource = DataSourceProvider.getSingleDataSourceInstance();

            conn = dataSource.getConnection();

            PreparedStatement preparedStatement = conn.prepareStatement("SELECT NOM, CODE FROM TOURNOI WHERE ID=?");

            preparedStatement.setLong(1, id);

            ResultSet rs = preparedStatement.executeQuery();

            if(rs.next()){
                tournoi = new Tournoi();
                tournoi.setId(id);
                tournoi.setNom(rs.getString("NOM"));
                tournoi.setCode(rs.getString("CODE"));
            }

            System.out.println("Tournoi trouvé");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (conn!=null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return tournoi;
    }

    public Tournoi delete(Long id){
        Connection conn = null;
        Tournoi tournoi = null;
        try{
            DataSource dataSource = DataSourceProvider.getSingleDataSourceInstance();

            conn = dataSource.getConnection();

            PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM TOURNOI WHERE ID=?");

            preparedStatement.setLong(1, id);

            preparedStatement.executeUpdate();

            System.out.println("Tournoi supprimé");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (conn!=null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return tournoi;
    }

    public List<Tournoi> list(){
        Connection conn = null;
        Tournoi tournoi = null;
        List<Tournoi> tournois = new ArrayList<>();
        try{
            DataSource dataSource = DataSourceProvider.getSingleDataSourceInstance();

            conn = dataSource.getConnection();

            PreparedStatement preparedStatement = conn.prepareStatement("SELECT NOM, ID, CODE FROM TOURNOI");

            ResultSet rs =preparedStatement.executeQuery();

            while (rs.next()){
                tournoi = new Tournoi();
                tournoi.setNom(rs.getString("NOM"));
                tournoi.setId(rs.getLong("ID"));
                tournoi.setCode(rs.getString("CODE"));
                tournois.add(tournoi);
            }

            System.out.println("Liste des tournois");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (conn!=null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return tournois;
    }
}
