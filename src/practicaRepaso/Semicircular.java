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
public class Semicircular extends Coro {
    private Corista []semicircular;
    private int dimL;
    
    public Semicircular(Director director, int cantCoristas) {
        super(director,cantCoristas);
        semicircular = new Corista[cantCoristas];
        dimL = 0;
    }
    
    public void agregarCorista(Corista corista) {
        if (dimL < getCantCoristas()) {
            semicircular[(getCantCoristas() - 1) - dimL] = corista;
            System.out.println("Corista agregado correctamente");
            dimL++;
        }
        else
            System.out.println("Coro lleno");
    }
    
    public boolean estaLleno() {
        return dimL == getCantCoristas();
    }
    
    public boolean estaOrdenado() {
        boolean aux = false;
        int pos = 0;
        while (pos < (dimL-1) && (semicircular[pos].getTono() < semicircular[pos+1].getTono())) {
            pos++;
            aux = true;
        }
        return aux;
    }
    
    public String toString() {
        String aux = super.toString();
        for (int i=0; i<dimL; i++)
            aux += "    " + semicircular[i].toString();
        return aux;
    }
}
