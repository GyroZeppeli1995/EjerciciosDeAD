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
import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class UD2Ejer502 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        File archivo = new File("./datos/frases2.txt");
        
        try (PrintWriter pw = new PrintWriter(
                new BufferedWriter(
                        new OutputStreamWriter(
                                new FileOutputStream(archivo, false), StandardCharsets.UTF_8)))) 
        {
            String frase = "a";
            while (!frase.isEmpty()) 
            {
                System.out.println("Por favor introduzca una frase a guardar");
                frase = input.nextLine();
                pw.println(frase);
                
                
            }
            
        }
        catch (Exception e)
        {
            System.out.println("Ha habido un error: " + e.getMessage());
        }
    }
}
    

