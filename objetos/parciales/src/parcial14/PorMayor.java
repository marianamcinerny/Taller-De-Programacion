/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial14;

/**
 *
 * @author PJN
 */
public class PorMayor extends Compra{
    private Consumidor consumidorFinal;
    
    
    public PorMayor(int numero, Fecha fecha, int maxProductos, Consumidor consumidorFinal) {
        super(numero,fecha,maxProductos);
        this.consumidorFinal = consumidorFinal;
    }

    public Consumidor getConsumidorFinal() {
        return consumidorFinal;
    }

    public void setConsumidorFinal(Consumidor consumidorFinal) {
        this.consumidorFinal = consumidorFinal;
    }
    
    public void agregarProductos (Producto producto, Consumidor condumidorF) {
        if (producto.getCantUnidades() > 6)
            super.agregarProducto(producto);
        else
            System.out.print("No se puede hacer una compra al por mayor, no supera la minima cantidad.");
    }
    
    public double precioFinal(Compra compra) {
        double total = super.precioFinal(compra);
        total = total - (total * 0.21);
        return total;
    }
}
