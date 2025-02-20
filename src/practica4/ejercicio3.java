/*
3-A- Implemente las clases para el siguiente problema. Una garita de seguridad quiere
identificar los distintos tipos de personas que entran a un barrio cerrado. Al barrio pueden
entrar: personas, que se caracterizan por nombre, DNI y edad; y trabajadores, estos son
personas que se caracterizan además por la tarea realizada en el predio.
Implemente constructores, getters y setters para las clases. Además tanto las personas
como los trabajadores deben responder al mensaje toString siguiendo el formato:
 Personas “Mi nombre es Mauro, mi DNI es 11203737 y tengo 70 años”
 Trabajadores “Mi nombre es Mauro, mi DNI es 11203737 y tengo 70 años. Soy jardinero.”
B- Realice un programa que instancie una persona y un trabajador y muestre la
representación de cada uno en consola.
NOTA: Reutilice la clase Persona (carpeta tema2).
 */
package practica4;

/**
 *
 * @author PJN
 */
public class ejercicio3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Persona p = new Persona("Maria",45223,50);
        Trabajador t = new Trabajador("Julia",54345,30,"jardinera");
        
        System.out.println(p.toString());
        System.out.println(t.toString());
    }
    
}
