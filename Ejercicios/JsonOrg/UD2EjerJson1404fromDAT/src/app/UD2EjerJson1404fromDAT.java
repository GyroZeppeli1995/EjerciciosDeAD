/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package app;

import clases.Alumno;
import clases.Utilidad;
import java.io.IOException;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author alumno
 */
public class UD2EjerJson1404fromDAT {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        String ruta = "./datos/";
        List<Alumno> alumnos = Utilidad.leerFicheroAlumnos(ruta+"alumnos.dat");
        System.out.println("");
        System.out.println("");
        Utilidad.mostrarLista(alumnos);
        System.out.println("");
        Utilidad.crearJSON(alumnos, ruta+"alumnos.json");
        
        
        
        
        
        
        
        
        
        
    }
    
}
