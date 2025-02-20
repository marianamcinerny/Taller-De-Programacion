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
import PaqueteLectura.GeneradorAleatorio;
public class Proyecto {
    private String nombre;
    private int codigo;
    private String director;
    private Investigador []investigadores;
    private int dimL,dimF;
    
    public Proyecto(String nombre, int codigo, String director) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.director = director;
        dimL = 0;
        dimF = 50;
        investigadores = new Investigador[dimF];
    }
    
    public String getNombreP() {
        return this.nombre;
    }
    
    public void setNombreP(String nombre) {
        this.nombre = nombre;
    }
    
    public int getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
   
    public String getDirector(String director) {
        return this.director;
    }
    
    public void setDirector(String director) {
        this.director = director;
    }
    
    public int getCantidadInvestigadores() {
        return this.dimL;
    }
    
    public void agregarInvestigador(Investigador investigador) {
        if (dimL < dimF) {
            investigadores[dimL] = investigador;
            dimL++;
            System.out.println("Investigador agregado correctamente");
        }
        else
            System.out.println("No hay mas cupos para nvestigadores");
    }
    
    public double dineroTotalOtorgado() {
        double aux = 0;
        for (int i=0; i<dimL; i++)
            aux += investigadores[i].dineroTotal();
        return aux;
    }
    
    public void otorgarTodos(String nombre) {
        GeneradorAleatorio.iniciar();
        int aux = 0;
        int i=0;
        while (i<dimL && !investigadores[i].getNombreI().equals(nombre))
            i++;
        if (i<dimL && investigadores[i].getNombreI().equals(nombre)) {
            aux = 5 - investigadores[i].getCantSubsidiosPedidos();
            for (int x=0; x<aux; x++) {
                double monto = GeneradorAleatorio.generarDouble(999);
                Subsidio s = new Subsidio(monto,"porque si");
                investigadores[i].agregarSubsidio(s);
            }
            System.out.println("Se le otorgaron " + aux + " subsidios a " + nombre);
        }
        else
            System.out.println("El investigador " + nombre + " no existe");
    }
    
    public String toString() {
        String aux = "Proyecto: " + this.nombre + ", código " + this.codigo + "\n" +
                "Director: " + this.director + "\n" + 
                "Dinero total invertido: " + this.dineroTotalOtorgado() + "\n";
                for (int i=0; i<dimL; i++)
                    aux +=investigadores[i].toString() + "\n";
        return aux;
    }
}


