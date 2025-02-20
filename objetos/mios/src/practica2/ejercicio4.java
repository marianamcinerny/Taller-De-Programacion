/*
4- Sobre un nuevo programa, modifique el ejercicio anterior para considerar que:
a) Durante el proceso de inscripción se pida a cada persona sus datos (nombre, DNI, edad)
y el día en que se quiere presentar al casting. La persona debe ser inscripta en ese día, en el
siguiente turno disponible. En caso de no existir un turno en ese día, informe la situación.
La inscripción finaliza al llegar una persona con nombre “ZZZ” o al cubrirse los 40 cupos
de casting.
Una vez finalizada la inscripción:
b) Informar para cada día: la cantidad de inscriptos al casting ese día y el nombre de la
persona a entrevistar en cada turno asignado.

 */
package practica2;

/**
 *
 * @author PJN
 */
import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;

public class ejercicio4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        GeneradorAleatorio.iniciar();
        Persona [][]casting = new Persona[5][8];
        int []contador = new int [5];
        
        for (int i = 0; i < 5; i++)
            contador[i] = 0;
        
        String nombre; int edad, DNI, dia = 0, cupos = 0;
        
        System.out.print("Nombre: ");
        nombre =Lector.leerString();
        while ((!nombre.equals("ZZZ")) && (cupos < 40)) {
            edad = GeneradorAleatorio.generarInt(100);
            DNI = GeneradorAleatorio.generarInt(100);
            System.out.print("Dia: ");
            dia = Lector.leerInt();
            if (contador[dia-1] < 8) {
                contador[dia-1] = contador[dia-1] + 1;
                casting[dia-1][contador[dia-1]-1] = new Persona(nombre,DNI,edad);
                cupos = cupos + 1;
            }
            else
                System.out.println("No hay mas turnos para ese dia");
            if (cupos < 40) {
                System.out.print("Nombre: ");
                nombre = Lector.leerString();
            }
        }
        
        for (int i = 0; i < 5; i ++) {
            System.out.println("Dia " + (i + 1) + ": ");
            System.out.println("Cantidad de personas: " + contador[i]);
            for (int j = 0; j < 8; j++) {
                if (casting[i][j] == null)
                    System.out.print("Turno " + (j + 1) +": turno vacio | ");
                else
                    System.out.print("Turno " + (j+1)  + ": " +casting[i][j].getNombre() + " | ");
            }
            System.out.println();
            
        }
    }
    
}
