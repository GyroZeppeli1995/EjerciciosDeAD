/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author alumno
 */
public class Matematicas {
    
    private int numero;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Matematicas(int numero) {
        this.numero = numero;
    }

    public Matematicas() {
    }
    
    public int mitad(){
        
        int resultado = numero/2;
        return resultado;
        
    }
    
}
