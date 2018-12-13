
package ejercicio6;

public class Caja {
    private int dinero = 100;

    public Caja() {
    }

    public synchronized int getDinero() {
        return dinero;
    }

    public synchronized void setDinero(int dinero) {
        this.dinero = dinero;
    }
   
}
