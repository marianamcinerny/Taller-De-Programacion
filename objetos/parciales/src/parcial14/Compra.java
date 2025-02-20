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
public class Compra {
    private int numero;
    private Fecha fecha;
    private Producto []comprados;
    private int dimF;
    private int dimL;
    
    public Compra(int numero, Fecha fecha, int maxProductos) {
        this.numero = numero;
        this.fecha = fecha;
        dimF = maxProductos;
        comprados = new Producto[maxProductos];
        dimL = 0;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }

    public Producto[] getComprados() {
        return comprados;
    }

    public int getCantidadComprados() {
        return dimL;
    }
    
    public void agregarProducto(Producto producto) {
        if (dimL < dimF) {
            comprados[dimL] = producto;
            dimL++;
            System.out.println("Producto agregado a la compra con exito.");
        }
        else
            System.out.println("En la compra no se pueden agregar mas productos");
    }
    
    public double precioFinalProducto(Producto producto) {
        double total = producto.getCantUnidades() * producto.getPrecioUnitario();
        return total;
    }
    
    public double precioFinal(Compra compra) {
        double total = 0;
        for (int i=0; i<dimL; i++)
            total += this.precioFinalProducto(comprados[i]);
        return total;
    }
    
    public boolean abonableEnCuotas(Compra compra) {
        boolean posible = false;
        if (compra.precioFinal(compra) > 100000)
            posible = true;
        return posible;
    }
    
    public String toString() {
        String aux = numero + ", " + fecha.toString() + "\n";
        for (int i=0; i<dimL; i++)
            aux += comprados[i].toString() + ". Precio final del producto: " + this.precioFinalProducto(comprados[i]) + "\n";
        aux += "Precio final de la compra: " + this.precioFinal(this);
        return aux;
    }
    
    
}
