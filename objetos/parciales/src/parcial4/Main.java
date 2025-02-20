/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial4;

/**
 *
 * @author PJN
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Grado alumnoA1 = new Grado("ana",544353,3,"informatica");
        Grado alumnoA2 = new Grado("juan",544353,3,"informatica");
        Doctorado alumnoA3 = new Doctorado("patricio",4324234,3,"lic. en informatica","UNLP");
        
        Materia m1 = new Materia("Tesis",9,"9 de diciembre del 2024");
        Materia m2 = new Materia("materia 1",10,"10 de octubre del 2023");
        Materia m3 = new Materia("materia 2",8,"4 de abril del 2023");
        
        alumnoA3.agregarMateria(m3);
        alumnoA3.agregarMateria(m2);
        alumnoA3.agregarMateria(m1);
        alumnoA1.agregarMateria(m3);
        
        System.out.println(alumnoA3.toString());
        System.out.print("\n");
        System.out.println(alumnoA2.toString());
        System.out.print("\n");
        System.out.println(alumnoA1.toString());
        
    }
    
}
