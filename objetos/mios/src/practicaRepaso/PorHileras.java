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
public class PorHileras extends Coro{
    private Corista [][]porHileras;
    private int []dimLHileras;
    
    public PorHileras(Director director, int cantCorista) {
        super(director,cantCorista);
        porHileras = new Corista[cantCorista][cantCorista];
        dimLHileras = new int [cantCorista];
        this.inicializar();
    }
    
    private void inicializar() {
        for (int i=0; i<getCantCoristas(); i++)
            dimLHileras[i] = 0;
    }
    
    public void agregarCorista(Corista corista) {
        int i = 0;
        while (i< getCantCoristas() && dimLHileras[i] == getCantCoristas())
            i++;
        if (i< getCantCoristas() && dimLHileras[i] < getCantCoristas()) {
            porHileras[i][dimLHileras[i]] = corista;
            dimLHileras[i]++;
            System.out.println("Corista agregado correctamente");
        }
        else
            System.out.println("Coro lleno");
    }
    
    public boolean estaLleno() {
        int aux = getCantCoristas();
        int habria = aux * aux;
        int total = 0;
        for (int i=0; i<aux; i++)
            total += dimLHileras[i];
        return habria == total;
    }
    
    public boolean estaOrdenado(){
        boolean aux = true;
        int posF = 0, posC = 0, cant = getCantCoristas();
        int tonoAnterior = porHileras[posF][posC].getTono() + 1;
        int tonoActual = porHileras[posF][posC].getTono();
        while(aux == true && posF < (cant-1) && tonoActual == porHileras[posF][posC].getTono() && tonoAnterior > tonoActual) {
            while (aux == true && posC < (cant-1) && tonoActual == porHileras[posF][posC].getTono() && tonoAnterior > tonoActual) {
                posC++;
                if (tonoActual != porHileras[posF][posC].getTono() || tonoAnterior < tonoActual)
                    aux = false;
            }
            posC = 0;
            posF++;
            tonoAnterior = tonoActual;
            tonoActual = porHileras[posF][posC].getTono();
        }
        return aux;
    }
    
    public String toString() {
        String aux = super.toString();
        for (int i=0; i<getCantCoristas(); i++)
            for (int j=0; j<dimLHileras[i]; j++)
                aux += "    " + porHileras[i][j].toString();
        return aux;
    }
}
