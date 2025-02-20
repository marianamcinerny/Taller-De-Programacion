/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial12;

/**
 *
 * @author PJN
 */
public class Comprador {
    private int dni;
    private String nombre;
    private String apellido;
    private String ciudad;
    
    public Comprador(int dni, String nombre, String apellido, String ciudad) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.ciudad = ciudad;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getApellido() {
        return nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    
    public String toString() {
        String aux = dni + " - " + apellido + " " + nombre + " - " + ciudad + ".";
        return aux;
    }
}
