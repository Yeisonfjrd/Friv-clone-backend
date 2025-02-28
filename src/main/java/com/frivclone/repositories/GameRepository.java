package com.frivclone.repositories;

import com.frivclone.models.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
    // Spring Data JPA creará automáticamente los métodos básicos CRUD
}