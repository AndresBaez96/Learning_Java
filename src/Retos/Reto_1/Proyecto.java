package Retos.Reto_1;

public class Proyecto {
    //Atributos
    private int pTiempo;
    private double pMonto; 
    private double pInteres;
    //Métodos
    public Proyecto() {
        super();
    }

    public String compararProyectos(int pTiempo, double pMonto, double pInteres){
        double interesSimple = pMonto * pInteres * pTiempo;
        double interesCompuesto = pMonto * (Math.pow(1 + pInteres, pTiempo)- 1);
        double compararPresupuestos = interesCompuesto - interesSimple;

        if (compararPresupuestos >= 0) {
            return "Resultado "+ compararPresupuestos; 
        } else {
            return "Faltan datos para calcular la diferencia en el total de interes generados para el proyecto";
        }  
    }
}