/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package app;

import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class UD0Ejer05 {

    // FUNCIÓN - esPrimo
    public static boolean esPrimo(int numero) {
        int contador = 2;
        boolean primo = true;
        
        while ((primo) && (contador != numero)) {
            if ((numero % contador) == 0) {
                primo = false;
            }
            contador++;
        }
        return primo;
    }

    // FUNCIÓN - esPalindromo
    public static boolean esPalindromo(int numero) {
        String sPalabra = String.valueOf(numero);
        int inc = 0;
        int des = sPalabra.length() - 1;
        boolean palindromo = true;
        while ((inc < des) && (palindromo)) {
            if (sPalabra.charAt(inc) == sPalabra.charAt(des)) {
                inc++;
                des--;
            } else {
                palindromo = false;
            }
        }
        return palindromo;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner entrada = new Scanner(System.in);
        int numeroUsuario = 0;
        System.out.println("Introduce un numero entero: ");
        numeroUsuario = entrada.nextInt();
        System.out.println("EL numero " + numeroUsuario + " " + (esPrimo(numeroUsuario) ? "es" : "NO") + " primo");
        System.out.println("EL numero " + numeroUsuario + " " + (esPalindromo(numeroUsuario) ? "es" : "NO") + " palindromo");
        if(esPrimo(numeroUsuario) == true && esPalindromo(numeroUsuario) == true)
        {
            System.out.println("El numero " + numeroUsuario + " es primo y palindromo");
        }

    }

}
