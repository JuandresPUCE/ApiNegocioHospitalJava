package com.negocio.hospital.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.negocio.hospital.models.PacienteSeeder;

@RestController
@RequestMapping("/api")

public class PacienteSeederController {
    private PacienteSeeder pacienteSeeder;

    @Autowired
    public PacienteSeederController(PacienteSeeder pacienteSeeder) {
        this.pacienteSeeder = pacienteSeeder;
    }

    @GetMapping("/seedPacientes")
    public String seedPaciente() {
        pacienteSeeder.seedDatabase();
        return "Base de datos sembrada con éxito desde el controlador.";
    }
    
}
