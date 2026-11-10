/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Salva
 */
public class UD0Ejer07 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<String> palabras = new ArrayList<String>();
        Scanner entrada = new Scanner(System.in);
        
        //Entiendo que lo suyo hubiera sido crear varios metodos para cada funcion
        String palabraUsuario = "";
        while (!palabraUsuario.equalsIgnoreCase("fin")) {  
            System.out.println("Introduce una palabra (fin para terminar");
            palabraUsuario = entrada.nextLine();
            if(!palabraUsuario.equalsIgnoreCase("fin"))
            {
                palabras.add(palabraUsuario.toLowerCase());
            }
        }
        
        
        palabraUsuario = "";
        System.out.println("Introduce una palabra para buscar (fin para terminar): ");
        palabraUsuario = entrada.nextLine();
        do {            
            if (!palabraUsuario.equalsIgnoreCase("fin") )
            {
                System.out.println(palabraUsuario + " " + (palabras.contains(palabraUsuario.toLowerCase()) ? "aparece":"no existe"));
                System.out.println("Introduce otra palabra a buscar (fin para terminar)");
                palabraUsuario = entrada.nextLine();
            }
        } while (!palabraUsuario.equalsIgnoreCase("fin"));
        
        Collections.sort(palabras);
        System.out.println("Valores introducidos: ");
        for (int i = 0; i < palabras.size(); i++) {
            System.out.println(palabras.get(i));
            
        }
    }
    
}
