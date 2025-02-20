/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial10;

/**
 *
 * @author PJN
 */
public class Estadio {
    private String nombre;
    private String direccion;
    private int capacidad;
    private Concierto [][]agenda;
    private int dimL[];
    
    public Estadio(String nombre, String direccion, int capacidad) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.capacidad = capacidad;
        agenda = new Concierto[12][31];
        dimL = new int[12];
        this.inicializar();
    }
    
    private void inicializar() {
        for (int i=0; i<12; i++)
            dimL[i] = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public Concierto[][] getAgenda() {
        return agenda;
    }
    
    public void registrarConcierto(Concierto concierto, int mes) {
        if (dimL[mes-1] < 31) {
            agenda[mes-1][dimL[mes-1]] = concierto;
            dimL[mes-1]++;
            System.out.println("Concierto registrado correctamente");
        }
        else
            System.out.println("No hay mas espacio en ese mes");
    }
    
    public String listarConciertos(int mes) {
        String aux = "Conciertos del mes " + mes + ": " + "\n";
        for (int i=0; i<dimL[mes-1]; i++)
            aux += "    " +agenda[mes-1][i].toString() + "\n";
        return aux;
    }
    
    public double getGananciaMensual(int mes) {
        double precio,total = 0;
        int cant;
        for (int i=0; i<dimL[mes-1]; i++) {
            cant = agenda[mes-1][i].getVendidas();
            precio = agenda[mes-1][i].getPrecio();
            total += cant * precio;
        }
        return total/2;
    }
    
    public String toString() {
        String aux = "Estadio: " + nombre + ", direccion: " + direccion + ", capacidad: " + capacidad + "\n";
        for (int i=0; i<12; i++) {
            aux += "Mes " + (i+1) + ": " + "\n";
            if (dimL[i] == 0)
                aux += "    No hay conciertos para este mes" + "\n";
            else
                for(int j=0; j<dimL[i]; j++)
                    aux += "    Dia " + (j+1) + ": " + agenda[i][j].toString() + "\n";
        }
        return aux;
    }
    
    
}
