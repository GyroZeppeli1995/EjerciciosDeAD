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
public class UD2Ejer507 {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        String mes = "";
        Integer dias = 0;
        Integer diaComienzo = 0;
        String[] diasSemana = {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"};
        
        System.out.println("Introduzca el mes para su agenda");
        mes = input.nextLine();
        System.out.println("Introduzca los dias del mes");
        dias = input.nextInt();
        System.out.println("Introduzca el dia de comienzo de mes");
        diaComienzo = input.nextInt();
        
        
        File archivo = new File("./datos/calendario"+mes+".txt");
        
        
        try (PrintWriter pw = new PrintWriter(
                new BufferedWriter(
                        new OutputStreamWriter(
                                new FileOutputStream(archivo, false), StandardCharsets.UTF_8)))) 
        {
            
            //Los system estan para debugear por consola que el contenido es correcto
            System.out.println("------------");
            System.out.println(mes);
            pw.println("------------");
            pw.println(mes);
            pw.println("------------");
            System.out.println("------------");
            
            for (int i = 0; i < diasSemana.length; i++) {
                System.out.print(diasSemana[i].substring(0,3).toLowerCase() + "\t");
                pw.print(diasSemana[i].substring(0,3).toLowerCase() + "\t");
                
            }
            System.out.println("");
            pw.println("");
            System.out.print("\t".repeat(diaComienzo - 1));
            pw.print("\t".repeat(diaComienzo - 1));
            for (int i = 1; i <= dias; i++) {
                
                
                if(diaComienzo > 7)
                {
                    diaComienzo = 1;
                    System.out.println("");
                    pw.println("");
                }
                System.out.print(i + "\t");
                pw.print(i + "\t");
                diaComienzo++;
                
                
                
            }
            
            
        }
        catch (Exception e)
        {
            System.out.println("Ha habido un error: " + e.getMessage());
        }
    }
    
}
