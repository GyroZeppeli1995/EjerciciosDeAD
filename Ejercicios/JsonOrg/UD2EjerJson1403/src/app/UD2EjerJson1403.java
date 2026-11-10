/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package app;

import clases.Utilidad;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author alumno
 */
public class UD2EjerJson1403 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        String URL = "http://ip-api.com/json/213.0.87.123";
        
        JSONObject jObj = Utilidad.getObjectFromUrl(URL);
        
        System.out.println("Recorrer el Array de Objetos");
        Utilidad.mostrarJSON(jObj);
        
        
        
        
        
        
        
        
        
    }
    
}
