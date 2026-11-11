package com.example.sitemaferreteriaartola.service;

import com.example.sitemaferreteriaartola.entity.rolentity;
import com.example.sitemaferreteriaartola.repository.rolrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class rolserviceIMPL implements rolservice {

    @Autowired
    private rolrepository rolrepository;

    @Override
    public List<rolentity> listarRoles() {
        return rolrepository.findAll();
    }
}