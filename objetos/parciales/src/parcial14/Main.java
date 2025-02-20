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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Fecha hoy = new Fecha(6,5,2024);
        Compra compra = new Compra(01,hoy,10);
        
        Consumidor consumidor = new Consumidor(53453453,"maria fernandez");
        PorMayor porMayor = new PorMayor(02,hoy,10,consumidor);
        
        //int codigo, String descripcion, double precioUnitario, int cantUnidades
        Producto p1 = new Producto(4234,"remera blanca",50.7,3);
        Producto p2 = new Producto(45432,"remera negra",233.5,8);
        Producto p3 = new Producto(23322,"buzo gris",322.43,1);
        
        compra.agregarProducto(p1);
        compra.agregarProducto(p2);
        compra.agregarProducto(p3);
        
        porMayor.agregarProducto(p1);
        porMayor.agregarProducto(p2);
        porMayor.agregarProducto(p3);
        
        System.out.print("\n");
        System.out.println("Resumen de compra al por mayor: ");
        System.out.println(porMayor.toString());
        
        System.out.print("\n");
        System.out.println("Resumen de compra: ");
        System.out.println(compra.toString());
        
        System.out.print("\n");
        if (compra.abonableEnCuotas(compra) == true)
            System.out.println("La compra puede ser abonada en cuotas");
        else
            System.out.println("La compra no puede ser abonada en cuotas");
        
        System.out.print("\n");
        if (porMayor.abonableEnCuotas(compra) == true)
            System.out.println("La compra al por mayor puede ser abonada en cuotas");
        else
            System.out.println("La compra al por mayor no puede ser abonada en cuotas");
        
    }
    
}
