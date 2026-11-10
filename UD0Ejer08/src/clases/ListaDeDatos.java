/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Salva
 */
public class ListaDeDatos {
    ArrayList<String> palabras;

    public ListaDeDatos() {
        palabras = new ArrayList<String>();
    }
    
    
    public void incluir(String texto)
    {
        Scanner entrada = new Scanner(System.in);
        
        while (!texto.equalsIgnoreCase("fin")) {
            
            if(!texto.equalsIgnoreCase("fin")){
                palabras.add(texto);
            }
            
            System.out.println("Introduce una palabra (fin para terminar");
            texto = entrada.nextLine();
            
        }
    }
    
    
    public boolean contiene(String texto)
    {
        boolean existe = palabras.contains(texto);
        return existe;
    }
    
    public void mostrarDatosOrdenados(){
        Collections.sort(palabras);
        System.out.println("Valores introducidos: ");
        for (int i = 0; i < palabras.size(); i++) {
            System.out.println(palabras.get(i));
            
        }
    }
    
}
