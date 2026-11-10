/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package app;

import com.sun.jdi.connect.spi.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

/**
 *
 * @author Salvador Pareja Asín
 */
public class UD3Ejer203 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException {
        // TODO code application logic here
        
        // Conexión a la BD
        String url;
        url = "jdbc:mysql://localhost:3306/bdapps"; //Nombre de la base de datos
        url +="?autoReconnect=true&useSSL=false&zeroDateTimeBehavior=convertToNull";
        url +="&serverTimezone=UTC";
        
        //Datos del usuario que accedera
        String usuario = "root";
        String password = "1234";
        
        //Variables globales para el insert
        String[] usuarios = {"Pepe", "Juan", "Miguel"};
        LocalDate fechaActual = LocalDate.now();
        
       
        
        
        
        //Cargar el driver
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            try (   java.sql.Connection con = DriverManager.getConnection(url, usuario, password); 
                    Statement statement = con.createStatement();)
            {
                
                
                int cantidadUpdate = 0;
                int cantidadInsert = 0;
                
                Random random = new Random();
                int numeroRandom = 0;
                
                
                
                //For de UPDATES
                for (int i = 1; i <= 3; i++) {
                    //Creamos un numero random para los kilobites
                    numeroRandom = random.nextInt(1000);
                    //Construimos la cadena al vuelo
                    String sentenciaUPDATE = "UPDATE programas "
                    + "SET ocupacion = " + numeroRandom + " "
                    + "WHERE codigo = " + i + " ;";
                    
                    
                    cantidadUpdate += statement.executeUpdate(sentenciaUPDATE);
                    
                    
                }
                
                //FOR de INSERTS
                for (int i = 1; i <= 4; i++) {
                    numeroRandom = random.nextInt(2);
                    String sentenciaINSERT = "INSERT INTO ejecuciones "
                    + "(id, codprograma, fecha, usuario) "
                    + "VALUES ( " + i + ", " + ((i > 3) ? numeroRandom : i) + ", " + "'" +fechaActual.plusDays(numeroRandom) + "'" + ", " + "'" + usuarios[numeroRandom] + "'"  + ");"; //importante las "'" +
                    
                    cantidadInsert += statement.executeUpdate(sentenciaINSERT);
                }
                
                
                System.out.println("Cantidad de datos actualizados: " + cantidadUpdate);
                
                System.out.println("Cantidad de datos insertados " + cantidadInsert );
                
                
                
                
                
            }
            
        } catch (SQLException e)
        
        {
            System.out.println("Error SQL " + e.getMessage());
        }
            
            
        catch(Exception e)
        {
            System.out.println("ERROR GENENERAL: " + e.getMessage());
        }
        
        
        
    }
    
}
