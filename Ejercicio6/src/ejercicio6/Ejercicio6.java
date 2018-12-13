
package ejercicio6;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Ejercicio6 extends Thread {
    
    /*
    Simular a caixa dunha empresa con dous fíos. Un simulará o ingreso, ca compra de
    artigos por parte de clientes e o outro a extracción de cartos da caixa co pago a proveedores. 
    A conta terá un capital inicial. Realizar 10 ingresos e 5 extraccións.
    */
    
    static int cuentaIngreso;
    static int cuentaExtraccion;
    static Caja c = new Caja();
    /**
     * Se crean 2 hilos, se inician y cuando terminan se muestra el resultado de la cuenta inicial y final
     * @param args
     * @throws InterruptedException 
     */

    public static void main(String[] args) throws InterruptedException {
        // Mostramos el saldo inicial
        System.out.println("Saldo inicial: "+c.getDinero());
        // Iniciamos los hilos de ingreso y extracción
        Thread h1 = new Ingreso();
        h1.start();
        Thread h2 = new Extraccion();
        h2.start();
        // Esperamos a que terminen para comprobar el saldo final
        h1.join();
        h2.join();
        // Mostramos el saldo final
        System.out.println("Saldo total: "+c.getDinero());
    }
    
    // Hilo que ingresa dinero en la cuenta
    static class Ingreso extends Thread {

        public void run(){
            for(int i=1; i<=10; i++){
                cuentaIngreso += 1;                
            }c.setDinero(c.getDinero()+cuentaIngreso);
        }
    }
    
    // Hilo que extrae dinero de la cuenta
    static class Extraccion extends Thread{

        public  void run(){
            for(int i=1; i<=5; i++){
                cuentaExtraccion -= 1;       
            }c.setDinero(c.getDinero()+cuentaExtraccion);
        }
    }
    
    
}
