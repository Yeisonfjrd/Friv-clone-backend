package com.frivclone.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frivclone.models.Game;
import com.frivclone.repositories.GameRepository;

@Service
public class GameService {
    
    private final GameRepository gameRepository;
    
    @Autowired
    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }
    
    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }
    
    public Optional<Game> getGameById(Long id) {
        return gameRepository.findById(id);
    }
    
    public Game saveGame(Game game) {
        return gameRepository.save(game);
    }
    
    public void deleteGame(Long id) {
        gameRepository.deleteById(id);
    }
}