
package ejercicio7;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Ejercicio7 extends Thread {

    // Instanciamos un objeto estático de la clase Buzón.
    static Buzon b = new Buzon();
    
    public static void main(String[] args) {
        // Iniciamos el hilo Lector y Escritor.
        Thread h1 = new Lector();
        Thread h2 = new Escritor();
        h1.start();
        h2.start();
    }
    
    // Hilo que lee los mensajes
    static class Lector extends Thread {
        public void run(){
            for(int i=1; i<=10; i++){
                // Visualizamos el mensaje que ha escrito el hilo Escritor.
                System.out.println(b.getMensaje());
                // Borramos el mensaje
                b.borrar();
                try {
                    sleep(3000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Ejercicio7.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    // Hilo que escribe los mensajes
    static class Escritor extends Thread {
        public void run(){
            for(int i=1; i<=10; i++){
                // Escribimos el mensaje por pantalla
                String mensaje=JOptionPane.showInputDialog("Mensaje:");
                b.setMensaje(mensaje);
                try {
                    sleep(3000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Ejercicio7.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
}
