package Retos.Reto_2;

public class PrecioTotal {
    // Atributos
    private double totalPCs;
    private double totalLaptops;
    private double totalDesktops;
    private Computador [] computadores;

    // Método constructor
    public PrecioTotal(Computador []pComputadores) {
        super();
        this.computadores = pComputadores;
        
    }

    // Método 
    public void mostrarTotales() {
        // Inicialización atributos 
        totalPCs = 0;
        totalLaptops = 0;
        totalDesktops = 0;
        for (Computador computador : computadores) {
            if (computador instanceof Computador) {
                totalPCs += computador.calcularPrecio();
            }
            if (computador instanceof ComputadorPortatil) {
                totalLaptops += computador.calcularPrecio();
            }
            if (computador instanceof ComputadorMesa) {
                totalDesktops += computador.calcularPrecio();
            }
        }
        System.out.println("El precio total de los computadores es de "+ Math.round(totalPCs));
        System.out.println("La suma del precio de los Laptops es de "+ Math.round(totalLaptops));
        System.out.println("La suma del precio de los Desktops es de "+ Math.round(totalDesktops));
    }
}
