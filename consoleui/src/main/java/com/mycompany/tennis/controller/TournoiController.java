package com.mycompany.tennis.controller;

import com.company.core.tennis.entity.Tournoi;
import com.company.core.tennis.service.TournoiService;

import java.util.Scanner;

public class TournoiController {
    private TournoiService tournoiService;

    public TournoiController(){
        this.tournoiService = new TournoiService();
    }

    public void afficherDetailsTournoi(){

        Scanner scanner = new Scanner(System.in);

        System.out.println("De quel tournoi voulez-vous les détails ? ");
        long id = scanner.nextLong();

        Tournoi tournoi = tournoiService.getTournoi(id);
        System.out.println("Le tournoi séléctionné est: " + tournoi.getNom());
    }

    public void creerTournoi(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Quel est le nom du tournoi ? ");
        String nom = scanner.nextLine();

        System.out.println("Quel est le code du tournoi ? ");
        String code = scanner.nextLine();

        Tournoi tournoi = new Tournoi();
        tournoi.setNom(nom);
        tournoi.setCode(code);

        tournoiService.createTournoi(tournoi);
    }
}
