package com.example.sitemaferreteriaartola.repository;

import com.example.sitemaferreteriaartola.entity.permisoentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface permisorepository extends JpaRepository<permisoentity, Integer> {
}