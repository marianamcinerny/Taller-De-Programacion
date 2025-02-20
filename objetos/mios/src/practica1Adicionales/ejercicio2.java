/*
2- Queremos organizar libros en una estantería. La estantería tiene 5 estantes, cada uno
tiene espacio para 10 libros. Los libros se organizarán en la estantería según su peso.
Desde el estante superior al inferior irán los libros con peso 1g..299g, 300g..599g, 600g
a 899g, 900g a 1199g, 1200g a 1500g (como se muestra en la
figura). Suponga que los libros pesan menos de 1500g.
a. Declare una estructura adecuada para representar la
estantería, sabiendo que de cada libro sólo se guardará el
título.
b. Lea la información de los libros (título, peso) hasta
ingresar uno con peso 0 y almacénelos en la estantería según
su peso. En caso de existir espacio en el estante adecuado,
ingresar al libro en el primer lugar libre (de manera directa).
Caso contrario informe que no hay lugar para dicho libro.
Nota: el número de estante de un libro se calcula haciendo
e = peso_del_libro / 300. Además, piense en usar una estructura
que para cada estante guarde la cantidad de libros que tiene,
así sabrá cuál es el primer lugar libre de cada estante.
c. Luego de la carga (inciso b), informar para cada estante
los títulos de los libros que contiene.
 */
package practica1Adicionales;

import PaqueteLectura.Lector;
import PaqueteLectura.GeneradorAleatorio;

/**
 *
 * @author PJN
 */
import PaqueteLectura.Lector;
public class ejercicio2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        GeneradorAleatorio.iniciar();
        String [][]estanteria = new String[5][10];
        int []contador = new int[10];
        
        for (int i = 0; i < 10; i++)
            contador[i] = 0;
        
        String titulo; int peso,aux;
        System.out.print("Ingrese el peso del libro: ");
        peso = Lector.leerInt();
        while (peso != 0) {
            System.out.print("Ingrese el titulo del libro: ");
            titulo = GeneradorAleatorio.generarString(10); /*Lector.leerString();*/
            aux = peso / 300;
            if (contador[aux] < 10) {
                contador[aux] = contador[aux] + 1;
                estanteria[aux][contador[aux]-1] = titulo;
            }
            else
                System.out.println("No hay mas lugar en el estante");
            peso = Lector.leerInt();
        }
        
        System.out.println();
        System.out.println("Estanteria: ");
        for (int i = 0; i < 5; i++) {
            System.out.println();
            for (int j = 0; j < 10; j ++)
                System.out.print(estanteria[i][j] + " | ");
        }
    }
    
}
