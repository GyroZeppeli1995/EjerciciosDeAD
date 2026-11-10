/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package empleados;

import javax.lang.model.element.ElementVisitor;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author alumno
 */
public class Empleados {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String strEmpleados = """
                              [
                              {
                              "nombre": "Alejandro Pérez",
                              "edad": 26,
                              "encargado": false
                              },
                              {
                              "nombre": "Ana López",
                              "edad": 28,
                              "encargado": false
                              },
                              {
                              "nombre": "Silvia Rodríguez",
                              "edad": 34,
                              "encargado": true
                              }
                              ]
                              
                              """;
        
        JSONArray jarray = new JSONArray(strEmpleados);
        
        for (Object elemento : jarray) {
            //hay que hacer un casteo
            JSONObject jobj = (JSONObject) elemento;
            
            System.out.println("Nombre: " + jobj.getString("nombre") + " con edad de: " + jobj.getInt("edad"));
            
        }

    }

}
