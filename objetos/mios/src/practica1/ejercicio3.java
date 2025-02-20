/*
3- Escriba un programa que defina una matriz de enteros de tamaño 5x5. Inicialice
la matriz con números aleatorios entre 0 y 30.
Luego realice las siguientes operaciones:
- Mostrar el contenido de la matriz en consola.
- Calcular e informar la suma de los elementos de la fila 1
- Generar un vector de 5 posiciones donde cada posición j contiene la suma
de los elementos de la columna j de la matriz. Luego, imprima el vector.
- Lea un valor entero e indique si se encuentra o no en la matriz. En caso de
encontrarse indique su ubicación (fila y columna) en caso contrario
imprima “No se encontró el elemento”.

NOTA: Dispone de un esqueleto para este programa en Ej03Matrices.java
 */
package practica1;

/**
 *
 * @author PJN
 */
import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;

public class ejercicio3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int [][]matriz = new int[5][5];
        for (int i = 0; i<5; i++) {
            for (int j = 0; j<5; j++) {
                matriz[i][j] = GeneradorAleatorio.generarInt(31);
            }
        }
        
        for (int i = 0; i < 5; i++) {
            System.out.println("----------------------------------------------");
            for (int j = 0; j < 5; j++) {
                System.out.print(matriz[i][j] + "|");
            }
        }
        
        int suma = 0;
        for (int j = 0; j < 5; j++)
            suma = suma + matriz[1][j];
        System.out.println("La suma de los elementos de la primera fila: " + suma);
        
        int []vector = new int[5];
        int aux;
        for (int i = 0; i<5; i++) {
            aux = 0;
            for (int j = 0; j < 5; j++) {
                aux = aux + matriz[j][i];
            }
            vector[i] = aux;
        }
        
        for (int i = 0; i < 5; i++) {
            System.out.print(vector[i] + " | ");
        }
        
        int num,posf=0,posc=0; boolean existe = false;
        System.out.print("Ingrese un numero: ");
        num = Lector.leerInt();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (matriz[i][j] == num) {
                    existe = true;
                    posf = i;
                    posc = j;
                }
            }
        }
        
        if (existe == true)
            System.out.println("El elemento se encuentre en " + posf + "," + posc);
        else
            System.out.println("No se encontro el elemento");
    }
    
}
