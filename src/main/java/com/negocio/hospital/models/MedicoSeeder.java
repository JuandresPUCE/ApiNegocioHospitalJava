package com.negocio.hospital.models;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.negocio.hospital.repositories.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Component
public class MedicoSeeder {
    private MedicoRepository medicoRepository;

    @Autowired
    public MedicoSeeder(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    public void seedDatabase() {
        try {
            // Cargar datos desde el JSON local
            List<Medico> medicos = Arrays.asList(loadMedicosFromJson());

            // Guardar en la base de datos
            medicoRepository.saveAll(medicos);

            System.out.println("Base de datos de médicos sembrada con éxito.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Medico[] loadMedicosFromJson() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        // Ruta absoluta al archivo Medico.json
        //String filePath = "D:\\backend\\PracticasExamen\\Hospital\\hospital\\src\\main\\java\\com\\negocio\\hospital\\models\\Medico.json";
        String filePath = "src/main/java/com/negocio/hospital/models/Medico.json";
        //revisar ruta
        return objectMapper.readValue(new File(filePath), Medico[].class);
    }
}
