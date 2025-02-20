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
public class Estacionamiento {
    private String nombre;
    private String direccion;
    private double apertura;
    private double cierre;
    private int pisos;
    private int plazas;
    private Auto [][]estacionamiento;
    private int cantidad[];
    
    public Estacionamiento(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        apertura = 8.00;
        cierre = 21.00;
        pisos = 5;
        plazas = 10;
        estacionamiento = new Auto[pisos][plazas];
        cantidad = new int [pisos];
        this.inicializar();
    }
    
    public Estacionamiento(String nombre, String direccion, double apertura, double cierre, int pisos, int plazas) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.apertura = apertura;
        this.cierre = cierre;
        this.pisos = pisos;
        this.plazas = plazas;
        estacionamiento = new Auto[pisos][plazas];
        cantidad = new int [pisos];
        this.inicializar();
    }
    
    private void inicializar() {
        for (int i=0; i<pisos; i++) {
            cantidad[i] = 0;
        }
    }
    
    public void ingresarAuto(Auto auto, int piso, int plaza) {
        estacionamiento[piso-1][plaza-1] = auto;
    }
    
    public String encontrarAuto(String patente) {
        int i = 0, j;
        String aux = "";
        boolean encontrado = false;
        while (i < pisos && encontrado == false) {
            j = 0;
            while (j<plazas && encontrado == false) {
                if (estacionamiento[i][j] != null && estacionamiento[i][j].getPatente().equals(patente)) {
                    aux += "El auto esta en el piso " + (i+1) + " en la plaza " + (j+1);
                    encontrado = true;
                }
                j++;
            }
            i++;
        }
        if (encontrado == false)
                aux += "El auto no se encuentra en el estacionamiento";
        return aux;
    }
    
    public int cantEstacionadosPlaza(int plaza) {
        int cant = 0;
        for (int i=0; i<pisos; i++)
            if (estacionamiento[i][plaza-1] != null)
                cant += 1;
        return cant;
    }
    
    public String toString() {
        for (int i=0; i<pisos; i++){
            System.out.println("Piso " + (i+1) + ": ");
            for (int j=0; j<plazas; j++) {
                if (estacionamiento[i][j] == null)
                    System.out.print("Plaza " + (j+1) + ": libre | ");
                else
                    System.out.print("Plaza " + (j+1) + ": " + estacionamiento[i][j].toString() + " | ");
            }
            System.out.println();
        }
        return null;
    }
}
