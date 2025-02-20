/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial13;

/**
 *
 * @author PJN
 */
public class Butaca {
    private String descriptor;
    private double precio;
    private boolean estado;
    
    public Butaca(int fila, int num, double precio) {
        descriptor = "Butaca " + fila + ", " + num;
        this.precio = precio;
        estado = false;
    }

    public String getDescriptor() {
        return descriptor;
    }

    public void setDescriptor(String descriptor) { //maybe not
        this.descriptor = descriptor;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    public String toString() {
        String aux = descriptor + ", " + precio + ", ";
        if (estado == true)
            aux += "ocupada.";
        else
            aux += "desocupada.";
        return aux;
    }
    
    
}
