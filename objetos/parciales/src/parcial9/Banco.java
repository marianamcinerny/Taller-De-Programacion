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
public abstract class Banco {
    private String nombre;
    private int cantEmpleados;
    private Cuenta []cuentas;
    private int dimL;
    private int dimF;
    
    public Banco (String nombre, int cantEmpleados, int maxCuentas) {
        this.nombre = nombre;
        this.cantEmpleados = cantEmpleados;
        dimF = maxCuentas;
        cuentas = new Cuenta[dimF];
        dimL = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantEmpleados() {
        return cantEmpleados;
    }

    public void setCantEmpleados(int cantEmpleados) {
        this.cantEmpleados = cantEmpleados;
    }
    
    public boolean addCuenta(Cuenta cuenta) {
        boolean pude = false;
        if (dimL < dimF) {
            cuentas[dimL] = cuenta;
            dimL++;
            pude = true;
        }
        return pude;
    }
    
    public abstract boolean agregarCuenta(Cuenta cuenta);
    
    public Cuenta obtenerCuenta(int cbu) {
        boolean found = false;
        int i=0; Cuenta cuenta = null;
        while (i<dimL && found == false) {
            if (cuentas[i].getCbu() == cbu) {
                found = true;
                cuenta = cuentas[i];
            }
            i++;
        }
        return cuenta;
    }
    
    public void depositarDinero(int cbu, double monto) {
        boolean found = false;
        int i=0;
        while (i<dimL && found == false) {
            if (cuentas[i].getCbu() == cbu) {
                found = true;
                cuentas[i].incrementarMonto(monto);
            }
            i++;
        }
    }
    
    public abstract boolean puedeRecibirTarjeta(int cbu);
}
