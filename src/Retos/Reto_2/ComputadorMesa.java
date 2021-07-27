package Retos.Reto_2;

public class ComputadorMesa extends Computador { // herencia: Computador --> ComputadorMesa
    // Constantes
    private static final int CAMERA = 10;
    private static final int KEYBOARD = 10;

    // Atributos
    private int camera;
    private int keyboard;

    // Métodos constructores
    public ComputadorMesa() {
        super();
        this.camera = CAMERA;
        this.keyboard = KEYBOARD;
    }

    public ComputadorMesa(int camera) {
        super();
        this.camera = camera;
        this.keyboard = KEYBOARD;
    }

    public ComputadorMesa(int camera, int keyboard) {
        super();
        this.camera = camera;
        this.keyboard = keyboard;
    }

    // Método
    public double calcularPrecio() {
        return super.calcularPrecio() + camera + keyboard;
    }
  
}
