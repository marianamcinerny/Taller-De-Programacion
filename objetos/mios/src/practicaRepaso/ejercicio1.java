/*
1- La UNLP desea administrar sus proyectos, investigadores y subsidios. Un proyecto
tiene: nombre, código, nombre completo del director y los investigadores que participan
en el proyecto (50 como máximo). De cada investigador se tiene: nombre completo,
categoría (1 a 5) y especialidad. Además, cualquier investigador puede pedir hasta un
máximo de 5 subsidios. De cada subsidio se conoce: el monto pedido, el motivo y si fue
otorgado o no.
i) Implemente el modelo de clases teniendo en cuenta:
a. Un proyecto sólo debería poder construirse con el nombre, código, nombre del
director.
b. Un investigador sólo debería poder construirse con nombre, categoría y
especialidad.
c. Un subsidio sólo debería poder construirse con el monto pedido y el motivo.
Un subsidio siempre se crea en estado no-otorgado.
ii) Implemente los métodos necesarios (en las clases donde corresponda) que permitan:
a. void agregarInvestigador(Investigador unInvestigador);
// agregar un investigador al proyecto.
b. void agregarSubsidio(Subsidio unSubsidio);
// agregar un subsidio al investigador.
c. double dineroTotalOtorgado();
//devolver el monto total otorgado en subsidios del proyecto (tener en cuenta
todos los subsidios otorgados de todos los investigadores)
d. void otorgarTodos(String nombre_completo);
//otorgar todos los subsidios no-otorgados del investigador llamado
nombre_completo
e. String toString();
// devolver un string con: nombre del proyecto, código, nombre del director, el
total de dinero otorgado del proyecto y la siguiente información de cada
investigador: nombre, categoría, especialidad, y el total de dinero de sus
subsidios otorgados.
iii) Escriba un programa que instancie un proyecto con tres investigadores. Agregue dos
subsidios a cada investigador y otorgue los subsidios de uno de ellos. Luego imprima
todos los datos del proyecto en pantalla.
 */
package practicaRepaso;

/**
 *
 * @author PJN
 */
import PaqueteLectura.GeneradorAleatorio;
public class ejercicio1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        GeneradorAleatorio.iniciar();
        
        double monto = GeneradorAleatorio.generarDouble(999);
        Subsidio s1 = new Subsidio(monto,"motivo privado");
        monto = GeneradorAleatorio.generarDouble(999);
        Subsidio s2 = new Subsidio(monto,"motivo privado");
        
        //nombre categoria especialidad
        Investigador inv1 = new Investigador("pepe",1,"rompe bolas");
        Investigador inv2 = new Investigador("maria",2,"rompe bolas");
        Investigador inv3 = new Investigador("la tia sebi",3,"chusma");
        
        Proyecto p = new Proyecto("Ejercicio 6",101010,"Mariana Mc Inerny");
        p.agregarInvestigador(inv1);
        p.agregarInvestigador(inv2);
        p.agregarInvestigador(inv3);
        
        inv1.agregarSubsidio(s1);
        inv1.agregarSubsidio(s2);
        inv2.agregarSubsidio(s1);
        inv2.agregarSubsidio(s2);
        inv3.agregarSubsidio(s1);
        inv3.agregarSubsidio(s2);
        
        p.otorgarTodos("la tia sebi");
        
        System.out.print("\n");
        System.out.println(p.toString());
        
    }
    
}
