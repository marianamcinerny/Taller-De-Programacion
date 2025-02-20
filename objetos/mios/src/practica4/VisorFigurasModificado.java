/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4;

/**
 *
 * @author PJN
 */
public class VisorFigurasModificado {
    private int guardadas;
    private int capacidadMaxima = 5;
    private Figura []vector;
    
    public VisorFigurasModificado() {
        vector = new Figura[capacidadMaxima];
        guardadas = 0;
    }
    
    public void guardar (Figura f) {
        if (guardadas < capacidadMaxima) {
            vector[guardadas] = f;
            guardadas++;
        }
        else
            System.out.println("No hay mas espacio");
    }
    
    public boolean quedaEspacio(){
        return guardadas < capacidadMaxima;
    }
    
    public void mostrar(Figura f){
        System.out.println(f.toString());
    }
    
    public int getGuardadas() {
        return guardadas;
    }
}
