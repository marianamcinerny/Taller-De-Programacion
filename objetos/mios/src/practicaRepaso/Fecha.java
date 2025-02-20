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
public class Fecha {
    private String ciudad;
    private Dia dia;
    
    public Fecha(String ciudad, Dia dia) {
        this.ciudad = ciudad;
        this.dia = dia;
    }
    
    public String getCiudad() {
        return this.ciudad;
    }
    
    public String getDia() {
        return dia.toString();
    }
    
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
}
