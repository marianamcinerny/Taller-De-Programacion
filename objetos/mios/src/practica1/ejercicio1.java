/*
 * 1- Analice el programa Ej01Tabla2.java, que carga un vector que representa la
tabla del 2. Luego escriba las instrucciones necesarias para:
- generar enteros aleatorios hasta obtener el número 11. Para cada número
muestre el resultado de multiplicarlo por 2 (accediendo al vector).
 */
package practica1;

/**
 *
 * @author PJN
 */
import PaqueteLectura.GeneradorAleatorio;

public class ejercicio1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        GeneradorAleatorio.iniciar();
        int []tablaDos = new int[11];
        for (int i=0; i<11; i++)
            tablaDos[i] = i*2;
        
        int num;
        num = GeneradorAleatorio.generarInt(12);
        while (num != 11) {
            System.out.println("2x" + num + "= " + tablaDos[num]);
            num = GeneradorAleatorio.generarInt(12);
        }
    }
    
}
