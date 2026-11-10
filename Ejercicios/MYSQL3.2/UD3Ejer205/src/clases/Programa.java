/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.io.Serializable;

/**
 *
 * @author Salvador Pareja Asín
 */
public class Programa implements Serializable{
    private int codigo;
    private String nombre;
    private String carpeta;
    private int ocupacion;

    public Programa() {
    }

    public Programa(int codigo, String nombre, String carpeta, int ocupacion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.carpeta = carpeta;
        this.ocupacion = ocupacion;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCarpeta() {
        return carpeta;
    }

    public void setCarpeta(String carpeta) {
        this.carpeta = carpeta;
    }

    public int getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(int ocupacion) {
        this.ocupacion = ocupacion;
    }

    @Override
    public String toString() {
        return "Programa{" + "codigo=" + codigo + ", nombre=" + nombre + ", carpeta=" + carpeta + ", ocupacion=" + ocupacion + '}';
    }
    
    public String toJson() {
        return "{" + "\"codigo\":" + codigo + ", \"nombre\":" + "\"" + nombre + "\"" + ", \"carpeta\":" + "\"" + carpeta + "\""  + ", \"ocupacion\":" + ocupacion + '}';
    }
    
    
    
    
}
