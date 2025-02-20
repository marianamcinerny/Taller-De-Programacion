/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial1;

/**
 *
 * @author PJN
 */
import PaqueteLectura.Lector;
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Concurso concurso = new Concurso(3,5);
        
        Cancion c1 = new Cancion("guerrero","emilia mernes",1);
        Cancion c2 = new Cancion("ojitos verdes","emilia mernes",2);
        Cancion c3 = new Cancion("iconic","emilia mernes",3);
        Cancion c4 = new Cancion("exclusive","emilia mernes",4);
        Cancion c5 = new Cancion("a 1000 km","emilia mernes",5);
        
        concurso.agregarCancion(c1, 1);
        concurso.agregarCancion(c2, 2);
        concurso.agregarCancion(c3, 3);
        concurso.agregarCancion(c4, 2);
        concurso.agregarCancion(c5, 3);
        
        String nombre, apellido; int dni, id; double puntaje;
        System.out.print("Ingrese el id de la cancion: "); id = Lector.leerInt();
        while (id != 0) {
            System.out.print("Ingrese el nombre del alumno: "); nombre = Lector.leerString();
            System.out.print("Ingrese el apellido del alumno: "); apellido = Lector.leerString();
            System.out.print("Ingrese el DNI del alumno: "); dni = Lector.leerInt();
            Estudiante estudiante = new Estudiante(nombre,apellido,dni);
            System.out.print("Ingrese el puntaje obtenido: "); puntaje = Lector.leerDouble();
            concurso.interpretarCancion(id, estudiante, puntaje);
            System.out.print("\n");
            System.out.print("Ingrese el id de la cancion: "); id = Lector.leerInt();
        }
        
        System.out.print("\n");
        System.out.print("Ingrese el id de una cancion para saber su ganador: "); id = Lector.leerInt();
        Estudiante ganador = concurso.conocerGanador(id);
        if (ganador == null)
            System.out.println("    Nadie");
        else
            System.out.println(ganador.toString());
        
        System.out.print("\n");
        System.out.println("Nombre y compositor de la cancion mejor interpretada de cada categoria: ");
        for (int i=0; i<3; i++)
            System.out.println("    Categoria " + (i+1) + ": " + concurso.cancionMaxPuntaje(i).toString());
    }
    
}
