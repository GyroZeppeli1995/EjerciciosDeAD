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
public class UD0Ejer02 {

    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner entrada = new Scanner(System.in);
        Integer numOriginal = null;
        
        System.out.println("Introduce un numero entero: ");
        numOriginal = Integer.parseInt(entrada.nextLine());
        int factorial = 1;
        for (int i = 1; i <= numOriginal; i++) {
            factorial = i * factorial;

        }
        System.out.println("El factorial de: " + numOriginal + " es: " + factorial);
        
        
        
        
        
    }
    
}
