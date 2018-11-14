
package ejercicio3;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Ejercicio3 extends Thread {
    
    public static String nombreHilo = "";
    
    public Ejercicio3(String nombre){
        super(nombre);
    }
    
    public void run(){
        
        nombreHilo = getName();
        Thread h1 = new Ejercicio3(nombreHilo);
        System.out.println("Hola "+getName());
        try {  
            for(int i=0;i<10;i++){
                Thread.sleep((int) ((Math.random()*600)+100));
                System.out.println(nombreHilo);

                if(i==9){
                    System.out.println("Adiós "+nombreHilo);
                    h1.join();
                }
            }    
 
            nombreHilo = "Hilo 2";
            Thread h2 = new Ejercicio3(nombreHilo);
            System.out.println("Hola "+ getName());
            for(int i=0;i<10;i++){

                Thread.sleep((int) ((Math.random()*600)+100));
                System.out.println(nombreHilo);

                if(i==9){
                    System.out.println("Adiós "+nombreHilo);
                    h2.join();
                }
            }

            nombreHilo = "Hilo 3";
            Thread h3 = new Ejercicio3(nombreHilo);
            System.out.println("Hola "+ nombreHilo);
            for(int i=0;i<10;i++){

                Thread.sleep((int) ((Math.random()*600)+100));
                System.out.println(nombreHilo);

                if(i==9){
                    System.out.println("Adiós "+nombreHilo);
                    h3.join();
                }
            }
            
            nombreHilo = "Hilo 4";
            Thread h4 = new Ejercicio3(nombreHilo);
            System.out.println("Hola "+ nombreHilo);
            for(int i=0;i<10;i++){

                Thread.sleep((int) ((Math.random()*600)+100));
                System.out.println(nombreHilo);

                if(i==9){
                    System.out.println("Adiós "+nombreHilo);
                    h4.join();
                }
            }
                
            nombreHilo = "Hilo 5";
            Thread h5 = new Ejercicio3(nombreHilo);
            System.out.println("Hola "+ nombreHilo);
            for(int i=0;i<10;i++){

                Thread.sleep((int) ((Math.random()*600)+100));
                System.out.println(nombreHilo);

                if(i==9){
                    System.out.println("Adiós "+nombreHilo);
                    h5.join();
                }
            }       

        } catch (InterruptedException ex) {
            Logger.getLogger(Ejercicio3.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public static void main(String[] args) {
        Thread h = new Ejercicio3("Hilo 1");
        h.start();
 
    }
 
}
