package com.mycompany.tennis.controller;

import com.company.core.tennis.entity.Joueur;
import com.company.core.tennis.service.JoueurService;

import java.util.Scanner;

public class JoueurController {
    private JoueurService joueurService;

    public JoueurController(){
        this.joueurService = new JoueurService();
    }

    public void afficheDetailsJoueur(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Quel est l'identitifiant du joueur dont vous voulez aficher les informations ? ");

        long identifiant = scanner.nextLong();
        Joueur joueur = joueurService.getJoueur(identifiant);

        System.out.println("Le nom de ce joueur est: " + joueur.getNom() + " " + joueur.getPrenom());
    }

    public void creerJoueur(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Quel nom voulez vous pour le joueur ? ");
        String nom = scanner.nextLine();

        System.out.println("Quel prénom ? ");
        String prenom = scanner.nextLine();

        System.out.println("Quel sexe ? H/F");
        Character sexe = scanner.nextLine().charAt(0);

        Joueur joueur = new Joueur();
        joueur.setNom(nom);
        joueur.setPrenom(prenom);
        joueur.setSex(sexe);

        joueurService.create(joueur);

    }
}
