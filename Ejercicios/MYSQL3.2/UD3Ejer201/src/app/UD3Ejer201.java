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
public class UD3Ejer201 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException {
        // TODO code application logic here
        
        // Conexión a la BD
        String url;
        url = "jdbc:mysql://localhost:3306/bdtareas"; //Nombre de la base de datos
        url +="?autoReconnect=true&useSSL=false&zeroDateTimeBehavior=convertToNull";
        url +="&serverTimezone=UTC";
        
        //Datos del usuario que accedera
        String usuario = "root";
        String password = "1234";
        
        //La sentencia que queremos ejecutar
        String setenciaSQL = "SELECT codigo, descripcion, fecha_prevista, terminada"
                + " from tareas;";
        
        //Cargar el driver
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            try (   java.sql.Connection con = DriverManager.getConnection(url, usuario, password); 
                    Statement statement = con.createStatement(); 
                    ResultSet rs = statement.executeQuery(setenciaSQL);)
            {
                //Formateador de fechas
                DateTimeFormatter formatoSalida = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                
                
                // Mostrar los resultados
                System.out.println("+--------+------------------------------------------+----------------+-----------+");
                System.out.println("| Código | Descripción                              | Fecha prevista | Terminada |");
                System.out.println("+--------+------------------------------------------+----------------+-----------+");
                while (rs.next()) {
                    
                    System.out.printf("| %6d ", rs.getInt("codigo"));
                    System.out.printf("| %-40s ", rs.getString("descripcion"));
                    String[] fecha = rs.getString("fecha_prevista").split("-");
                    System.out.printf("| %-14s ",fecha[0]+"/"+fecha[1]+"/"+fecha[2] );
                    System.out.printf("| %-9s |", ( rs.getInt("terminada") > 0 ) ? "SI" : "NO" );
                    System.out.println("");
                    
                }
                System.out.println("+--------+------------------------------------------+----------------+-----------+");
                
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
