package com.example.sitemaferreteriaartola.repository;

import com.example.sitemaferreteriaartola.entity.usuarioentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface usuariorepository extends JpaRepository<usuarioentity, Integer> {
    usuarioentity findTopByOrderByIdusuarioDesc();
}