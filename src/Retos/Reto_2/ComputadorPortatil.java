package Retos.Reto_2;

public class ComputadorPortatil extends Computador { // herencia: Computador --> ComputadorPortatil
    // Constantes
    private static final int EXTRA_BATTERY = 100000;
    private static final int EXTRA_CHARGER = 80000;

    // Atributos
    private int extraBattery;
    private int extraCharger;

    // Métodos constructores
    public ComputadorPortatil() {
        super();
        this.extraBattery = EXTRA_BATTERY;
        this.extraCharger = EXTRA_CHARGER;
    }

    public ComputadorPortatil(int battery) {
        super();
        this.extraBattery = battery;
        this.extraCharger = EXTRA_CHARGER;
    }

    public ComputadorPortatil(int battery, int charger) {
        super();
        this.extraBattery = battery;
        this.extraCharger = charger;
    }

    // Método
    public double calcularPrecio() {
        return super.calcularPrecio() + extraBattery + extraCharger;
    }
}
