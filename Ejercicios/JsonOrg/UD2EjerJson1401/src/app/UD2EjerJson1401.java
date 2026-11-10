/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package app;

import clases.Utilidad;
import org.json.JSONArray;

/**
 *
 * @author alumno
 */
public class UD2EjerJson1401 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        String ruta = "./datos/contenedores-frutas-50.json";
        JSONArray jsonArray = Utilidad.getArrayFromFile(ruta);
        
        System.out.println("Contenedores del país FR");
        System.out.println("------------------------");
        Utilidad.mostrarArrayFiltrado(jsonArray, "pais", "FR");
        
        
        
        
        
        
        
    }
    
}
