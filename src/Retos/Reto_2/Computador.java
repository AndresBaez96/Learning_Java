package Retos.Reto_2;

public class Computador {
    // Constantes
    public static final double PRECIO_BASE = 1500000;
    public static final double PRECIO_MOUSE = 60000;
    private static final double PRECIO_HEADPHONE = 110000;
    
    // Atributos
    private double mouse;
    private double headphone;   
    private double precioBase;

    // Métodos constructores
    public Computador() {
        super();
        this.precioBase = PRECIO_BASE; 
        this.mouse = PRECIO_MOUSE;
        this.headphone = PRECIO_HEADPHONE;   
    }

    public Computador(double price, double headphone) {
        super();
        this.precioBase = price; 
        this.mouse = PRECIO_MOUSE;
        this.headphone = headphone;
    }

    public Computador(double price, double headphone, double mouse) {
        super();
        this.precioBase = price; 
        this.mouse = mouse;
        this.headphone = headphone;
    }

    // Método
    public double calcularPrecio() {
        return mouse + headphone + precioBase;
    }
}
