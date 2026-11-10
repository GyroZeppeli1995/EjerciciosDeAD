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
 * @author alumno
 */
public class UD0Ejer04 {

    /**
     * @param args the command line arguments
     */
    
    //Se que buscabas que escribiera a mano en el array cada mes pero soy vago ;C
    public static void rellenaMes(String[] mes){
        int posicion = 0;
        for (int i = 1; i <= 12; i++) {
            
            mes[posicion] = Month.of(i).getDisplayName(TextStyle.FULL, new Locale("es", "ES"));
            posicion++;
            
        }
        
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        String[] mes = new String[12];
        Scanner entrada = new Scanner(System.in);
        rellenaMes(mes);
        
        System.out.println("Introduce un numero de mes: ");
        int numeroMes = 0;
        numeroMes = entrada.nextInt();
        if(numeroMes == 1){
            numeroMes = 0;
        }
        else{
            numeroMes = numeroMes - 1;
        }
        
        System.out.println("El mes es: " + mes[numeroMes]);
        
        
    }
    
}
