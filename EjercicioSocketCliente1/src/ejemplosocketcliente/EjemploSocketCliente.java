
package ejemplosocketcliente;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Arrays;

/*
1. Cámbiale el puerto de conexión a 6666 y programa una conversación 
entre el cliente y el servidor de 3 mensajes cada uno.
*/

public class EjemploSocketCliente {

    public static void main(String[] args) {
        try{
            System.out.println("Creando socket cliente");
            Socket clienteSocket=new Socket();
            System.out.println("Estableciendo la conexión");

            InetSocketAddress addr=new InetSocketAddress("localhost",6666);
            clienteSocket.connect(addr);

            InputStream is = clienteSocket.getInputStream();
            OutputStream os= clienteSocket.getOutputStream();

            for (int i=1; i<=3; i++) {
                System.out.println("Enviando mensaje ");
                String mensajeCliente = ("Mensaje desde el cliente " + i);
                os.write(mensajeCliente.getBytes());
                System.out.println("Mensaje enviado");

                byte[] mensaje = new byte[30];
                is.read(mensaje);

                System.out.println("Mensaje recibido: " + new String(mensaje));
            }

            
            System.out.println("Mensaje enviado");

            System.out.println("Cerrando el socket cliente");

            clienteSocket.close();

            System.out.println("Terminado");

            }catch (IOException e) {
                    e.printStackTrace();
            }
    }
    
}
