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
public class Ocasional extends Recital{
    private String motivo;
    private String contratante;
    private Dia dia;
    
    public Ocasional(String nombre, int cantTemas, String motivo, String contratante, Dia dia) {
        super(nombre,cantTemas);
        this.motivo = motivo;
        this.contratante = contratante;
        this.dia = dia;
    }
    
    public String getMotivo() {
        return this.motivo;
    }
    
    public String getContratante() {
        return this.contratante;
    }
    
    public String getDia() {
        return this.dia.toString();
    }
    
    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
    
    public void setContratante(String contratante) {
        this.contratante = contratante;
    }
    
    public String actuar() {
        String aux = "";
        if (motivo.equals("befeniciencia"))
            aux += "Recuerden colaborar con " + contratante + "\n";
        else if (motivo.equals("show de TV"))
            aux += "Saludos amigos televidentes" + "\n";
        else
            aux += "Un feliz cumpleaños para " + contratante + "\n";
        aux += getListaTemas();
        return aux;
    }
    
    public double calcularCosto() {
        double total = 0;
        if (motivo.equals("show de TV"))
            total = 50000;
        else if (motivo.equals("privado"))
            total = 150000;
        return total;
    }
}
