/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial9;

/**
 *
 * @author PJN
 */
public class Tradicional extends Banco{
    private String direccion;
    private String localidad;
    private int cantCuentasDolares;
    
    public Tradicional(String nombre, int cantEmpleados, int maxCuentas, String direccion, String localdad) {
        super(nombre,cantEmpleados,maxCuentas);
        this.direccion = direccion;
        this.localidad = localidad;
        cantCuentasDolares = 0;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public int getCantCuentasDolares() {
        return cantCuentasDolares;
    }
    
    public boolean agregarCuenta(Cuenta cuenta) {
        boolean pude = false;
        if (cuenta.getMoneda().equals("dolares") && cantCuentasDolares < 100) {
            cantCuentasDolares++;
            addCuenta(cuenta);
            pude = true;
        }
        else
            pude = addCuenta(cuenta);
        return pude;
    }
    
    public boolean puedeRecibirTarjeta(int cbu) {
        Cuenta cuenta = obtenerCuenta(cbu);
        boolean puede = false;
        if (cuenta != null) {
            if (cuenta.getMoneda().equals("pesos") && cuenta.getMonto() > 70000)
                puede = true;
            else if (cuenta.getMoneda().equals("dolares") && cuenta.getMonto() > 500)
                puede = true;
        }
        return puede;
    }
}
