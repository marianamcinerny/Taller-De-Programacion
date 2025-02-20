/*
5- Se dispone de la clase Partido (en la carpeta tema2). Un objeto partido representa un
encuentro entre dos equipos (local y visitante). Un objeto partido puede crearse sin
valores iniciales o enviando en el mensaje de creación el nombre del equipo local, el
nombre del visitante, la cantidad de goles del local y del visitante (en ese orden). Un objeto
partido sabe responder a los siguientes mensajes:
getLocal() retorna el nombre (String) del equipo local
getVisitante() retorna el nombre (String) del equipo visitante
getGolesLocal() retorna la cantidad de goles (int) del equipo local
getGolesVisitante() retorna la cantidad de goles (int) del equipo visitante
setLocal(X) modifica el nombre del equipo local al “String” X
setVisitante(X) modifica el nombre del equipo visitante al “String” X
setGolesLocal(X) modifica la cantidad de goles del equipo local al “int” X
setGolesVisitante(X) modifica la cantidad de goles del equipo visitante al “int” X
hayGanador() retorna un boolean que indica si hubo (true) o no hubo (false) ganador
getGanador() retorna el nombre (String) del ganador del partido (si no hubo retorna
un String vacío).
hayEmpate() retorna un boolean que indica si hubo (true) o no hubo (false) empate
Implemente un programa que cargue un vector con a lo sumo 20 partidos disputados en
el campeonato. La información de cada partido se lee desde teclado hasta ingresar uno con
nombre de visitante “ZZZ” o alcanzar los 20 partidos. Luego de la carga:
- Para cada partido, armar e informar una representación String del estilo:
{EQUIPO-LOCAL golesLocal VS EQUIPO-VISITANTE golesVisitante }
- Calcular e informar la cantidad de partidos que ganó River.
- Calcular e informar el total de goles que realizó Boca jugando de local
 */
package practica2;

/**
 *
 * @author PJN
 */
import PaqueteLectura.Lector;
import PaqueteLectura.GeneradorAleatorio;
public class ejercicio5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        GeneradorAleatorio.iniciar();
        Partido []vector = new Partido[20];
        
        int num = 0, golesLocal, golesVisitante; String local, visitante; 
        System.out.print("Visitante: "); visitante = Lector.leerString();
        while ((num < 20) && (!visitante.equals("ZZZ"))) {
            System.out.print("Local"); local = Lector.leerString();
            golesLocal = GeneradorAleatorio.generarInt(6);
            golesVisitante = GeneradorAleatorio.generarInt(6);
            vector[num] = new Partido(local,visitante,golesLocal,golesVisitante);
            num = num + 1;
            if (num < 20) {
                System.out.print("Visitante: "); visitante = Lector.leerString();
            }
        }
        
        int aux = 0, riverGanador = 0, bocaGoles = 0; 
        while (vector[aux] != null && aux < 20) {
            System.out.println(vector[aux].toString());
            if (vector[aux].getGanador().equals("river"))
                riverGanador = riverGanador + 1;
            if (vector[aux].getLocal().equals("boca") || vector[aux].getVisitante().equals("boca")) {
                if (vector[aux].getLocal().equals("boca"))
                    bocaGoles = bocaGoles + vector[aux].getGolesLocal();
                else
                    bocaGoles = bocaGoles + vector[aux].getGolesVisitante();
            }
            aux = aux + 1;
        }
        System.out.println("Cantidad de partidos que gano River: " + riverGanador);
        System.out.println("Cantidad de goles hechos por Boca: " + bocaGoles);
        
    }
    
}
