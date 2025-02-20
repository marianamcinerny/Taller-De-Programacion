/*
1- a) Simular la entrada de autos al estacionamiento municipal en el centro de la ciudad.
El estacionamiento está dividido en 5 pisos y cada piso tiene 10 plazas.
Realice un programa que genere aleatoriamente números (patentes) hasta el 0. Por cada
patente generada, debe leer por teclado el número de piso y número de plaza donde
debe estacionar el auto, debiendo marcar ese lugar como ocupado en una estructura de
datos adecuada.
Nota: Al principio todas las plazas del estacionamiento deben marcarse desocupadas.
Además, durante la lectura, puede considerar que el lugar leído (número de piso,
número de plaza) está desocupado y que dichos números son válidos.
b) Informe cuál es el piso más ocupado.
 */
package practica1Adicionales;

/**
 *
 * @author PJN
 */
import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;
public class ejercicio1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        GeneradorAleatorio.iniciar();
        boolean [][]estacionamiento = new boolean[5][10];
        for (int i = 0; i < 5; i++)
            for (int j = 10; j < 10; j++)
                estacionamiento[i][j] = false;
        
        
        int patente,piso,plaza;
        patente = GeneradorAleatorio.generarInt(10);
        while (patente != 0) {
            System.out.print("Piso: ");
            piso = Lector.leerInt();
            System.out.print("Plaza: ");
            plaza = Lector.leerInt();
            System.out.println();
            estacionamiento[piso][plaza] = true;
            patente = GeneradorAleatorio.generarInt(10);
        }
        
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++)
                System.out.print(estacionamiento[i][j] + " | ");
            System.out.println();
        }
        
        int cant, cantMax = -1, pisoMax = -1;
        for (int i = 0; i < 5; i++) {
            cant = 0;
            for (int j = 0; j < 10; j++)
                if (estacionamiento[i][j] == true)
                    cant = cant + 1;
            if (cant > cantMax) {
                cantMax = cant;
                pisoMax = i;
            }
        }
        
        System.out.println("El piso mas ocupado es el " + pisoMax);
    }
}
