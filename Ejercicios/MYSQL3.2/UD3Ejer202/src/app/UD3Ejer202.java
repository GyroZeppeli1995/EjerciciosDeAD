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

/**
 *
 * @author Salvador Pareja Asín
 */
public class UD3Ejer202 {

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
        
        //La sentencia que queremos ejecutar
        String setenciaSQL = "CREATE TABLE ejecuciones("
                + "id INT AUTO_INCREMENT PRIMARY KEY,"
                + "codprograma INT,"
                + "fecha DATE,"
                + "usuario VARCHAR(60)"
                + "); ";
        
        //Cargar el driver
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            try (   java.sql.Connection con = DriverManager.getConnection(url, usuario, password); 
                    Statement statement = con.createStatement();)
            {
                statement.executeUpdate(setenciaSQL);
                
                //Pongo la instruccion por si acaso, aunque el try ya deberia cerrarlo
                statement.close();
                con.close();
                
                //Informamos que se creo correctamente
                System.out.println("Tabla Creada correctamente");
                
                
                
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
