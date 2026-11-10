/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package packUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 *
 * @author Salvador Pareja Asín
 */
public class Utilidad {
    
    public static String CambiarFecha(String fechaOriginal)
    {

        // 1. Formateador para leer la entrada (en inglés por los días/meses)
        DateTimeFormatter entrada = DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);

        // 2. Parsear a objeto de fecha
        LocalDate fecha = LocalDate.parse(fechaOriginal, entrada);

        // 3. Formatear al formato deseado (dd/MM/yyyy)
        String fechaFormateada = fecha.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        
        return fechaFormateada;
        
    }
    
}
