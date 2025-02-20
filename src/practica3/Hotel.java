/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3;

/**
 *
 * @author PJN
 */
import PaqueteLectura.GeneradorAleatorio;
public class Hotel {
    private int cantHabitaciones;
    private Habitacion[]habitacion;
    
    public Hotel(int cantHabitaciones) {
        this.cantHabitaciones = cantHabitaciones;
        habitacion = new Habitacion[this.cantHabitaciones];
        this.inicializar();
    }
    
    private void inicializar() {
        GeneradorAleatorio.iniciar();
        for (int i=0; i<cantHabitaciones; i++){
            habitacion[i] = new Habitacion(); // o hacer que el constructor de hb tenga esos valores?
            habitacion[i].setCosto(GeneradorAleatorio.generarDouble(6001)+2000);
            habitacion[i].setEstado(false);
            habitacion[i].setHuesped(null);
        }
    }
    
    public void ingresarHuesped(Huesped huesped, int numHabitacion) {
        habitacion[numHabitacion-1].setHuesped(huesped);
        habitacion[numHabitacion-1].setEstado(true);
    }
    
    public void aumentar(double monto) {
        for (int i=0; i<cantHabitaciones; i++)
            habitacion[i].aumentarCosto(monto);
    }
    
    public String toString(){
        for (int i=0; i<cantHabitaciones; i++){
            if (habitacion[i].getEstado() == false)
                System.out.println("Habitacion " + (i+1) + ": " + habitacion[i].getCosto() + " desocupada");
            else
                System.out.println("Habitacion " + (i+1) + ": " + habitacion[i].getCosto() + " ocupada " + habitacion[i].getHuespedRep());
        }
        return null;
    }
    
}
