/*
Una escuela de música necesita un sistema para realizar un concurso entre sus alumnos. El
concurso está dividido en cinco géneros musicales y en cada género se pueden inscribir hasta N
alumnos como máximo. De cada alumno registra su nombre, edad, el instrumento que toca y
puntaje obtenido.
1- Genere las clases necesarias. Implemente constructores para iniciar el concurso sin alumnos
inscriptos, recibiendo N (el máximo de alumnos por género musical). Los alumnos deben
instanciarse dando valor a todos sus atributos.
2- Implemente métodos en las clases que corresponda para permitir:
a. Dado un alumno y un género musical válido, inscriba al alumno en dicho género. Asuma que
hay lugar.
b. Dado un género musical válido G, un nombre de alumno N y un puntaje P, asignarle el puntaje
P al alumno N del género G. Considere que el alumno puede no existir.
c. Devolver al alumno que haya obtenido el mayor puntaje en todo el concurso.
d. Devolver un String que contenga la representación del concurso, siguiendo el formato:
“Genero 1 – Total inscriptos: X – representación del alumno 1 - ... - representación del alumno X
...
Genero 5 – Total inscriptos: Y – representación del alumno 1 - ... representación del alumno Y
Alumno de mayor puntaje es: representación del alumno de mayor puntaje”
3- Realice un programa que instancie un concurso con un máximo de 20 alumnos por género.
Instancie 5 alumnos e inscriba a cada uno en algún género musical. Asigne puntajes. Imprima la
representación del concurso.
 */
package practica3Adicionales;

/**
 *
 * @author PJN
 */
public class ejercicio1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Alumno a1 = new Alumno("Maria",15,"guitarra");
        Alumno a2 = new Alumno("Julia",14,"piano");
        Alumno a3 = new Alumno("Pilar",18,"trompeta");
        Alumno a4 = new Alumno("Jose",17,"triangulo");
        Alumno a5 = new Alumno("Pedro",13,"saxofon");
        
        Concurso concurso = new Concurso(20);
        concurso.inscribirAlumno(a1, 1);
        concurso.inscribirAlumno(a2, 2);
        concurso.inscribirAlumno(a3, 2);
        concurso.inscribirAlumno(a4, 4);
        concurso.inscribirAlumno(a5, 5);
        
        concurso.ponerPuntaje(1, "Maria", 9.5);
        concurso.ponerPuntaje(2, "Julia", 8.2);
        concurso.ponerPuntaje(2, "Pilar", 5.3);
        concurso.ponerPuntaje(4, "Jose", 8);
        concurso.ponerPuntaje(5, "Pedro", 7.65);
        concurso.ponerPuntaje(4, "Mariana", 10);
        
        concurso.toString();
    }
    
}
