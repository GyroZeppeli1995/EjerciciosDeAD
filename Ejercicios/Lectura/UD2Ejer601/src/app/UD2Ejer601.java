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

/**
 *
 * @author alumno
 */
public class UD2Ejer601 {

    public static void generaFichero() 
    {
        File archivo = new File("./datos/anotaciones.txt");
// Apertura del fichero y creación de PrintWriter
        try (PrintWriter pw = new PrintWriter(
                new BufferedWriter(
                        new OutputStreamWriter(
                                new FileOutputStream(archivo, true), StandardCharsets.UTF_8)))) {
// Escritura en el fichero
            pw.println("Este es un fichero de texto");
            pw.print("que contiene varias líneas\n");
            pw.print("y se crea con BufferedWriter.\n");
            pw.println();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        generaFichero();
        
        

    }

}
