package Retos.Reto_5.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import Retos.Reto_5.model.DAO.DAORequirement1;
import Retos.Reto_5.model.DAO.DAORequirement2;
import Retos.Reto_5.model.DAO.DAORequirement3;
import Retos.Reto_5.model.VO.VORequirement1;
import Retos.Reto_5.model.VO.VORequirement2;
import Retos.Reto_5.model.VO.VORequirement3;

public class Controller {
    // Atributos
    private DAORequirement1 requirement1;
    private DAORequirement2 requirement2;
    private DAORequirement3 requirement3;

    public Controller() {
        super();
        this.requirement1 = new DAORequirement1();
        this.requirement2 = new DAORequirement2();
        this.requirement3 = new DAORequirement3();
    }

    public ArrayList<VORequirement1> query1() throws SQLException {
        return requirement1.requeriment();
    }

    public ArrayList<VORequirement2> query2() throws SQLException {
        return requirement2.requeriment();
    }    

    public ArrayList<VORequirement3> query3() throws SQLException {
        return requirement3.requeriment();
    }
}
