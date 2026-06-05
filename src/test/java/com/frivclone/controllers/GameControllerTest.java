package com.frivclone.controllers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.frivclone.models.Game;
import com.frivclone.services.GameService;

@WebMvcTest(GameController.class)
class GameControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GameService gameService;

    @Autowired
    private ObjectMapper objectMapper;

    private Game sampleGame;

    @BeforeEach
    void setUp() {
        sampleGame = new Game();
        sampleGame.setId(1L);
        sampleGame.setTitle("Pac-Man");
        sampleGame.setCategory("Arcade");
    }

    @Test
    void shouldReturn200AndGameListWhenGetAllIsCalled() throws Exception {
        when(gameService.getAllGames()).thenReturn(List.of(sampleGame));

        mockMvc.perform(get("/api/games")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(1))
                .andExpect(jsonPath("$[0].title").value("Pac-Man"));
    }

    @Test
    void shouldReturn200AndGameWhenIdExists() throws Exception {
        when(gameService.getGameById(1L)).thenReturn(Optional.of(sampleGame));

        mockMvc.perform(get("/api/games/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Pac-Man"));
    }

    @Test
    void shouldReturn404WhenGameIsNotFoundById() throws Exception {
        when(gameService.getGameById(99L)).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/games/99")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    void shouldReturn201WhenGameIsCreatedOk() throws Exception {
        when(gameService.saveGame(any(Game.class))).thenReturn(sampleGame);

        mockMvc.perform(post("/api/games")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(sampleGame)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.title").value("Pac-Man"))
                .andExpect(jsonPath("$.id").value(1L));
    }

    @Test
    void shouldReturn200WhenGameIsUpdatedSuccessfully() throws Exception {
        when(gameService.getGameById(1L)).thenReturn(Optional.of(sampleGame));
        when(gameService.saveGame(any(Game.class))).thenReturn(sampleGame);

        sampleGame.setTitle("Pac-Man Updated");

        mockMvc.perform(put("/api/games/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(sampleGame)))
                .andExpect(status().isOk());
    }

    @Test
    void shouldReturn404WhenTryingToUpdateNonExistentGame() throws Exception {
        when(gameService.getGameById(99L)).thenReturn(Optional.empty());

        mockMvc.perform(put("/api/games/99")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(sampleGame)))
                .andExpect(status().isNotFound());
    }

    @Test
    void shouldReturn204WhenGameIsDeleted() throws Exception {
        when(gameService.getGameById(1L)).thenReturn(Optional.of(sampleGame));
        doNothing().when(gameService).deleteGame(1L);

        mockMvc.perform(delete("/api/games/1"))
                .andExpect(status().isNoContent());
    }

    @Test
    void shouldReturn404WhenTryingToDeleteNonExistentGame() throws Exception {
        when(gameService.getGameById(99L)).thenReturn(Optional.empty());

        mockMvc.perform(delete("/api/games/99"))
                .andExpect(status().isNotFound());
    }

    @Test
    void shouldReturn404WhenRequestingNonExistentImage() throws Exception {
        mockMvc.perform(get("/api/games/images/games/doesnotexist.jpg"))
                .andExpect(status().isNotFound());
    }
}