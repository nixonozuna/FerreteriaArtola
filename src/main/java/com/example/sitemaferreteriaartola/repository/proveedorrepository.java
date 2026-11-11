package com.example.sitemaferreteriaartola.repository;

import com.example.sitemaferreteriaartola.entity.proveedorentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface proveedorrepository extends JpaRepository<proveedorentity, Integer> {
    proveedorentity findTopByOrderByIdproveedorDesc();
}