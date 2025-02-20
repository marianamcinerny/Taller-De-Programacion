/*
 4- Un edificio de oficinas está conformado por 8 pisos (1..8) y 4 oficinas por piso
(1..4). Realice un programa que permita informar la cantidad de personas que
concurrieron a cada oficina de cada piso. Para esto, simule la llegada de personas al
edificio de la siguiente manera: a cada persona se le pide el nro. de piso y nro. de
oficina a la cual quiere concurrir. La llegada de personas finaliza al indicar un nro.
de piso 9. Al finalizar la llegada de personas, informe lo pedido.
 */
package practica1;

/**
 *
 * @author PJN
 */
import PaqueteLectura.Lector;
public class ejercicio4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int [][]edificio = new int[8][4];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 5; j++) {
                edificio[i][j] = 0;
            }
        }
        
        int piso, oficina;
        System.out.print("Ingrese un numero de piso: ");
        piso = Lector.leerInt();
        System.out.print("Ingrese un numero de oficina: ");
        oficina = Lector.leerInt();
        while (piso != 9) {
            edificio[piso-1][oficina-1] = edificio[piso-1][oficina-1] + 1;
            System.out.print("Ingrese un numero de piso: ");
            piso = Lector.leerInt();
            System.out.print("Ingrese un numero de oficina: ");
            oficina = Lector.leerInt();
        }
        
        for (int i = 0; i < 9; i++) {
            System.out.println("Piso " + (i+1) + ": ");
            for (int j = 0; j < 5; j++) {
                System.out.print("Oficina " + (j+1) + ": " + edificio [i][j] + " | ");
            }
            System.out.println();
        }
        
    }
    
}
