package Retos.Reto_5.model.VO;

import java.sql.Date;

public class VORequirement2 {
    // Atributos
    private Date inicio;
    private int financiable;
    private int estrato;
    private double porcentaje;
    
    // Funciones Getter & Setter
    public Date getInicio() {
        return inicio;
    }
    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }
    public int getFinanciable() {
        return financiable;
    }
    public void setFinanciable(int financiable) {
        this.financiable = financiable;
    }
    public int getEstrato() {
        return estrato;
    }
    public void setEstrato(int estrato) {
        this.estrato = estrato;
    }
    public double getPorcentaje() {
        return porcentaje;
    }
    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    

    
    
}