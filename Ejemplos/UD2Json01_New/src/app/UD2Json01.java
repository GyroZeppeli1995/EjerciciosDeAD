/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package app;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author alumno
 */
public class UD2Json01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String str = """
                     { 
                        "nombre": "Juan",
                        "edad" : 30
                     }
                     """;

        JSONObject json = new JSONObject(str);
        
        System.out.println(json.toString(2));
        System.out.println(json.get("nombre"));
        
    }

}
