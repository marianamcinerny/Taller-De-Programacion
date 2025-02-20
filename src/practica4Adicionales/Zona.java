/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4Adicionales;

/**
 *
 * @author PJN
 */
public class Zona {
    private String localidad;
    private String partido;
    private String provincia;
    
    public Zona (String localidad, String partido, String provincia) {
        this.localidad = localidad;
        this.partido = partido;
        this.provincia = provincia;
    }
    
    public String getLocalidad() {
        return this.localidad;
    }
    
    public String getPartido() {
        return this.partido;
    }
    
    public String getProvincia() {
        return this.provincia;
    }
    
    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }
    
    public void setPartido(String partido) {
        this.partido = partido;
    }
    
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
    
    public String toString() {
        String aux = this.getLocalidad() + " - " + this.getPartido() + " - " + this.getProvincia();
        return aux;
    }
}
