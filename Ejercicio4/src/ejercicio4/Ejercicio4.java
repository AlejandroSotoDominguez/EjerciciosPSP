
package ejercicio4;

public class Ejercicio4 extends Thread {
    
    public Ejercicio4(String nombre){
        super(nombre);
    }

    // Hilo que suma los números pares de 1 a 1000
    static class Par extends Thread{
        public void run(){
        int contador = 0;
        int contadorPar = 0;
        int contadorImpar = 0;
            // Recorremos el bucle y vamos acumulando la suma
            for(int i=1; i<=1000; i++){
                if(i%2 == 0){
                    contadorPar += i;
                }
                
                
            }
            System.out.println(getName());
            System.out.println(contadorPar);     
        }
    }
    
    // Hilo que suma los números impares
    static class Impar extends Thread{
        public void run(){
        int contadorImpar = 0;

        
        for(int i=1; i<=1000; i++){
            if(i%2!=0){
                contadorImpar += i;
            }    
        }
        System.out.println(getName());
        System.out.println(contadorImpar);
        }
    }  
    
    // Hilo que suma los números que terminan en 2 y en 3
    static class Terminacion extends Thread{
        int contadorTer=0;
        
        public void run(){
            for(int i=1; i<=1000; i++){
                if(i%10==2 || i%10==3){
                    contadorTer += i;
                }    
            }
            System.out.println(getName());
            System.out.println(contadorTer);           
        }
    }
    
    // Ejecutamos 3 hilos que se ejecutaran al mismo tiempo
    public static void main(String[] args) {
        new Par().start();
        new Impar().start();
        new Terminacion().start();
    }
    
}
