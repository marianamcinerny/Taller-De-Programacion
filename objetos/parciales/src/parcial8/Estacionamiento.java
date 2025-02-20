/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial8;

/**
 *
 * @author PJN
 */
public class Estacionamiento {
    private String direccion;
    private double costoxHora;
    private Auto [][]estructura;
    private int cantPisos;
    private int cantAutosxPiso;
    private int dimLxPiso[];
    
    public Estacionamiento(String direccion, double costoxHora, int cantPisos, int cantAutosxPiso) {
        this.direccion = direccion;
        this.costoxHora = costoxHora;
        this.cantPisos = cantPisos;
        this.cantAutosxPiso = cantAutosxPiso;
        estructura = new Auto[cantPisos][cantAutosxPiso];
        dimLxPiso = new int[cantPisos];
        this.inicializar();
    }
    
    private void inicializar() {
        for (int i=0; i<cantPisos; i++)
            dimLxPiso[i] = 0;
    }
    
    public String getDireccion() {
        return direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public double getCostoxHora() {
        return costoxHora;
    }
    
    public void setCostoxHora(double costoxHora) {
        this.costoxHora = costoxHora;
    }
    
    public int getCantPisos() {
        return cantPisos;
    }
    
    public void setCantPisos(int cantPisos) {
        this.cantPisos = cantPisos;
    }
    
    public int getCapacidadMaxAutosxPiso() {
        return this.cantAutosxPiso;
    }
    
    public void setCapacidadMaxAutosxPiso(int cantAutosxPiso) {
        this.cantAutosxPiso = cantAutosxPiso;
    }
    
    public void agregarAuto(int piso, int sector, Auto auto) {
        if (dimLxPiso[piso-1] < cantAutosxPiso) {
            estructura[piso-1][sector-1] = auto;
            dimLxPiso[piso-1]++;
        }
    }
    
    public String liberarLugares(String marca, int sector) {
        String aux = "";
        for (int i=0; i<cantPisos;i++)
            for (int j=0; j<cantAutosxPiso; j++)
                if (i == (sector-1) && estructura[i][j] != null && estructura[i][j].getMarca().equals(marca)) {
                    aux += estructura[i][j].toString() + "\n";
                    dimLxPiso[i]--;
                    estructura[i][j] = null;
                }
        return aux;
    }
    
    public int sectorMasRecaudo() {
        double total = 0;
        double maxRecaudado = -1; int sectorMax = -1;
        for (int i=0; i<cantPisos; i++) {
            for (int j=0; j<cantAutosxPiso; j++)
                if (estructura[i][j] != null) {
                    total += estructura[i][j].getHorasEstacionado() * costoxHora;
                }
            if (total > maxRecaudado) {
                maxRecaudado = total;
                sectorMax = i;
            }
            total = 0;
        }
        return sectorMax;
    }
    
    public String toString() {
        String aux = "Estacionamiento: " + direccion + ", costo por hora: " + costoxHora + "\n";
        for (int i=0; i<cantPisos; i++) {
            aux += "Sector " + (i + 1) + ": " + "\n";
            for (int j=0; j<cantAutosxPiso; j++) {
                aux += "Lugar " + (j+1) + ": ";
                if (estructura[i][j] == null)
                    aux += "libre" + "\n";
                else
                    aux += estructura[i][j].toString() + "\n";
            }
        }
        return aux;
    }
}
