package com.company.core.tennis.service;

import com.company.core.tennis.entity.Tournoi;
import com.company.core.tennis.repository.TournoisRepositoryImpl;

public class TournoiService {

    private TournoisRepositoryImpl tournoisRepository;

    public TournoiService(){
        this.tournoisRepository = new TournoisRepositoryImpl();
    }

    public void createTournoi(Tournoi tournoi){
        tournoisRepository.create(tournoi);
    }

    public Tournoi getTournoi(long id){
        return tournoisRepository.getById(id);
    }
}
