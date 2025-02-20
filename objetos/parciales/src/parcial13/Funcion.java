/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial13;

/**
 *
 * @author PJN
 */
public class Funcion {
    private String titulo;
    private String fecha;
    private double hora;
    private Butaca [][]sala;
    private int filas;
    private int butacas;
    
    public Funcion(String titulo, String fecha, double hora, int filas, int butacas) {
        this.titulo = titulo;
        this.fecha = fecha;
        this.hora = hora;
        this.filas = filas;
        this.butacas = butacas;
        sala = new Butaca[filas][butacas];
        this.inicializar();
    }
    
    private void inicializar() {
        for (int i=0; i<filas; i++)
            for (int j=0; j<butacas; j++) {
                double precio = 800 + (100 * i);
                sala[i][j] = new Butaca(i,j,precio);
            }
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getHora() {
        return hora;
    }

    public void setHora(double hora) {
        this.hora = hora;
    }

    public int getCantFilas() {
        return filas;
    }

    public void setCantFilas(int filas) {
        this.filas = filas;
    }

    public int getCantButacas() {
        return butacas;
    }

    public void setCantButacas(int butacas) {
        this.butacas = butacas;
    }
    
    public double ocuparButaca(int numButaca, int fila) {
        sala[fila-1][numButaca-1].setEstado(true);
        double precio = sala[fila-1][numButaca-1].getPrecio();
        return precio;
    }
    
    public void desocuparButacas(int fila) {
        for (int i=0; i<butacas; i++)
            if (sala[fila-1][i].getEstado() == true)
                sala[fila-1][i].setEstado(false);
    }
    
    public String descripcionButacaB(int num) {
        String aux = "";
        for (int i=0; i<filas; i++)
            aux += sala[i][num-1].toString() + "\n";
        return aux;
    }
    
    public String toString() {
        String aux = titulo + ", " + fecha + " " + hora + "\n";
        for (int i=0; i<filas; i++) {
            aux += "Fila " + (i+1) + ": " + "\n";
            for (int j=0; j<butacas; j++)
                aux += "    " + sala[i][j].toString() + "\n";
        }
        return aux;
    }
}
