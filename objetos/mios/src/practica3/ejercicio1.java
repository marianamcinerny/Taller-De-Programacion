/*
1-A- Definir una clase para representar triángulos. Un triángulo se caracteriza por el
tamaño de sus 3 lados (double), el color de relleno (String) y el color de línea (String).
Provea un constructor que reciba todos los datos necesarios para iniciar el objeto.
Provea métodos para:
- Devolver/modificar el valor de cada uno de sus atributos (métodos get y set)
- Calcular el perímetro y devolverlo (método calcularPerimetro)
- Calcular el área y devolverla (método calcularArea)
B- Realizar un programa que instancie un triángulo, le cargue información leída desde
teclado e informe en consola el perímetro y el área.
NOTA: Calcular el área con la fórmula Área = √s(s − a)(s − b)(s − c) , donde a, b y c son
los lados y s =
𝐚+𝐛+𝐜/2. La función raíz cuadrada es Math.sqrt(#)
 */
package practica3;

/**
 *
 * @author PJN
 */
import PaqueteLectura.Lector;
public class ejercicio1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        double lado1,lado2,lado3;
        String colorR,colorL;
        System.out.print("Valor del lado 1: "); lado1 = Lector.leerDouble();
        System.out.print("Valor del lado 2: "); lado2 = Lector.leerDouble();
        System.out.print("Valor del lado 3: "); lado3 = Lector.leerDouble();
        System.out.print("Color de relleno: "); colorR = Lector.leerString();
        System.out.print("Color de linea: "); colorL = Lector.leerString();
        Triangulo t = new Triangulo(lado1,lado2,lado3,colorR,colorL);
        
        System.out.println();
        System.out.println("Permietro: " + t.calcularPerimetro() + ". Area: " + t.calcularArea());
    }
    
}
