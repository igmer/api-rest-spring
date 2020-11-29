package com.admin.inventario.service;

import com.admin.inventario.enums.RolName;
import  com.admin.inventario.models.Rol;
import com.admin.inventario.repository.RolRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class RolService {

    @Autowired
    RolRepository rolRepository;

    public Optional<Rol> getByRolName(RolName rolName){
    	
    	System.out.println("aqui");
        System.out.println(rolName);
        return rolRepository.findByRolName(rolName);
    }

    public void save(Rol rol){
        rolRepository.save(rol);
    }
}
