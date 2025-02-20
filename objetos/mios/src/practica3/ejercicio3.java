/*
3-A- Defina una clase para representar estantes. Un estante almacena a lo sumo 20 libros.
Implemente un constructor que permita iniciar el estante sin libros. Provea métodos para:
(i) devolver la cantidad de libros que almacenados (ii) devolver si el estante está lleno
(iii) agregar un libro al estante (iv) devolver el libro con un título particular que se recibe.
B- Realice un programa que instancie un estante. Cargue varios libros. A partir del estante,
busque e informe el autor del libro “Mujercitas”.
C- Piense: ¿Qué modificaría en la clase definida para ahora permitir estantes que
almacenen como máximo N libros? ¿Cómo instanciaría el estante?

 */
package practica3;

/**
 *
 * @author PJN
 */
import PaqueteLectura.Lector;
public class ejercicio3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Autor a1 = new Autor("Elizabeth Mc Inerny");
        Autor a2 = new Autor("Michu Mc Inerny");
        Autor a3 = new Autor("Bolt Mc Inerny");
        Autor a4 = new Autor("Catedra de mierda");
        
        Estante estante = new Estante();
        estante.agregarLibro("Como salir a pasear", "Coquitos", 2011, a1, "ABC-123", 200.45);
        estante.agregarLibro("Como cazar ratas", "Coquitos", 2013, a2, "DEF-456", 200.45);
        estante.agregarLibro("Como encontrar pelotas con el olfato", "Coquitos", 2017, a3, "GHI-789", 200.45);
        estante.agregarLibro("Mujercitas", "ed", 2024, a4, "JKL-012", 0.5);
        
        System.out.println("Cantidad de libros almacenados: " + estante.cantLibros());
        
        if (estante.lleno())
            System.out.println("El estante esta lleno");
        else
            System.out.println("El estante no esta lleno");
        
        String titulo;
        System.out.print("Escriba un titulo: "); titulo = Lector.leerString();
        if (estante.encontrarLibro(titulo) == null)
            System.out.println("El libro no existe");
        else
            System.out.println(estante.encontrarLibro(titulo).getPrimerAutor().toString());
    }
    
}
