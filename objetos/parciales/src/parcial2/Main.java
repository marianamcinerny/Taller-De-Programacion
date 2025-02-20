/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial2;

/**
 *
 * @author PJN
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Distancia distancia = new Distancia(2024,60,"www.adistancia.com");
        Presencial presencial = new Presencial(2024,20,2);
        
        Alumno a1 = new Alumno(5424543,"maria");
        Alumno a2 = new Alumno(5345345,"juan");
        Alumno a3 = new Alumno(4323422,"jose");
        Alumno a4 = new Alumno(45345345,"ana");
        
        presencial.agregarAlumno(a1);
        presencial.agregarAlumno(a2);
        presencial.agregarAlumno(a3);
        distancia.agregarAlumno(a4);
        distancia.agregarAlumno(a3);
        distancia.agregarAlumno(a2);
        distancia.agregarAlumno(a1);
        
        for (int i=0; i<4; i++)
            presencial.incrementarAsistencia(a1.getDNI());
        for (int i=0; i<3; i++) {
            distancia.incrementarAsistencia(a3.getDNI());
            distancia.aprobarAutoevaluacion(a3.getDNI());
        }
        
        presencial.incrementarAsistencia(a2.getDNI());
        presencial.aprobarAutoevaluacion(a2.getDNI());
        distancia.incrementarAsistencia(a2.getDNI());
        distancia.aprobarAutoevaluacion(a2.getDNI());
        
        System.out.println("Cantidad de alumnos en condiciones para rendir en el curso a distancia: " +
                distancia.cantidadDeAlumnosQuePuedenRendir());
        System.out.println("Cantidad de alumnos en condiciones para rendir en el curso presencial: " + 
                presencial.cantidadDeAlumnosQuePuedenRendir());
    }
    
}
