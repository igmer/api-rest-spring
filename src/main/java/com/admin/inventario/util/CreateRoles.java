package com.admin.inventario.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.admin.inventario.enums.RolName;
import com.admin.inventario.models.Rol;
import com.admin.inventario.service.RolService;

@Component
public class CreateRoles implements CommandLineRunner {

    @Autowired
    RolService rolService;

    @Override
    public void run(String... args) throws Exception {
       /* Rol rolAdmin = new Rol(RolName.ROLE_ADMIN);
        Rol rolUser = new Rol(RolName.ROLE_USER);
        rolService.save(rolAdmin);
        rolService.save(rolUser);*/
         
    }
}