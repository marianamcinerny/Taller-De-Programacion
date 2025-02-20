/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial4;

/**
 *
 * @author PJN
 */
public class Grado extends Alumno {
    private String carrera;
    
    public Grado (String nombre, int dni, int dimF, String carrera) {
        super(nombre,dni,dimF);
        this.carrera = carrera;
    }
    
    public String getCarrera() {
        return this.carrera;
    }
    
    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
    
    public String toString(){
        String aux = super.toString() + "Carrera: " + carrera;
        return aux;
    }
}
