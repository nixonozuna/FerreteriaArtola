package com.example.sitemaferreteriaartola.repository;

import com.example.sitemaferreteriaartola.entity.categoriaproductoentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface categoriaproductorepository extends JpaRepository<categoriaproductoentity, Integer> {
    categoriaproductoentity findTopByOrderByIdcategoriaproductoDesc();
}