/*
3- Se realizará un casting para un programa de TV. El casting durará a lo sumo 5 días y en
cada día se entrevistarán a 8 personas en distinto turno.
a) Simular el proceso de inscripción de personas al casting. A cada persona se le pide
nombre, DNI y edad y se la debe asignar en un día y turno de la siguiente manera: las
personas primero completan el primer día en turnos sucesivos, luego el segundo día y así
siguiendo. La inscripción finaliza al llegar una persona con nombre “ZZZ” o al cubrirse los
40 cupos de casting.
Una vez finalizada la inscripción:
b) Informar para cada día y turno asignado, el nombre de la persona a entrevistar.
NOTA: utilizar la clase Persona. Pensar en la estructura de datos a utilizar. Para comparar
Strings use el método equals.
 */
package practica2;

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
        GeneradorAleatorio.iniciar();
        Persona [][]casting = new Persona [5][8];
        
        for (int i = 0; i < 5; i ++)
            for (int j = 0; j < 8; j++)
                casting [i][j] = null;
        
        String nombre; int cupos = 0, DNI, edad;
        /*System.out.print("Nombre: ");*/
        nombre = GeneradorAleatorio.generarString(6);/*Lector.leerString();*/
        int dia = 0, turno = 0;
        while ((!nombre.equals("ZZZ")) && (cupos < 40) && (dia < 5)) {
            while ((turno < 8) && (!nombre.equals("ZZZ")) &&( cupos < 40)) {
                DNI = GeneradorAleatorio.generarInt(1000);
                edad = GeneradorAleatorio.generarInt(100);
                casting[dia][turno] = new Persona(nombre,DNI,edad);
                turno = turno + 1;
                cupos = cupos + 1;
                /*System.out.print("Nombre: ");*/
                nombre = GeneradorAleatorio.generarString(6);/*Lector.leerString();*/
            }
            dia = dia + 1;
            turno = 0;
        }
        
        for (int i = 0; i < 5; i ++) {
            System.out.println("Dia " + (i+1) + ":");
            for (int j = 0; j < 8; j++) {
                if (casting [i][j] == null)
                    System.out.print("Turno vacio | ");
                else
                    System.out.print("Turno " + (j+1) + ": " + casting[i][j].getNombre() + " | ");
            }
            System.out.println();
        }
            
    }
    
}
