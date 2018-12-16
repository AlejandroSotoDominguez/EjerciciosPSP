
package ejercicio8;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ejercicio8 {

    static boolean liebreGanador = false;
    static boolean tortugaGanador = false;
    static boolean movLiebre = false;
    static boolean movTortuga = false;
    static int posLiebre;
    static int posTortuga;
    
    public static void main(String[] args) {
        new Liebre().start();
        new Tortuga().start();
    }
    
    // Hilo liebre
    static class Liebre extends Thread{
        
        public synchronized void run(){
            // Establecemos la casilla 1 como casilla inicial
            int posLiebre = 1;
            
            while(posLiebre<70){
                // Generamos un número aleatorio entre 1 y 100 para determinar la probabilidad
                int aleatorio = (int)(Math.random()*100)+1;
                movLiebre=true;
                // Si la tortuga se esta moviendo bloqueamos el hilo esperando a que termine de hacer su movimiento
                if(movTortuga==true){
                    try {
                        wait(100);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Ejercicio8.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }// Liebre duerme 
                    if(aleatorio<=20){
                        // Liebre duerme 
                    }
                    else if(aleatorio>=20 && aleatorio<=40){
                        // Avanza 9 casillas
                        posLiebre+=9;
                    }
                    else if(aleatorio>=40 && aleatorio<=50){
                        // Retrocede 12 casillas
                        posLiebre-=12;
                    }
                    else if(aleatorio>=50 && aleatorio<=80){
                        // Avanza 1 casilla
                        posLiebre+=1;
                    }
                    else if(aleatorio>=80){
                        // Retrocede 2 casillas
                        posLiebre-=2;
                    }
                    // La posición nunca debe estar por debajo de 1
                    if(posLiebre<0){
                        posLiebre=1;
                    } 
                    System.out.println("Liebre: "+posLiebre);
                    movLiebre = false;
                    // Desbloqueamos el hilo
                    notify();
                    try {
                        sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Ejercicio8.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    if(liebreGanador==true){
                        System.out.println("Liebre ganadora");
                        posLiebre=70;    
                    }   
            }
            liebreGanador = true;
        }
    }
    
    // Hilo tortuga
    static class Tortuga extends Thread {
        int aleatorio = (int)(Math.random()*100)+1;
        public synchronized void run(){
            int posTortuga = 1;
            
            while(posTortuga<70){
                int aleatorio = (int)(Math.random()*100)+1;
                movTortuga = true;
                    if(movLiebre==true){
                    try {
                        wait(100);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Ejercicio8.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    }
                    if(aleatorio<=50){
                        // Avanza 3 casillas a la derecha 
                        posTortuga+=3;
                        
                    }
                    else if(aleatorio>=50 && aleatorio<=70){
                        // Retrocede 6 casillas
                        posTortuga-=6;
                        
                    }
                    else if(aleatorio>=70){
                        // Retrocede 12 casillas
                        posTortuga-=12;
                    }
                    if(posTortuga<0){
                        posTortuga=1;
                    } 
                    System.out.println("Tortuga: "+posTortuga);
                    movTortuga = false;
                    notify(); 
                    try {
                        sleep(1000);
                    }catch (InterruptedException ex) {
                        Logger.getLogger(Ejercicio8.class.getName()).log(Level.SEVERE, null, ex);
                    }   
                    if(tortugaGanador==true){
                        System.out.println("Tortuga ganadora");
                        posTortuga=70;
                    }
                     
            }
            tortugaGanador = true; 
        }
    }
    
    
}
