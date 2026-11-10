
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author alumno
 */

/**
 * La idea de esta libreria utilidad es la de generar metodos estaticos que me automaticen tareas repetitivas
 * durante la realizacion de mis ejercicios de AD o PSP
 */
public class Utilidades {
    
    
    
    //Metodo para crear carpetas el las rutas asignadas
    public static void crearCarpeta(String ruta)
    {
        if(ruta == null)
        {
            ruta = "./datos";
        }
        
        try {
            File fichero = new File(ruta);
            
            if(fichero.exists() == false || fichero.canWrite())
            {
                fichero.mkdir();
                
            }
            
            
        } catch (Exception e) {
            System.out.println("Ha habido un error: " + e.getMessage());
        }
        
    }
    //Sobrecarga el metodo para varias carpetas
    public static void crearCarpeta(String[] ruta)
    {
        try {
            
            for (int i = 0; i < ruta.length; i++) {
                File fichero = new File(ruta[i]);
                if(fichero.exists() == false && fichero.canWrite())
                {
                    fichero.mkdir();
                }
                
            }
            
            
        } catch (Exception e) {
            System.out.println("Ha habido un error: " + e.getMessage());
        }
        
    }
}
