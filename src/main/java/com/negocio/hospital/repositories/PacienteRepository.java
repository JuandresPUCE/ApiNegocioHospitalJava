package com.negocio.hospital.repositories;
//segundo crear repositorio

//para la lista java.util.List
import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
//importar el modelo de paciente
import com.negocio.hospital.models.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Integer>{

    //metodo buscar por nombre
    List<Paciente> findByNombre(String nombre);

    //metodo buscar por apellido
    List<Paciente> findByApellido(String apellido);
    //metodo buscar por edad
    List<Paciente> findByEdad(int edad);
    //metodo buscar por peso
    List<Paciente> findByPeso(double peso);
    //metodo buscar por altura
    List<Paciente> findByAltura(double altura);
    //metodo buscar por nombre o apellido
    List<Paciente> findByNombreContainingOrApellidoStartingWith(String nombre, String apellido);
    //Filtros
    //metodo buscar mayores o iguales a puede ser 18 años el entero
    List<Paciente> findByEdadGreaterThanEqual(int edad);
    //metodo peso mayor
    List<Paciente> findByPesoGreaterThan(double peso);
    //metodo altura menor
    List<Paciente> findByAlturaLessThan(double altura);



    
}
