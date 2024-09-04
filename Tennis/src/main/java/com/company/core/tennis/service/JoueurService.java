package com.company.core.tennis.service;

import com.company.core.tennis.entity.Joueur;
import com.company.core.tennis.repository.JoueurRepositoryImpl;

public class JoueurService {

    private JoueurRepositoryImpl joueurRepository;

    public JoueurService(){
        this.joueurRepository = new JoueurRepositoryImpl();
    }

    public void create(Joueur joueur){
        joueurRepository.create(joueur);
    }

    public Joueur getJoueur(long id){
       return joueurRepository.getById(id);
    }

}
