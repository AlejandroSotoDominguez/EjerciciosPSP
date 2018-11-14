
package ejercicio1;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Ejercicio1 extends Thread {
    String hilo;
            
    public Ejercicio1(String rm){
        hilo = rm;
    }
    
    public void run() {
        
        try {
            for(int i=0;i<10;i++){
                System.out.println(hilo+" "+i);
                Thread.sleep((int) ((Math.random()*1000)+1));
            }        

        } catch (InterruptedException ex) {
            ex.getMessage();
        }
        
    }

    public static void main(String[] args) {
        Thread t1 = new Ejercicio1("hilo1");
        Thread t2 = new Ejercicio1("hilo2");
        
        t1.start();
        t2.start();
    }
    
}
