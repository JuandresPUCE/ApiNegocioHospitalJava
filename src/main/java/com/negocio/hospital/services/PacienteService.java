package com.negocio.hospital.services;
//tercer paso crear servicio

//para la lista java.util.List
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//importar el modelo de paciente y repositorio
import com.negocio.hospital.models.Paciente;
import com.negocio.hospital.repositories.PacienteRepository;

@Service
public class PacienteService {
    //inyectar el repositorio
    @Autowired
    //objeto de tipo PacienteRepository
    private PacienteRepository pacienteRepository;

    //interaccion con base de datos

    //Select * from paciente (todos los pacientes) https get
    public List<Paciente> listarTodosPacientes(){
        //retornar todos los pacientes
        return pacienteRepository.findAll();
    }

    //Select * from paciente where id = ? (paciente por id) https get
    public Paciente listarPacientePorId(int id){
        //retornar paciente por id
        return pacienteRepository.findById(id).orElseThrow();
    }

    //Insert into paciente values (?,?,?,?) (insertar paciente) https post
    public void guardarPaciente(Paciente paciente){
        //guardar paciente
        pacienteRepository.save(paciente);
    }

    //Update paciente set nombre = ?, apellido = ?, edad = ?, peso = ?, altura = ? where id = ? (actualizar paciente) https put
    public void actualizarPaciente(Paciente paciente){
        //actualizar paciente
        pacienteRepository.save(paciente);
    }

    //Delete from paciente where id = ? (eliminar paciente) https delete
    public void eliminarPaciente(int id){
        //eliminar paciente
        pacienteRepository.deleteById(id);
    }

    //select filtros 

    public List<Paciente> listarPacientePorNombre(String nombre){
        //retornar paciente por nombre
        return pacienteRepository.findByNombre(nombre);
    }
    public List<Paciente> listarPacientePorApellido(String apellido){
        //retornar paciente por apellido
        return pacienteRepository.findByApellido(apellido);
    }

    //buscar paciente por nombre o apellido
    public List<Paciente> listarPacienteNombreOApellido(String nombre){
        //retornar paciente por nombre o apellido
        return pacienteRepository.findByNombreContainingOrApellidoStartingWith(nombre, nombre);
    }

    //buscar edad mayor o igual
    public List<Paciente> listarPacienteEdadMayor(int edad){
        //retornar paciente por edad mayor o igual
        return pacienteRepository.findByEdadGreaterThanEqual(edad);
    }

    //buscar peso mayor
    public List<Paciente> listarPacientePesoMayor(double peso){
        //retornar paciente por peso mayor
        return pacienteRepository.findByPesoGreaterThan(peso);
    }

    //buscar altura menor
    public List<Paciente> listarPacienteAlturaMenor(double altura){
        //retornar paciente por altura menor
        return pacienteRepository.findByAlturaLessThan(altura);
    }



    
}
