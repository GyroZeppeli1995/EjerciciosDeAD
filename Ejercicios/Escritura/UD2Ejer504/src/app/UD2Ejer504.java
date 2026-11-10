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
public class UD2Ejer504 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        File archivo = new File("./datos/frases4.txt");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime ahora = LocalDateTime.now();
        
        try (PrintWriter pw = new PrintWriter(
                new BufferedWriter(
                        new OutputStreamWriter(
                                new FileOutputStream(archivo, true), StandardCharsets.UTF_8)))) 
        {
            String frase = "a";
            while (!frase.isEmpty()) 
            {
                System.out.println("Por favor introduzca una frase a guardar");
                frase = input.nextLine();
                //Esto es para evitar que cuando se pulse enter y frase este vacia se cree una ultima linea con la hora
                if(!frase.isEmpty())
                {
                    pw.println(dtf.format(ahora)+ ": " + frase);
                }
                
            }
            
        }
        catch (Exception e)
        {
            System.out.println("Ha habido un error: " + e.getMessage());
        }
    }
}
