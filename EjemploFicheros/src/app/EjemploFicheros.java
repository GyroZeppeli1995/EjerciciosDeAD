/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package app;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

/**
 *
 * @author alumno
 */
public class EjemploFicheros {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        PrintWriter printWriter
                    = new PrintWriter("./datos/ejemplo1a.txt", StandardCharsets.UTF_8);
        try {
           
            printWriter.println("Hola! mundoooo");
            printWriter.close();
        } catch (Exception error) {
            error.getCause();
        }
        finally{
            if (printWriter != null) {
                printWriter.close();
            }
        }
    }
}
