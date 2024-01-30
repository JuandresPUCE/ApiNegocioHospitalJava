package com.negocio.hospital.services;

import org.springframework.stereotype.Service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;

import com.negocio.hospital.models.Medico;
import com.negocio.hospital.repositories.MedicoRepository;

@Service
public class MedicoService {
    @Autowired
    private MedicoRepository medicoRepository;

    //Insert into medico values (?,?,?,?,?,?,?) (insertar medico) https post
    public void guardarMedico(Medico medico){
        medicoRepository.save(medico);
    }

    //Update medico set nombre = ?, apellido = ?, especialidad = ?, sueldo = ?, edad = ?, aniosExperiencia = ? where id = ? (actualizar medico) https put
    public void actualizarMedico(Medico medico){
        medicoRepository.save(medico);
    }
    //delete from medico where id = ? (eliminar medico) https delete
    public void eliminarMedico(int id){
        medicoRepository.deleteById(id);
    }

    //select * from medico (todos los medicos) https get

    public List<Medico> listarTodosMedicos(){
        return medicoRepository.findAll();
    }

    //select * from medico where id = ? (medico por id) https get
    public Medico listarMedicoPorId(int id){
        return medicoRepository.findById(id).orElseThrow();
    }
    
    //select filtros
    public List<Medico> listarMedicoPorNombre(String nombre){
        return medicoRepository.findByNombre(nombre);
    }
    public List<Medico> listarMedicoPorApellido(String apellido){
        return medicoRepository.findByApellido(apellido);
    }
    public List<Medico> listarMedicoPorEspecialidad(String especialidad){
        return medicoRepository.findByEspecialidad(especialidad);
    }
    public List<Medico> listarMedicoPorSueldo(double sueldo){
        return medicoRepository.findBySueldo(sueldo);
    }
    public List<Medico> listarMedicoPorEdad(int edad){
        return medicoRepository.findByEdad(edad);
    }
    public List<Medico> listarMedicoPorAniosExperiencia(int aniosExperiencia){
        return medicoRepository.findByAniosExperiencia(aniosExperiencia);
    }

    //select * from medico where nombre = ? or apellido = ? (medico por nombre o apellido) https get
    public List<Medico> listarMedicoPorNombreOApellido(String nombre){
        return medicoRepository.findByNombreContainingOrApellidoStartingWith(nombre, nombre);
    }

    //select * from medico where edad >= ? (medico por edad mayor o igual) https get
    public List<Medico> listarMedicoEdadMayor(int edad){
        return medicoRepository.findByEdadGreaterThanEqual(edad);
    }

    //select * from medico where sueldo > ? (medico por sueldo mayor) https get
    public List<Medico> listarMedicoSueldoMayor(double sueldo){
        return medicoRepository.findBySueldoGreaterThan(sueldo);
    }

    //select * from medico where sueldo <= ? (medico por sueldo menor o igual) https get
    public List<Medico> listarMedicoSueldoMenor(double sueldo){
        return medicoRepository.findBySueldoLessThanEqual(sueldo);
    }

    //select * from medico where aniosExperiencia >= ? (medico por aniosExperiencia mayor o igual) https get
    public List<Medico> listarMedicoAniosExperienciaMayor(int aniosExperiencia){
        return medicoRepository.findByAniosExperienciaGreaterThanEqual(aniosExperiencia);
    }



    
}
