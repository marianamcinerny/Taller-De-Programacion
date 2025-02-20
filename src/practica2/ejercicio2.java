/*
2- Utilizando la clase Persona. Realice un programa que almacene en un vector a lo sumo
15 personas. La información (nombre, DNI, edad) se debe generar aleatoriamente hasta
obtener edad 0. Luego de almacenar la información:
 - Informe la cantidad de personas mayores de 65 años.
 - Muestre la representación de la persona con menor DNI.
 */
package practica2;

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
        int dimF = 15, dimL = 0;
        Persona []vector = new Persona[dimF];
        
        String nombre;
        int edad, DNI;
        edad = GeneradorAleatorio.generarInt(100);
        while ((edad != 0) && (dimL < 15)) {
            nombre = GeneradorAleatorio.generarString(10);
            DNI = GeneradorAleatorio.generarInt(99);
            vector[dimL] = new Persona(nombre,DNI,edad);
            dimL = dimL + 1;
            edad = GeneradorAleatorio.generarInt(100);
        }
        
        int cant65 = 0, minDNI = 100; Persona p = null;
        for (int i = 0; i < 15; i++) {
            if (vector[i].getEdad() > 65)
                cant65 = cant65 + 1;
            if (vector[i].getDNI()< minDNI) {
                minDNI = vector[i].getDNI();
                p = vector[i];
            }
        }
        
        System.out.println("Cantidad de personas mayores a 65 años: " + cant65);
        if (p == null)
            System.out.println("Vector vacio");
        else
            System.out.println(p.toString());
    }
    
}
