package com.negocio.hospital.repositories;

//segundo crear repositorio
import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;

import com.negocio.hospital.models.Medico;


public interface MedicoRepository extends JpaRepository<Medico, Integer>{

    
    List<Medico> findByNombre(String nombre);
    List<Medico> findByApellido(String apellido);
    List<Medico> findByEspecialidad(String especialidad);
    List<Medico> findBySueldo(double sueldo);
    List<Medico> findByEdad(int edad);
    List<Medico> findByAniosExperiencia(int aniosExperiencia);
    List<Medico> findByNombreContainingOrApellidoStartingWith(String nombre, String apellido);
    List<Medico> findByEdadGreaterThanEqual(int edad);
    List<Medico> findBySueldoGreaterThan(double sueldo);
    List<Medico> findBySueldoLessThanEqual(double sueldo);
    List<Medico> findByAniosExperienciaGreaterThanEqual(int aniosExperiencia);
    
}
