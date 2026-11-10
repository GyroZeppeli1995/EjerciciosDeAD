/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package app;

import java.util.Scanner;

/**
 *
 * @author Salva
 */
public class UD0Ejer01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner entrada = new Scanner(System.in);
        String nombre;
        System.out.println("Dime tu nombre: ");
        nombre = entrada.nextLine();
        
        for (int i = 0; i < 5; i++) {
            System.out.println("Hola, " + nombre);
            
        }
    }
    
}
