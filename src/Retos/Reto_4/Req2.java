package Retos.Reto_4;

public class Req2 {
    private String fecha_Inicio;
    private int financiable;
    private int estrato;
    private double porcentaje;

    public Req2(String fecha_Inicio, int financiable, int estrato, double porcentaje) {
        super();
        this.fecha_Inicio = fecha_Inicio;
        this.financiable = financiable;
        this.estrato = estrato;
        this.porcentaje = porcentaje;
    }
    
    @Override
    public String toString() {
        return "Req2 [estrato=" + estrato + ", fechaInicio=" + fecha_Inicio + ", financiable=" + financiable + ", porcetaje=" + porcentaje + "]";
    }
}


