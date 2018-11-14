
package ejercicio2;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Ejercicio2 extends Thread {
    String hilo;
    
    public Ejercicio2(String rm){
        hilo = rm;
    }
    
    public void run(){
        for(int i=0;i<5;i++){
            System.out.println(hilo+" "+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.getMessage();
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Ejercicio2("hilo1");
        Thread t2 = new Ejercicio2("hilo2");
        Thread t3 = new Ejercicio2("hilo3");
        Thread t4 = new Ejercicio2("hilo4");
        
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
    
}
