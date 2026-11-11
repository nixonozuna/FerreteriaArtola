package com.example.sitemaferreteriaartola.repository;

import com.example.sitemaferreteriaartola.entity.unidadmedidaentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface unidadmedidarepository extends JpaRepository<unidadmedidaentity, Integer> {
    unidadmedidaentity findTopByOrderByIdunidadmedidaDesc();
}