/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Salvador Pareja Asín
 */
public class Alumno implements Serializable {
    //Atributos
    private int id;
    private String nombre;
    private String localidad;
    private ArrayList<Double> notas;

    public Alumno() {
    }

    public Alumno(int id, String nombre, String localidad, ArrayList<Double> notas) {
        this.id = id;
        this.nombre = nombre;
        this.localidad = localidad;
        this.notas = notas;
    }

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

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public ArrayList<Double> getNotas() {
        return notas;
    }

    public void setNotas(ArrayList<Double> notas) {
        this.notas = notas;
    }

    @Override
    public String toString() {
        return "Alumno{" + "id=" + id + ", nombre=" + nombre + ", localidad=" + localidad + ", notas=" + notas + '}';
    }

    
    
    
    
}
