/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaRepaso;

/**
 *
 * @author PJN
 */
public class Gira extends Recital {
    private String nombre;
    private Fecha []fechas;
    private int dimF;
    private int dimL;
    private int actual;
    
    public Gira(String nombreR, int cantTemas, String nombre, int dimF) {
        super(nombreR,cantTemas);
        this.nombre = nombre;
        this.dimF = dimF; dimL = 0;
        actual = 0;
        fechas = new Fecha[dimF];
    }
    
    public String getNombreGira(){
        return this.nombre;
    }
    
    public void setNombreGira(String nombre) {
        this.nombre = nombre;
    }
    
    public int getCantidadFechas() {
        return this.dimF;
    }
    
    public void setCantidadFechas(int dimF) {
        this.dimF = dimF;
    }
    
    public void agregarFecha(Fecha f) {
        if (dimL < dimF) {
            fechas[dimL] = f;
            dimL++;
            System.out.println("Fecha agregada correctamente");
        }
        else
            System.out.println("No hay disponibilidad para mas fechas");
    }
    
    public String actuar() {
        String aux = "";
        for (int i=0; i<dimF; i++) {
            aux += "Buenas noches " + fechas[actual].getCiudad();
            aux += getListaTemas() + "\n";
            actual++;
        }
        return aux;
    }
    
    public double calcularCosto() {
        double total = 0;
        for (int i=0; i<dimL; i++)
            total += 30000;
        return total;
    }
}
