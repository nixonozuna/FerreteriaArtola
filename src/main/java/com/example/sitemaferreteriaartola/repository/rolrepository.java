package com.example.sitemaferreteriaartola.repository;

import com.example.sitemaferreteriaartola.entity.rolentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface rolrepository extends JpaRepository<rolentity, Long> {
}

