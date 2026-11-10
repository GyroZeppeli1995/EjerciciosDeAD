/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package app;

import clases.Matematicas;

/**
 *
 * @author alumno
 */
public class EjemploObjeto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Matematicas mat = new Matematicas();
        mat.setNumero(100);
        System.out.println("la mitad de " + mat.getNumero() + " es : " + mat.mitad());
    }
    
}
