package com.negocio.hospital.controllers;
//cuarto paso crear controlador

//para la lista java.util.List
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
//importar modelo y servicios
import com.negocio.hospital.models.Paciente;
import com.negocio.hospital.services.PacienteService;

/* 
Requisitos:
CRUD

Listar todos los Pacientes 

Guardar Paciente
Actualizar Paciente
Eliminar Paciente

Listar Paciente por ID 

Listar pacientes con peso mayor a 180 libras 
Listar pacientes con altura menor a 1.80 metros 
añadir edaed mayor o igual a 18 años 
*/

@RestController
@RequestMapping("/api")

public class PacienteController {
    @Autowired
    private PacienteService pacienteService;

    // select * from paciente (todos los pacientes) https get
    @GetMapping("/pacientes")
    public List<Paciente> listarTodosPacientes() {
        // retornar todos los pacientes
        return pacienteService.listarTodosPacientes();
    }

    // select * from paciente where id = ? (paciente por id) https get
    @GetMapping("/pacientes/{id}")
    public Paciente listarPacientePorId(@PathVariable int id) {
        // retornar paciente por id
        return pacienteService.listarPacientePorId(id);
    }

    //select peso mayor a http get
    @RequestMapping("/pacientes/pesomayor/{peso}")
    public List<Paciente> listarPacientePesoMayor(@PathVariable double peso) {
        // retornar paciente por peso
        return pacienteService.listarPacientePesoMayor(peso);
    }
    //select altura menor a http get
    @RequestMapping("/pacientes/alturamenor/{altura}")
    public List<Paciente> listarPacienteAlturaMenor(@PathVariable double altura) {
        // retornar paciente por altura
        return pacienteService.listarPacienteAlturaMenor(altura);
    }
    //select edad mayor o igual a http get
    @RequestMapping("/pacientes/edadmayor/{edad}")
    public List<Paciente> listarPacienteEdadMayor(@PathVariable int edad) {
        // retornar paciente por edad
        return pacienteService.listarPacienteEdadMayor(edad);
    }

    // insert https post con body
    @PostMapping("/pacientes")
    public Paciente guardarPaciente(@RequestBody Paciente paciente) {
        // guardar paciente
        pacienteService.guardarPaciente(paciente);
        return paciente;
    }

    // update by id y body https put
    @PutMapping("/pacientes/{id}")
    public Paciente actualizarPaciente(@RequestBody Paciente paciente, @PathVariable int id) {
        // actualizar paciente
        pacienteService.actualizarPaciente(paciente);
        Paciente pacienteExistente = pacienteService.listarPacientePorId(id);
        return pacienteExistente;
    }

    // delete by id https delete
    @DeleteMapping("/pacientes/{id}")
    public Paciente eliminarPaciente(@PathVariable int id) {
        // eliminar paciente
        Paciente pacienteExistente = pacienteService.listarPacientePorId(id);
        if (pacienteExistente==null){
            throw new RuntimeException("El paciente no existe"+id);
        }
        pacienteService.eliminarPaciente(id);
        return pacienteExistente;
  
    }



    


}
