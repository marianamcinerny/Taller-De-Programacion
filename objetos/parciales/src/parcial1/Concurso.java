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
public class Concurso {
    private int cantCategorias;
    private int cantCanciones;
    private Cancion [][]concurso;
    private int []dimL;
    
    public Concurso(int cantCategorias, int cantCanciones) {
        this.cantCanciones = cantCanciones;
        this.cantCategorias = cantCategorias;
        concurso = new Cancion[cantCategorias][cantCanciones];
        dimL = new int[cantCategorias];
        this.inicializar();
    }
    
    private void inicializar(){
        for (int i=0; i<cantCategorias; i++)
            dimL[i] = 0;
    }
    
    public int getCantCategorias() {
        return this.cantCategorias;
    }
    
    public int getCantCanciones() {
        return this.cantCanciones;
    }
    
    public void setCantCategorias(int cantCategorias) {
        this.cantCategorias = cantCategorias;
    }
    
    public void setCantCanciones(int cantCanciones) {
        this.cantCanciones = cantCanciones;
    }
    
    public void agregarCancion(Cancion cancion, int categoria) {
        concurso[categoria-1][dimL[categoria-1]] = cancion;
        dimL[categoria-1]++;
    }
    
    public void interpretarCancion(int id, Estudiante estudiante, double puntaje) {
        int i = 0, j;
        boolean encontrada = false;
        while (i<cantCategorias && encontrada == false) {
            j = 0;
            while (j<dimL[i] && encontrada == false) {
                if (concurso[i][j].getID() == id) {
                    encontrada = true;
                    if (concurso[i][j].getPuntaje() < puntaje) {
                        concurso[i][j].setGanador(estudiante);
                        concurso[i][j].setPuntaje(puntaje);
                    }
                }
                j++;
            }
            i++;
        }
    }
    
    public Estudiante conocerGanador(int id) {
        int i =0, j;
        boolean encontrada = false;
        Estudiante ganador = null;
        while (i<cantCategorias && encontrada == false) {
            j=0;
            while(j<dimL[i] && encontrada == false) {
                if (concurso[i][j].getID() == id) {
                    encontrada = true;
                    ganador = concurso[i][j].getGanador();
                }
                j++;
            }
            i++;
        }
        return ganador;
    }
    
    public Cancion cancionMaxPuntaje(int categoria) { ///no anda
        double maxPuntaje = -1;
        Cancion cancionMax = null;
        for (int j=0; j<dimL[categoria]; j++) {
            if (concurso[categoria][j].getPuntaje() > maxPuntaje) {
                maxPuntaje = concurso[categoria][j].getPuntaje();
                cancionMax = concurso[categoria][j];
            }
        }
        return cancionMax;
    }
}
