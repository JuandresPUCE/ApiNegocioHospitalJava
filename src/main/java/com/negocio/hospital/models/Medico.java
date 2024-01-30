package com.negocio.hospital.models;


import jakarta.persistence.*;

@Entity
public class Medico {
    @Id
    private int id;
    private String nombre;
    private String apellido;
    private String especialidad;
    private double sueldo;
    private int edad;
    private int aniosExperiencia;
    // primero el modelo

    public Medico(int id, String nombre, String apellido, String especialidad, double sueldo, int edad,
            int aniosExperiencia) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.especialidad = especialidad;
        this.sueldo = sueldo;
        this.edad = edad;
        this.aniosExperiencia = aniosExperiencia;
    }
    public Medico() {
        super();
    }
    // generar getters y setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getEspecialidad() {
        return especialidad;
    }
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    public double getSueldo() {
        return sueldo;
    }
    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public int getAniosExperiencia() {
        return aniosExperiencia;
    }
    public void setAniosExperiencia(int aniosExperiencia) {
        this.aniosExperiencia = aniosExperiencia;
    }


    



    
}
