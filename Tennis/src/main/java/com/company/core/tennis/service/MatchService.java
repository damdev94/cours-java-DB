package com.company.core.tennis.service;

import com.company.core.tennis.entity.Match;
import com.company.core.tennis.repository.MatchRepositoryImpl;
import com.company.core.tennis.repository.ScoreRepositoryImpl;

public class MatchService {

    ScoreRepositoryImpl scoreRepository;
    MatchRepositoryImpl matchRepository;

    public MatchService(){
        this.scoreRepository = new ScoreRepositoryImpl();
        this.matchRepository = new MatchRepositoryImpl();
    }

    public void enregistrerNouveauMatch(Match match){

        matchRepository.create( match );
        scoreRepository.create(match.getScore());

    }
}
