/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial11;

/**
 *
 * @author PJN
 */
public class Torneo {
    private String nombre;
    private int cantFechas;
    private int cantGoleadores;
    private Goleador [][]tabla;
    private int []dimL;
    
    public Torneo(String nombre, int cantFechas, int cantGoleadores) {
        this.nombre = nombre;
        this.cantFechas = cantFechas;
        this.cantGoleadores = cantGoleadores;
        tabla = new Goleador[cantFechas][cantGoleadores];
        dimL = new int[cantFechas];
        this.inicializar();
    }
    
    private void inicializar() {
        for (int i=0; i<cantFechas; i++)
            dimL[i] = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantFechas() {
        return cantFechas;
    }

    public void setCantFechas(int cantFechas) {
        this.cantFechas = cantFechas;
    }

    public int getCantMaxGoleadoresxFecha() {
        return cantGoleadores;
    }

    public void setCantMaxGoleadoresxFecha(int cantGoleadores) {
        this.cantGoleadores = cantGoleadores;
    }

    public Goleador[][] getTablaDeGoleadores() {
        return tabla;
    }
    
    public void agregarGoleador(Goleador goleador, int fecha) {
        if (dimL[fecha-1] < cantGoleadores) {
            tabla[fecha-1][dimL[fecha-1]] = goleador;
            dimL[fecha-1]++;
            System.out.println("Goleador agregado correctamente");
        }
        else
            System.out.println("No se pueden agregar mas goleadores");
    }
    
    public Goleador obtenerGoleadorMenosGoles(int fecha) {
        Goleador goleadorMin = null;
        int minGoles = 100;
        if (dimL[fecha-1] != 0)
            for (int i=0; i<dimL[fecha-1]; i++)
                if (tabla[fecha-1][i].getGoles() < minGoles) {
                    minGoles = tabla[fecha-1][i].getGoles();
                    goleadorMin = tabla[fecha-1][i];
                }
        return goleadorMin;
    }
    
    public int obtenerCantGoleadores() {
        int total = 0;
        for (int i=0; i<cantFechas; i++)
            total += dimL[i];
        return total;
    }
    
    public String toString() {
        String aux = "TORNEO 2022: " + nombre + "\n";
        for (int i=0; i<cantFechas; i++) {
            if (dimL[i] == 0)
                aux += "Fecha #" + (i+1) + " | 0 goleadores" + "\n";
            else {
                aux += "Fecha #" + (i+1) + " | " + dimL[i] + " goleadores | Goleadores: ";
                for (int j=0; j<dimL[i]; j++)
                    aux += tabla[i][j].toString() + " | ";
                aux += "\n";
            }
        }
        return aux;
    }
}
