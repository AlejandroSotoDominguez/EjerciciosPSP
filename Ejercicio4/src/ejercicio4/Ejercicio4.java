
package ejercicio4;

public class Ejercicio4 extends Thread {
    
    public Ejercicio4(String nombre){
        super(nombre);
    }

    static class Par extends Thread{
        public void run(){
        int contador = 0;
        int contadorPar = 0;
        int contadorImpar = 0;

            for(int i=1; i<=1000; i++){
                if(i%2 == 0){
                    contadorPar += i;
                }
                
                
            }
            System.out.println(getName());
            System.out.println(contadorPar);     
        }
    }
     
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
    
    public static void main(String[] args) {
        new Par().start();
        new Impar().start();
        new Terminacion().start();
    }
    
}
