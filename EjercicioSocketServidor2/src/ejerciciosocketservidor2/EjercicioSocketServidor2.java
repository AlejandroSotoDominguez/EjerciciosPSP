
package ejerciciosocketservidor2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class EjercicioSocketServidor2 {
    
    /*
    2. Programa el cliente para que envíe una lista de 5 números al servidor. 
    El servidor los sumará y devolverá el resultado al cliente, que lo mostrará por pantalla.
    */

    public static void main(String[] args) {
        try{
            System.out.println("Creando socket servidor");

            ServerSocket serverSocket=new ServerSocket();

            System.out.println("Realizando el bind");

            InetSocketAddress addr=new InetSocketAddress("localhost",6666);
            serverSocket.bind(addr);

            System.out.println("Aceptando conexiones");

            Socket newSocket= serverSocket.accept();

            System.out.println("Conexión recibida");

            InputStream is=newSocket.getInputStream();
            OutputStream os=newSocket.getOutputStream();
            

            byte[] numeros = new byte[30];
            is.read(numeros);
            
            System.out.println("Mensaje recibido: "+new String(numeros));
            String mensaje=new String(numeros);
            
            String[]listaNum = mensaje.split(",");
            
            int suma=0;
            for(int i=0; i<listaNum.length-1; i++){
                suma=suma+Integer.parseInt(listaNum[i]);
            }
            
            System.out.println("Total suma: "+suma);

            System.out.println("Cerrando el nuevo socket");

            newSocket.close();

            System.out.println("Cerrando el socket servidor");

            serverSocket.close();

            System.out.println("Terminado");

        }catch (IOException e) {
        }
    }
    
}
