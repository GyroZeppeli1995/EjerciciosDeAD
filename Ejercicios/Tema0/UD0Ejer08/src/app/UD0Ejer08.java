/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package app;

import clases.ListaDeDatos;
import java.util.Scanner;

/**
 *
 * @author Salva
 */


public class UD0Ejer08 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ListaDeDatos lista = new ListaDeDatos();
        Scanner entrada = new Scanner(System.in);
        String texto = "";
        
        System.out.println("Introduce una palabra (fin para terminar");
        texto = entrada.nextLine();
        lista.incluir(texto);
        
        System.out.println("Introduce palabra a buscar (fin para terminar)");
        do {
            
            texto = entrada.nextLine();
            if(!texto.toLowerCase().equals("fin")){
                System.out.println(texto + (lista.contiene(texto) ? " Aparece": " No existe"));
                System.out.println("Introduce otra palabra a buscar (fin para terminar)");
            }
        } while (!texto.toLowerCase().equals("fin"));
        
        lista.mostrarDatosOrdenados();
        
        
        
        
    }
    
}
