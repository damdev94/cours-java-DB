package com.company.core.tennis;
import com.company.core.tennis.entity.Joueur;
import com.company.core.tennis.entity.Tournoi;
import com.company.core.tennis.repository.JoueurRepositoryImpl;
import com.company.core.tennis.repository.TournoisRepositoryImpl;
import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;

public class TestDeConnection {
    public static void main(String... args){
        TournoisRepositoryImpl tournoisRepository = new TournoisRepositoryImpl();

        List<Tournoi> tournois = tournoisRepository.list();

        for(Tournoi tournoi : tournois){
            System.out.println(tournoi.getNom() + " " + tournoi.getCode());
        }

    }
}
