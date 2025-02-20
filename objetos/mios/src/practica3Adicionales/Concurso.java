/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3Adicionales;

/**
 *
 * @author PJN
 */
public class Concurso {
    private int maxAlumnos;
    private Alumno [][]concurso;
    private int []cantidad;
    
    public Concurso (int maxAlumnos) {
        this.maxAlumnos = maxAlumnos;
        concurso = new Alumno[5][maxAlumnos];
        cantidad = new int[5];
        this.inicializar();
    }
    
    private void inicializar() {
        for (int i=0; i<5; i++) {
            cantidad[i] = 0;
        }
    }
    
    public void inscribirAlumno(Alumno a, int genero) {
	concurso[genero-1][ cantidad[genero-1] ] = a;
	cantidad[genero-1] ++;
	System.out.println("Alumno inscripto correctamente");
    }

    
    public void ponerPuntaje(int genero, String nombre, double puntaje) {
	int j = 0;
        while (j<cantidad[genero-1] && !concurso[genero-1][j].getNombre().equals(nombre) && concurso[genero-1][j] != null)
		j++;
	if (j<cantidad[genero-1] && concurso[genero-1][j].getNombre().equals(nombre) && concurso[genero-1][j] != null) {
            concurso[genero-1][j].setPuntaje(puntaje);
            System.out.println("Puntaje asignado correctamente");
	}
	else
            System.out.println("El alumno no existe");
    }

    
    public Alumno maxPuntaje() {
        double maxP = -1;
        Alumno aux = null;
        for (int i=0; i<5; i++)
            for (int j=0; j<cantidad[i]; j++)
                if (concurso[i][j].getPuntaje() > maxP) {
                    maxP = concurso[i][j].getPuntaje();
                    aux = concurso[i][j];
                }
        return aux;
    }
    //“Genero 1 – Total inscriptos: X – representación del alumno 1 - ... - representación del alumno X
    public String toString() {
        for (int i=0; i<5; i++) {
            System.out.println("Genero " + (i+1) + " - Total inscriptos: " + cantidad[i]);
            for (int j=0; j<cantidad[i]; j++)
                System.out.println("    -" + concurso[i][j].toString());
        }
        System.out.println("Alumno con mayor puntaje: " + this.maxPuntaje().toString());
        return null;
    }
}


