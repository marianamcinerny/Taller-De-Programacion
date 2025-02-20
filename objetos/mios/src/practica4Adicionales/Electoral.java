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
public class Electoral extends Urna{
    private int cantListas;
    private int []contadorVotosLista;
    
    public Electoral(int numero, int cantListas, Zona zona) {
        super(numero,zona);
        this.cantListas = cantListas;
        contadorVotosLista = new int [cantListas];
        this.inicializar();
    }
    
    private void inicializar(){
        for (int i=0; i<cantListas; i++)
            contadorVotosLista[i] = 0;
    }
    
    public void setCantListas(int cantListas) {
        this.cantListas = cantListas;
    }
    
    public int getCantListas() {
        return this.cantListas;
    }
    
    public boolean validarNumeroDeLista(int numero) {
        boolean aux = false;
        for (int i = 0; i<this.getCantListas(); i++)
            if ( i == numero)
                aux = true;
        return aux;
    }
    
    public void votarPorLista(int numero) {
        contadorVotosLista[numero] ++;
    }
    
    public int devolverVotosPorLista(int numero) {
        return contadorVotosLista[numero];
    }
    
    public int calcularGanador() {
        int maxV = -1, maxLista = -1;
        for (int i=0; i<this.getCantListas(); i++)
            if (contadorVotosLista[i] > maxV) {
                maxV = contadorVotosLista[i];
                maxLista = i;
            }
        return maxLista;
    }
    
    public int calcularTotalVotos() {
        int aux = getVotosB();
        for (int i=0; i<this.getCantListas(); i++) {
            aux += contadorVotosLista[i];
        }
        return aux;
    }
}
