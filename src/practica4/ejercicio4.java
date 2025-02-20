/*
4- Un objeto visor de figuras se encarga de mostrar en consola cualquier figura que reciba
y también mantiene cuántas figuras mostró. Analice y ejecute el siguiente programa y
responda: ¿Qué imprime? ¿Por qué?

 */
package practica4;

/**
 *
 * @author PJN
 */
public class ejercicio4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        VisorFiguras visor = new VisorFiguras();
        
        Circulo c = new Circulo("rosa","rosa",5.7);
        Triangulo t = new Triangulo("violeta","violeta",5.6,3.2,5.5);
        
        visor.mostrar(c);
        visor.mostrar(t);
        
        System.out.println(visor.getMostradas());
    }
    
}
