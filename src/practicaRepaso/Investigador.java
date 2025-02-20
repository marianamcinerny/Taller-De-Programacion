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
public class Investigador {
    private String nombre;
    private int categoria;
    private String especialidad;
    private Subsidio []subsidios;
    private int dimL;
    private int dimF;
    //private int cantSubsidios;
    
    public Investigador(String nombre, int categoria, String especialidad) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.especialidad = especialidad;
        dimL = 0;
        dimF = 5;
        subsidios = new Subsidio[dimF];
    }
    
    public String getNombreI() {
        return this.nombre;
    }
    
    public void setNombreI(String nombre) {
        this.nombre = nombre;
    }
    
    public int getCategoriaI() {
        return this.categoria;
    }
    
    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }
    
    public String getEspecialidad() {
        return this.especialidad;
    }
    
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
    public int getCantSubsidiosPedidos() {
        return this.dimL;
    }
    
    public void agregarSubsidio(Subsidio subsidio) {
        if (dimL<dimF) {
            subsidios[dimL] = subsidio;
            subsidios[dimL].setEstado(true);
            dimL++;
            System.out.println("Subsidio agregado correctamente");
        }
        else
            System.out.print("Alcanzo el maximo de subsidios pedidos");
    }
    
    public double dineroTotal() {
        double aux = 0;
        for (int i=0; i<dimL; i++)
            aux += subsidios[i].getMonto();
        return aux;
    }
    
    public String toString() {
        String aux = "Investigador: " + this.nombre + ", categoria: " + this.categoria +
                ", especialidad: " + this.especialidad + ", dinero total otorgado en subsidios: " + this.dineroTotal();
        return aux;
    }
}
