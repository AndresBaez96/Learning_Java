package Retos.Reto_5.view;

import java.sql.SQLException;
import java.util.ArrayList;

import Retos.Reto_5.controller.Controller;
import Retos.Reto_5.model.VO.VORequirement1;
import Retos.Reto_5.model.VO.VORequirement2;
import Retos.Reto_5.model.VO.VORequirement3;

public class View {
    //Atributos
    public static final Controller controller = new Controller();
    
    //Vista query 1
    public static void requirement1() {
        try {
            ArrayList<VORequirement1> req = controller.query1();
            for (VORequirement1 i : req) {
                System.out.printf("%d %d %s %s %n", i.getTotal(),i.getId_Proyecto(), i.getPagado(), i.getProveedor() );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Vista query 2
    public static void requirement2() {
        try {
            ArrayList<VORequirement2> req = controller.query2();
            for (VORequirement2 i : req) {
                System.out.printf("%s %d %d %.1f %n", i.getInicio(),i.getFinanciable(), i.getEstrato(), i.getPorcentaje());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }      
    }

    // Vista query 3
    public static void requirement3() {
        try {
            ArrayList<VORequirement3> req = controller.query3();
            for (VORequirement3 i : req) {
                System.out.printf("%d %s %s %n", i.getId_Proyecto(),i.getPagado(), i.getClasificacion());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        requirement1();
    }
    
}
