package com.negocio.hospital.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import com.negocio.hospital.models.MedicoSeeder;

@RestController
@RequestMapping("/api")

public class MedicoSeederController {

    private MedicoSeeder medicoSeeder;
    @Autowired
    public MedicoSeederController(MedicoSeeder medicoSeeder) {
        this.medicoSeeder = medicoSeeder;
    }
    @GetMapping("/seedMedicos")
    public String seedMedico() {
        medicoSeeder.seedDatabase();
        return "Base de datos sembrada con éxito desde el controlador.";
    }
    
}
