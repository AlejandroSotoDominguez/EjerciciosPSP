
package ejerciciosocketservidor;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.ServerSocket;

public class EjercicioSocketServidor {
    
    /*
    1. Cámbiale el puerto de conexión a 6666 y programa una conversación 
    entre el cliente y el servidor de 3 mensajes cada uno.
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
            
            for (int i=1; i<=3; i++) {
                byte[] mensaje = new byte[30];
                is.read(mensaje);

                System.out.println("Mensaje recibido: " + new String(mensaje));
                System.out.println("Enviando mensaje ");
                
                String mensajeServidor = ("Mensaje desde el servidor " + i);
                os.write(mensajeServidor.getBytes());
                System.out.println("Mensaje enviado");
            }


            System.out.println("Cerrando el nuevo socket");

            newSocket.close();

            System.out.println("Cerrando el socket servidor");

            serverSocket.close();

            System.out.println("Terminado");

        }catch (IOException e) {
        }
		
    }
    
}
