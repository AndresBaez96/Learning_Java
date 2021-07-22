package Retos;

public class Proyecto {
    //Atributos
    private int pTiempo;
    private double pMonto; 
    private double pInteres;
    //Métodos
    public Proyecto() {
        super();
    }

    public String compararPresupuestos(int pTiempo, double pMonto, double pInteres){
        double interesSimple = pMonto * pInteres * pTiempo;
        double interesCompuesto = pMonto * (Math.pow(1 + pInteres, pTiempo)- 1);
        double compararPresupuestos = interesCompuesto - interesSimple;

        if (compararPresupuestos > 0) {
            return "La diferencia en el total de intereses generados para el proyecto, si escogemos entre evaluarlo a una tasa de interés Compuesto y evaluarlo a una tasa de interés Simple, asciende a la cifra de: $"+ compararPresupuestos; 
        } else {
            return "Faltan datos para calcular la diferencia en el total de interes generados para el proyecto";
        }
        

        
        
    }
}