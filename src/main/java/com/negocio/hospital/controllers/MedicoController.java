package com.negocio.hospital.controllers;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//importar modelo y servicios
import com.negocio.hospital.models.Medico;
import com.negocio.hospital.services.MedicoService;


/* 
Requisitos:
CRUD

*/
@RestController
@RequestMapping("/api")
public class MedicoController {
    @Autowired
    private MedicoService medicoService;

    // select * from medico (todos los medicos) https get
    @GetMapping("/medicos")
    public List<Medico> listarTodosMedicos() {
        // retornar todos los medicos
        return medicoService.listarTodosMedicos();
    }
    // select * from medico where id = ? (medico por id) https get
    @GetMapping("/medicos/{id}")
    public Medico listarMedicoPorId(@PathVariable int id) {
        // retornar medico por id
        return medicoService.listarMedicoPorId(id);
    }
    //select filtros
    @RequestMapping("/medicos/nombre/{nombre}")
    public List<Medico> listarMedicoPorNombre(@PathVariable String nombre) {
        // retornar medico por nombre
        return medicoService.listarMedicoPorNombre(nombre);
    }
    @RequestMapping("/medicos/apellido/{apellido}")
    public List<Medico> listarMedicoPorApellido(@PathVariable String apellido) {
        // retornar medico por apellido
        return medicoService.listarMedicoPorApellido(apellido);
    }
    @RequestMapping("/medicos/especialidad/{especialidad}")
    public List<Medico> listarMedicoPorEspecialidad(@PathVariable String especialidad) {
        // retornar medico por especialidad
        return medicoService.listarMedicoPorEspecialidad(especialidad);
    }
    @RequestMapping("/medicos/sueldo/{sueldo}")
    public List<Medico> listarMedicoPorSueldo(@PathVariable double sueldo) {
        // retornar medico por sueldo
        return medicoService.listarMedicoPorSueldo(sueldo);
    }
    @RequestMapping("/medicos/edad/{edad}")
    public List<Medico> listarMedicoPorEdad(@PathVariable int edad) {
        // retornar medico por edad
        return medicoService.listarMedicoPorEdad(edad);
    }
    @RequestMapping("/medicos/aniosexperiencia/{aniosExperiencia}")
    public List<Medico> listarMedicoPorAniosExperiencia(@PathVariable int aniosExperiencia) {
        // retornar medico por aniosExperiencia
        return medicoService.listarMedicoPorAniosExperiencia(aniosExperiencia);
    }
    //select * from medico where nombre = ? or apellido = ? (medico por nombre o apellido) https get
    @RequestMapping("/medicos/nombreoapellido/{nombre}")
    public List<Medico> listarMedicoPorNombreOApellido(@PathVariable String nombre) {
        // retornar medico por nombre o apellido
        return medicoService.listarMedicoPorNombreOApellido(nombre);
    }
    //select * from medico where edad >= ? (medico por edad mayor o igual) https get
    @RequestMapping("/medicos/edadmayor/{edad}")
    public List<Medico> listarMedicoEdadMayor(@PathVariable int edad) {
        // retornar medico por edad mayor o igual
        return medicoService.listarMedicoEdadMayor(edad);
    }
    //select * from medico where sueldo > ? (medico por sueldo mayor) https get
    @RequestMapping("/medicos/sueldomayor/{sueldo}")
    public List<Medico> listarMedicoSueldoMayor(@PathVariable double sueldo) {
        // retornar medico por sueldo mayor
        return medicoService.listarMedicoSueldoMayor(sueldo);
    }
    //select * from medico where sueldo <= ? (medico por sueldo menor o igual) https get
    @RequestMapping("/medicos/sueldomenor/{sueldo}")
    public List<Medico> listarMedicoSueldoMenor(@PathVariable double sueldo) {
        // retornar medico por sueldo menor o igual
        return medicoService.listarMedicoSueldoMenor(sueldo);
    }
    //select * from medico where aniosExperiencia >= ? (medico por aniosExperiencia mayor o igual) https get
    @RequestMapping("/medicos/aniosexperienciamayor/{aniosExperiencia}")
    public List<Medico> listarMedicoAniosExperienciaMayor(@PathVariable int aniosExperiencia) {
        // retornar medico por aniosExperiencia mayor o igual
        return medicoService.listarMedicoAniosExperienciaMayor(aniosExperiencia);
    }
    // insert https post con body
    @PostMapping("/medicos")
    public Medico guardarMedico(@RequestBody Medico medico) {
        // guardar medico
        medicoService.guardarMedico(medico);
        return medico;
    }
    // update by id y body https put
    @PutMapping("/medicos/{id}")
    public Medico actualizarMedico(@RequestBody Medico medico, @PathVariable int id) {
        // actualizar medico
        medicoService.actualizarMedico(medico);
        Medico medicoExistente = medicoService.listarMedicoPorId(id);
        return medicoExistente;
    }
    // delete by id https delete
    @DeleteMapping("/medicos/{id}")
    public Medico eliminarMedico(@PathVariable int id) {
        // eliminar medico
        Medico medicoExistente = medicoService.listarMedicoPorId(id);
        if (medicoExistente==null){
            throw new RuntimeException("El medico no existe"+id);
        }
        medicoService.eliminarMedico(id);
        return medicoExistente;
  
    }


    
}
