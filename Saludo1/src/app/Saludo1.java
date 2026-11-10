/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package app;

import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class Saludo1 {
    //ALT+MAYUS+F para copiar bien
    //CTR+Mayus+I para hacer todos los imports
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner entrada = new Scanner(System.in);
        System.out.print("Cuántas veces te saludo? ");
        
        int n = entrada.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("Hola mundo.");
        }
        //Escribir sout+tab escribe system out print
        System.out.println("TAB");
    }

}
