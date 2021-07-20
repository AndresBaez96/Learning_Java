package Retos;

public class Proyecto {
    //Atributos
    int pTiempo;
     double pMonto; 
     double pInteres;
    //Métodos
    public Proyecto() {
        super();
    }

    public String compararPresupuestos(int pTiempo, double pMonto, double pInteres){
        try {
            double interesSimple = pMonto * pInteres * pTiempo;
            double interesCompuesto = pMonto * (Math.pow(1 + pInteres, pTiempo)- 1);
            double compararPresupuestos = interesCompuesto - interesSimple;
            return "La diferencia en el total de intereses generados para el proyecto, si escogemos entre evaluarlo a una tasa de interés Compuesto y evaluarlo a una tasa de interés Simple, asciende a la cifra de: $"+ compararPresupuestos;
        } catch (Exception e) {
            String a = "a";
            return a;
        }
        
    }
}