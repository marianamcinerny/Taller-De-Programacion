/*
1- a) Cargue la clase Auto.java (dada por la cátedra) en su proyecto.
Un objeto auto se crea sin valores iniciales y responde a los siguientes mensajes:
getPatente() retorna la patente (int) del auto
getDueño() retorna el nombre del dueño (String) del auto
setPatente(X) modifica el número de patente al “int” pasado por parámetro (X)
setDueño(X) modifica el nombre del dueño al “String” pasado por parámetro (X)
toString() retorna un String que representa al objeto. Ej: “Patente 111222 Dueño Carla
Perez”

b) Simular la entrada de autos al estacionamiento municipal en el centro de la ciudad. El
estacionamiento está dividido en N pisos y cada piso tiene N plazas, y debemos
almacenar en una estructura de datos adecuada los autos estacionados.
Realice un programa que lea la información de 5 autos que desean estacionar. Por cada
auto, también lea número de piso y número de plaza e ingréselo en la estructura en el
lugar adecuado.
Nota: N se ingresa por teclado. Al principio el estacionamiento debe estar vacío (sin
autos).
c) A partir de la estructura de autos:
i. Informar para cada número de piso y número de plaza ocupado, la
representación del auto que la ocupa.
ii. Informar cuál es el piso más ocupado.
iii. Informar el total de autos estacionados en la plaza 1 (tenga en cuenta
todos los pisos).
iv. Informar el total de autos que ocupan lugares con igual número de piso y
número de plaza.
 */
package practica2Adicionales;

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
        
        int pisos,plazas;
        System.out.print("Cantidad de pisos: "); pisos = Lector.leerInt();
        System.out.print("Cantidad de plazas; "); plazas = Lector.leerInt();
        
        Auto [][]estacionamiento = new Auto[pisos][plazas];
        for (int i = 0; i < pisos; i++)
            for (int j = 0; j < plazas; j++)
                estacionamiento[i][j] = null;
        
        String dueño; int patente, piso, plaza;
        for (int i = 0; i < 5; i ++) {
            System.out.print("Nombre del dueño: "); dueño = Lector.leerString();
            System.out.print("Patente: "); patente = Lector.leerInt();
            System.out.print("Piso: "); piso = Lector.leerInt();
            System.out.print("Plaza: "); plaza = Lector.leerInt();
            if (estacionamiento[piso-1][plaza-1] == null) {
                estacionamiento[piso-1][plaza-1] = new Auto();
                estacionamiento[piso-1][plaza-1].setDueño(dueño);
                estacionamiento[piso-1][plaza-1].setPatente(patente);
            }
        }
        
        int cantOcupado = 0, maxOcupado = - 1, pisoMax = -1, cantP1 = 0, cantIguales = 0;
        for (int i = 0; i < pisos; i++) {
            for (int j = 0; j < plazas; j++)
                if (estacionamiento[i][j] != null) {
                    System.out.println("Piso " + (i+1) + " plaza " + (j+1) + ": " + estacionamiento[i][j].toString());
                    cantOcupado = cantOcupado + 1;
                    if (j == 1)
                        cantP1 = cantP1 + 1;
                    if (i == j)
                        cantIguales = cantIguales + 1;
                }
            if (cantOcupado > maxOcupado) {
                maxOcupado = cantOcupado;
                pisoMax = i;
            }
        }
        System.out.println("El piso mas ocupado es el " + pisoMax);
        System.out.println("Total de autos estacionados en las plazas 1: " + cantP1);
        System.out.println("Total de autos que ocupan lugares con igual numero de piso y plaza: " + cantIguales);
    }
}
