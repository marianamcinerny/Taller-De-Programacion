/*
 * 2- Escriba un programa que lea las alturas de los 15 jugadores de un equipo de
básquet y las almacene en un vector. Luego informe:
- la altura promedio
- la cantidad de jugadores con altura por encima del promedio
NOTA: Dispone de un esqueleto para este programa en Ej02Jugadores.java

 */
package practica1;

/**
 *
 * @author PJN
 */
import PaqueteLectura.GeneradorAleatorio;
public class ejercicio2 {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
        GeneradorAleatorio.iniciar();
        double []alturaJugador = new double[16];
        
        for (int i=0; i<16; i++) {
            alturaJugador[i] = GeneradorAleatorio.generarDouble(3);
        }
        
        double prom = 0;
        for (int i=0; i<16; i++) {
            prom = prom + alturaJugador[i];
        }
        
        System.out.println("Promedio de altura: " + prom/15);
        
        int cant = 0;
        for (int i = 0; i < 16; i++) {
            if (alturaJugador[i] > prom) {
                cant = cant + 1;
            }
        }
        System.out.println("Cantidad de jugadores con altur mayor al promedio: " + cant);
    }
    
}
