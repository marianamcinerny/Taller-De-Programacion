/*
5-A- Definir una clase para representar círculos. Los círculos se caracterizan por su radio
(double), el color de relleno (String) y el color de línea (String).
Provea un constructor que reciba todos los datos necesarios para iniciar el objeto.
Provea métodos para:
- Devolver/modificar el valor de cada uno de sus atributos (métodos get y set)
- Calcular el perímetro y devolverlo (método calcularPerimetro)
- Calcular el área y devolverla (método calcularArea)
B- Realizar un programa que instancie un círculo, le cargue información leída de teclado e
informe en consola el perímetro y el área.
NOTA: la constante PI es Math.PI
 */
package practica3;

/**
 *
 * @author PJN
 */
import PaqueteLectura.Lector;
public class ejercicio5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        double radio; String colorR, colorL;
        System.out.print("Radio: "); radio = Lector.leerDouble();
        System.out.print("Color de relleno: "); colorR = Lector.leerString();
        System.out.print("Color de linea: "); colorL = Lector.leerString();
        
        Circulo c = new Circulo(radio,colorR,colorL);
        System.out.println("Perimetro: " + c.calcularPerimetro());
        System.out.println("Area: " + c.calcularArea());
        
    }
    
}
