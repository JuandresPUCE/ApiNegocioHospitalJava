package com.negocio.hospital.models;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.negocio.hospital.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

@Component
public class PacienteSeeder {

    private final PacienteRepository pacienteRepository;

    @Autowired
    public PacienteSeeder(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public void seedDatabase() {
        try {
            // Cargar datos desde el JSON
            List<Paciente> pacientes = Arrays.asList(loadPacientesFromJson());

            // Guardar en la base de datos
            pacienteRepository.saveAll(pacientes);

            System.out.println("Base de datos sembrada con éxito.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Paciente[] loadPacientesFromJson() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        URL url = new URL("https://raw.githubusercontent.com/JuandresPUCE/APIHospitalExamen/main/src/main/java/com/puce/hospital/model/Pacient.json");
        return objectMapper.readValue(url, Paciente[].class);
    }
}

