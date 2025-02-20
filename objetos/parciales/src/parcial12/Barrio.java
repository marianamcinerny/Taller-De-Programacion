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
public class Barrio {
    private String nombre;
    private int cantManzanas;
    private int cantLotesxManzana;
    private Lote [][]plano;
    
    public Barrio(String nombre, int cantManzanas, int cantLotesxManzana) {
        this.nombre = nombre;
        this.cantManzanas = cantManzanas;
        this.cantLotesxManzana = cantLotesxManzana;
        plano = new Lote[cantManzanas][cantLotesxManzana];
        this.inicializar();
    }
    
    private void inicializar() {
        for (int i=0; i<cantManzanas; i++)
            for (int j=0; j<cantLotesxManzana; j++)
                plano[i][j] = new Lote();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantManzanas() {
        return cantManzanas;
    }

    public void setCantManzanas(int cantManzanas) {
        this.cantManzanas = cantManzanas;
    }

    public int getCantLotesxManzana() {
        return cantLotesxManzana;
    }

    public void setCantLotesxManzana(int cantLotesxManzana) {
        this.cantLotesxManzana = cantLotesxManzana;
    }
    
    public void agregarComprador(Comprador comprador, int lote, int manzana) {
        plano[manzana-1][lote-1].setComprador(comprador);
    }
    
    public void aumentarPrecio(int manzana, double porcentaje) {
        for (int i=0; i<cantLotesxManzana; i++)
            if (plano[manzana-1][i].getComprador() == null)
                plano[manzana-1][i].aumentar(porcentaje);
    }
    
    public double totalRecaudado() {
        double total = 0;
        for (int i=0; i<cantManzanas; i++)
            for (int j=0; j<cantLotesxManzana; j++)
                if (plano[i][j].getComprador() != null)
                    total += plano[i][j].getPrecio();
        return total;
    }
    
    public String toString() {
        String aux = "Barrio: " + nombre + "\n";
        aux += "Recaudacion total: " + this.totalRecaudado() + "\n";
        for (int i=0; i<cantManzanas; i++) {
            aux += "Manzana #" + (i+1) + " |" + "\n";
            for (int j=0; j<cantLotesxManzana; j++) {
                aux += "-Lote #" + (j+1) + " - precio: " + plano[i][j].getPrecio();
                if (plano[i][j].getComprador() == null)
                    aux += " - Disponible para la venta." + "\n";
                else
                    aux += " - Comprador: " + plano[i][j].getComprador().toString() + "\n";
            }
        }
        return aux;
    }
}
