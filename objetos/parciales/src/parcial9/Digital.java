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
public class Digital extends Banco {
    private String link;
    
    public Digital(String nombre, int cantEmpleados, int maxCuentas, String link) {
        super(nombre,cantEmpleados,maxCuentas);
        this.link = link;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
    
    public boolean agregarCuenta(Cuenta cuenta) {
        return addCuenta(cuenta);
    }
    
    public boolean puedeRecibirTarjeta(int cbu) {
        boolean puede = false;
        Cuenta cuenta = obtenerCuenta(cbu);
        if (cuenta != null)
            if (cuenta.getMoneda().equals("pesos") && cuenta.getMonto() > 100000)
                puede = true;
        return puede;
    }
}
