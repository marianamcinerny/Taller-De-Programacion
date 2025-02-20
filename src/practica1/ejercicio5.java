/*
 5- El dueño de un restaurante entrevista a cinco clientes y les pide que califiquen
(con puntaje de 1 a 10) los siguientes aspectos: (0) Atención al cliente (1) Calidad
de la comida (2) Precio (3) Ambiente.
Escriba un programa que lea desde teclado las calificaciones de los cinco clientes
para cada uno de los aspectos y almacene la información en una estructura. Luego
imprima la calificación promedio obtenida por cada aspecto.
 */
package practica1;

/**
 *
 * @author PJN
 */
import PaqueteLectura.Lector;
public class ejercicio5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int [][]clientes = new int[5][4];
        for (int i = 0; i < 5; i++) {
            System.out.println("Opinion del cliente " + (i+1) + (": "));
            System.out.print("Atencion al cliente: "); clientes[i][0] = Lector.leerInt();
            System.out.print("Calidad de la comida: "); clientes[i][1] = Lector.leerInt();
            System.out.print("Precio: "); clientes[i][2] = Lector.leerInt();
            System.out.print("Ambiente: "); clientes[i][3] = Lector.leerInt();
            System.out.println();
        }
        
        double promAtencion = 0, promComida = 0, promPrecio = 0, promAmbiente = 0;
        for (int i = 0; i < 5; i++) {
            promAtencion = promAtencion + clientes[i][0];
            promComida = promComida + clientes[i][1];
            promPrecio = promPrecio + clientes[i][2];
            promAmbiente = promAmbiente + clientes[i][3];
        }
        
        promAtencion = promAtencion/5;
        promComida = promComida/5;
        promPrecio = promPrecio/5;
        promAmbiente = promAmbiente/5;
        
        System.out.println("Calificacion promedio en la atencion al cliente: " + promAtencion);
        System.out.println("Calificacion promedio en la comida: " + promComida);
        System.out.println("Calificacion promedio en el precio: " + promPrecio);
        System.out.println("Calificacion promedio en el ambiente: " + promAmbiente);
    }
    
}
