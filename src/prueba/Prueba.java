/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

/**
 *
 * @author PJN
 */
import PaqueteLectura.Lector;
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int [][]matriz = new int [2][4];
        
        //le pongo valor
        for (int i=0; i<2; i++)
            for (int j=0; j<4; j++) {
                System.out.print("Ingrese un numero: ");
                matriz[i][j] = Lector.leerInt();
            }
        
        //la imprimo
        for (int i=0; i<2; i++) {
            System.out.println("-----------");
            for (int j=0; j<4; j++) {
                System.out.print(matriz[i][j] + " | ");
            }
            System.out.println();
        }
        
        for (int i=0; i<2; i++){
            int aux = 0;
            for (int j=0; j<4; j++)
                aux += matriz[i][j];
            System.out.println("Suma de la fila" + i + ": " + aux);
        }
        
        for (int j=0; j<4; j++) {
            int aux = 0;
            for (int i=0; i<2; i++)
                aux += matriz[i][j];
            System.out.println("Suma de la columna " + j + ": " + aux);
        }
    }
    
}
