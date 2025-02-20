/*
5-A- Modifique la clase VisorFiguras: ahora debe permitir guardar las figuras a mostrar (a
lo sumo 5) y también mostrar todas las figuras guardadas. Use la siguiente estructura.
B- Realice un programa que instancie el visor, guarde dos cuadrados y un rectángulo en el
visor y por último haga que el visor muestre sus figuras almacenadas.
 */
package practica4;

/**
 *
 * @author PJN
 */
public class ejercicio5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        VisorFigurasModificado visor = new VisorFigurasModificado();
        
        Circulo c = new Circulo("rosa","rosa",5.7);
        Triangulo t = new Triangulo("violeta","violeta",5.6,3.2,5.5);
        
        visor.guardar(c);
        visor.guardar(t);
        
        if (visor.quedaEspacio())
            System.out.println("Queda espacio");
        else
            System.out.println("No queda espacio");
            
        visor.mostrar(c);
        visor.mostrar(t);
        
        System.out.println("Cantidad de figuras guardadas: " + visor.getGuardadas());
    }
    
}
