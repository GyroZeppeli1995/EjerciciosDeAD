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
public class UD2EjerJson1402 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        String ruta = "./datos/sistoperativos.json";
        JSONArray jsonArray = Utilidad.getArrayFromFile(ruta);
        
        
        
        Utilidad.recorrerArrayForClasico(jsonArray);
        Utilidad.recorrerForElementos(jsonArray);
        Utilidad.recorrerIterator(jsonArray);
        Utilidad.accesoDirectoValor(jsonArray, "Nombre", 2);
        
        
        
        
        
        
        
    }
    
}
