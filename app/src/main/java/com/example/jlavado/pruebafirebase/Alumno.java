package com.example.jlavado.pruebafirebase;

public class Alumno {

    private String dni;
    private String nombres;
    private int edad;
    private String estado;


    public Alumno(String dni, String nombres, int edad, String estado) {
        this.dni = dni;
        this.nombres = nombres;
        this.edad = edad;
        this.estado = estado;
    }

    public Alumno() {
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
