/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package app;

import Utilidades.Utilidad;
import clases.Programa;
import com.sun.jdi.connect.spi.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Salvador Pareja Asín
 */
public class UD3Ejer206 {

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
        
        //Variables globales
        ArrayList<Programa> programas = new ArrayList<Programa>();
        
        //Sentencia SQL
        String setenciaSQL = "SELECT codigo, nombre, carpeta, ocupacion "
                + "FROM programas;";
        
        //Cargar el driver
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            try (   java.sql.Connection con = DriverManager.getConnection(url, usuario, password); 
                    Statement statement = con.createStatement();
                    ResultSet rs = statement.executeQuery(setenciaSQL);)
            {
                //Cargamos en memoria todos los programas de la base de datos
                while (rs.next()) {                    
                    
                    Programa programa = new Programa(rs.getInt("codigo"), rs.getString("nombre"), rs.getString("carpeta"), rs.getInt("ocupacion"));
                    programas.add(programa);
                    
                    
                }
                
                //Pedimos a los usuarios los datos
                boolean todoCorrecto = true; //True todo okay, false = mal
                Scanner input = new Scanner(System.in);
                Programa programa = new Programa();
                
                //Rellenas el objeto programa
                System.out.println("Introduzca el ID: ");
                programa.setCodigo(Utilidad.TryParseInt(input.nextLine()));
                System.out.println("Introduzca el nombre: ");
                programa.setNombre(input.nextLine());
                System.out.println("Introduzca la carpeta: ");
                programa.setCarpeta(input.nextLine());
                System.out.println("Pon el espacio del programa: ");
                programa.setOcupacion(Utilidad.TryParseInt(input.nextLine()));
                
                do {
                    todoCorrecto = true;
                    //verificas el codigo
                    for (int i = 0; i < programas.size(); i++) {
                    
                        if(programas.get(i).getCodigo() == programa.getCodigo())
                        {
                            todoCorrecto = false;
                        }
                    
                    }
                    //Pides de nuevo el codigo si no es correcto
                    if(!todoCorrecto)
                    {
                        System.out.println("El codigo introducido ya esta ocupado o es invalido, pruebe con otro: ");
                        programa.setCodigo(Utilidad.TryParseInt(input.nextLine()));

                    }
                } while (!todoCorrecto);
                
                
                String sentenciaINSERT = "INSERT INTO programas VALUES("
                        + programa.getCodigo() + ", "
                        + "'" + programa.getNombre() + "'" + ", "
                        + "'" + programa.getCarpeta() + "'" + ", "
                        + "'" + programa.getOcupacion() + "'" + ");";
                
                statement.executeUpdate(sentenciaINSERT);
                
                statement.close();
                
                System.out.println("Registro insertado correctamente");
                
                
                
                
                
                
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
