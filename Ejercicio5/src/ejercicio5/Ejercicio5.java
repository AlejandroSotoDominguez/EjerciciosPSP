
package ejercicio5;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Ejercicio5 extends Thread {

    public Ejercicio5(String nombre){
        super(nombre);
    }

    // Iniciamos
    public static void main(String[] args) throws InterruptedException {
        Thread h1 = new hilo1();
        Thread h2 = new hilo2();
        // Esperamos a que termine el hilo 2 para iniciar el hilo 1
        h2.start();
        h2.join();
        h1.start();
        // Establecemos la prioridad de cada hilo
        // h2.setPriority(10);
        // h1.setPriority(1); 
    }
    
    static class hilo1 extends Thread{
        public void run(){
            System.out.println("Ola, son o fío número 1");
        }
    }
    
    static class hilo2 extends Thread{
        public void run(){
            System.out.println("Ola, son o fío número 2");
        }
    }

}
