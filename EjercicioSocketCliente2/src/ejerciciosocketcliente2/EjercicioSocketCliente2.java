
package ejerciciosocketcliente2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class EjercicioSocketCliente2 {

    /*
    2. Programa el cliente para que envíe una lista de 5 números al servidor. 
    El servidor los sumará y devolverá el resultado al cliente, que lo mostrará por pantalla.
    */
    
    public static void main(String[] args) {
        try{
            System.out.println("Creando socket cliente");
            Socket clienteSocket=new Socket();
            System.out.println("Estableciendo la conexión");

            InetSocketAddress addr=new InetSocketAddress("localhost",6666);
            clienteSocket.connect(addr);

            InputStream is = clienteSocket.getInputStream();
            OutputStream os= clienteSocket.getOutputStream();

            String numeros="5,2,24,14,7,";
            os.write(numeros.getBytes());
  
            System.out.println("Mensaje enviado");

            System.out.println("Cerrando el socket cliente");

            clienteSocket.close();

            System.out.println("Terminado");

            }catch (IOException e) {
                e.printStackTrace();
            }
    }
    
}
