package com.frivclone.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.frivclone.models.Game;
import com.frivclone.repositories.GameRepository;

@ExtendWith(MockitoExtension.class)
class GameServiceTest {

    @Mock
    private GameRepository gameRepository;

    @InjectMocks
    private GameService gameService;

    private Game sampleGame;

    @BeforeEach
    void setUp() {
        sampleGame = new Game();
        sampleGame.setId(1L);
        sampleGame.setTitle("Super Mario");
        sampleGame.setCategory("Platform");
    }

    @Test
    void shouldReturnAllGames() {
        // Arrange
        when(gameRepository.findAll()).thenReturn(List.of(sampleGame));

        // Act
        List<Game> games = gameService.getAllGames();

        // Assert
        assertNotNull(games);
        assertEquals(1, games.size());
        assertEquals("Super Mario", games.get(0).getTitle());
        verify(gameRepository, times(1)).findAll();
    }

    @Test
    void shouldReturnGameWhenIdExists() {
        // Arrange
        when(gameRepository.findById(1L)).thenReturn(Optional.of(sampleGame));

        // Act
        Optional<Game> result = gameService.getGameById(1L);

        // Assert
        assertTrue(result.isPresent());
        assertEquals(sampleGame.getTitle(), result.get().getTitle());
        verify(gameRepository, times(1)).findById(1L);
    }

    @Test
    void shouldReturnEmptyWhenGameIdDoesNotExist() {
        // Arrange
        when(gameRepository.findById(99L)).thenReturn(Optional.empty());

        // Act
        Optional<Game> result = gameService.getGameById(99L);

        // Assert
        assertTrue(result.isEmpty());
        verify(gameRepository, times(1)).findById(99L);
    }

    @Test
    void shouldSaveAndReturnGame() {
        // Arrange
        when(gameRepository.save(any(Game.class))).thenReturn(sampleGame);

        // Act
        Game savedGame = gameService.saveGame(sampleGame);

        // Assert
        assertNotNull(savedGame);
        assertEquals("Super Mario", savedGame.getTitle());
        verify(gameRepository, times(1)).save(sampleGame);
    }

    @Test
    void shouldCallDeleteById() {
        // Arrange
        doNothing().when(gameRepository).deleteById(1L);

        // Act
        gameService.deleteGame(1L);

        // Assert
        verify(gameRepository, times(1)).deleteById(1L);
    }
}