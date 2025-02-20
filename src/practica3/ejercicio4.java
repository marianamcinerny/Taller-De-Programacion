/*
4-A- Un hotel posee N habitaciones. De cada habitación conoce costo por noche, si está
ocupada y, en caso de estarlo, guarda el cliente que la reservó (nombre, DNI y edad).
(i) Genere las clases necesarias. Para cada una provea métodos getters/setters adecuados.
(ii) Implemente los constructores necesarios para iniciar: los clientes a partir de nombre,
DNI, edad; el hotel para N habitaciones, cada una desocupada y con costo aleatorio e/
2000 y 8000.
(iii) Implemente en las clases que corresponda todos los métodos necesarios para:
- Ingresar un cliente C en la habitación número X. Asuma que X es válido (es decir, está
en el rango 1..N) y que la habitación está libre.
- Aumentar el precio de todas las habitaciones en un monto recibido.
- Obtener la representación String del hotel, siguiendo el formato:
{Habitación 1: costo, libre u ocupada, información del cliente si está ocupada}
…
{Habitación N: costo, libre u ocupada, información del cliente si está ocupada}
B- Realice un programa que instancie un hotel, ingrese clientes en distintas habitaciones,
muestre el hotel, aumente el precio de las habitaciones y vuelva a mostrar el hotel.
NOTAS: Reúse la clase Persona. Para cada método solicitado piense a qué clase debe
delegar la responsabilidad de la operación.

 */
package practica3;

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
        Hotel hotel = new Hotel(10);
        
        Huesped h1 = new Huesped("Mariana",523453,23);
        Huesped h2 = new Huesped("Sofia",54343,23);
        Huesped h3 = new Huesped("Nicolas",635334,23);
        Huesped h4 = new Huesped("Guillermo",543423,23);
        
        hotel.ingresarHuesped(h1, 3);
        hotel.ingresarHuesped(h2, 1);
        hotel.ingresarHuesped(h3, 10);
        hotel.ingresarHuesped(h4, 6);
        
        System.out.print(hotel.toString());
        
        hotel.aumentar(300.50);
        
        System.out.println(" ");
        System.out.print(hotel.toString());
    }
    
}
