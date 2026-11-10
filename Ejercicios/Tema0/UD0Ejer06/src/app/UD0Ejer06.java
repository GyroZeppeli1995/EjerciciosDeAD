/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package app;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Salva
 */
public class UD0Ejer06 {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Integer> enteros = new ArrayList<Integer>();
        Scanner entrada = new Scanner(System.in);
        
        //Entiendo que lo suyo hubiera sido crear varios metodos para cada funcion
        int numUsuario = 0;
        while (numUsuario >= 0) {  
            System.out.println("Introduce un numero entero (negativo para terminar");
            numUsuario = entrada.nextInt();
            if(numUsuario >= 0)
            {
                enteros.add(numUsuario);
            }
        }
        
        
        numUsuario = 0;
        System.out.println("Introduce un numero para buscar (negativo para terminar): ");
        numUsuario = entrada.nextInt();
        do {            
            if (numUsuario >= 0)
            {
                System.out.println(numUsuario + " " + (enteros.contains(numUsuario) ? "aparece":"no existe"));
                System.out.println("Introduce otro numero a buscar (negativo para terminar)");
                numUsuario = entrada.nextInt();
            }
        } while (numUsuario >= 0);
        
        Collections.sort(enteros);
        System.out.println("Valores introducidos: ");
        for (int i = 0; i < enteros.size(); i++) {
            System.out.println(enteros.get(i));
            
        }
        
        
        
    }
    
}
