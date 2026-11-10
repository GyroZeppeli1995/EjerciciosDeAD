/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package app;

import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Salva
 */
public class UD0Ejer03 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduce un mes");
        Integer mes = Integer.parseInt(entrada.nextLine());
        
        //Se que lo suyo hubiera sido escribir un System.out.println en cada case pero vi esta funcion en la documentacion y me gusto
        //no se porque el new Locale aparece como decraped en el IDE
        switch (mes) {
            case 1, 2,3,4,5,6,7,8,9,10,11,12:
                System.out.println("Es el mes de: " + Month.of(mes).getDisplayName(TextStyle.FULL, new Locale("es", "ES")));
                break;
            default:
                System.out.println("Mes no reconocido, ponga uno de 1-12");
                
        }
    }
    
}
