package com.company.core.tennis;
import com.company.core.tennis.entity.*;
import com.company.core.tennis.service.MatchService;

import java.sql.SQLException;

public class Cours {
    public static void main(String... args) throws SQLException {
        MatchService matchService = new MatchService();
        Match match = new Match();
        Score score = new Score();
        score.setSet1((byte) 3);
        score.setSet2((byte) 4);
        score.setSet3((byte) 6);
        match.setScore(score);
        score.setMatch(match);

        Joueur federer = new Joueur();
        federer.setId(32L);

        Joueur murray = new Joueur();
        murray.setId(34L);

        match.setVainqueur(federer);
        match.setFinaliste(murray);

        Epreuve epreuve = new Epreuve();
        epreuve.setId(10L);
        match.setEpreuve(epreuve);

        matchService.enregistrerNouveauMatch(match);

        System.out.println("L'identitfiant du match crée est le " + match.getId());

    }
}
