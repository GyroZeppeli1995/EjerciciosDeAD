/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package app;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author Salva
 */
public class UD2Ejer505 {

    /**
     * @param args the command line arguments
     */
    public static void dibujaCuadrado(Integer altura, Integer anchura, PrintWriter pw)
    {
        for (int i = 0; i < altura; i++) {
            //Esto es para debugear en consola el diseño que saldra
            System.out.print("*");
            pw.print("*");
            
            for (int j = 0; j < anchura; j++) {
                System.out.print("*");
                pw.print("*");
            }
            System.out.println("");
            pw.println();
            
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner input = new Scanner(System.in);
        File archivo = new File("./datos/rectangulo.txt");
        
        
        try (PrintWriter pw = new PrintWriter(
                new BufferedWriter(
                        new OutputStreamWriter(
                                new FileOutputStream(archivo, false), StandardCharsets.UTF_8)))) 
        {
            int altura, anchura = 0;
            
            System.out.println("Introduzca la altura del cuadrado");
            altura = Integer.parseInt(input.nextLine());
            System.out.println("Introduzca la anchura del cuadrado");
            anchura = Integer.parseInt(input.nextLine());
            System.out.println("Se ha creado el archivo con la siguiente forma");
            dibujaCuadrado(altura, anchura,pw);
            
            
        }
        catch (Exception e)
        {
            System.out.println("Ha habido un error: " + e.getMessage());
        }
    }
}
