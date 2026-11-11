package com.example.sitemaferreteriaartola.repository;

import com.example.sitemaferreteriaartola.entity.productoentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface productorepository extends JpaRepository<productoentity, Integer> {
    productoentity findTopByOrderByIdproductoDesc();
    productoentity findTopByOrderByCodigobarraDesc();
}