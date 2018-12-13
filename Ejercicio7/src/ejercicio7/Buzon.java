
package ejercicio7;

public class Buzon {
    private String mensaje="mensaje";

    public Buzon() {
    }

    public synchronized String getMensaje() {
        if(mensaje==""){
            try{
                System.out.println("No hay ningún mensaje"); 
                wait();
            }catch(InterruptedException ie){
                ie.getMessage();
            }
        }
        notify();
        return mensaje;
        
    }

    public synchronized void setMensaje(String mensaje) {
        this.mensaje=mensaje;
        if(mensaje!=""){
            try{
                System.out.println("Hay un mensaje");
                wait();
            }catch(InterruptedException ie){
                ie.getMessage();
            }
        }
        System.out.println("No hay ningún mensaje");
        notify();
    }
    
    public void borrar() {
        this.mensaje = "";
    }
    
    
}
