package com.frivclone.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.frivclone.models.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
}