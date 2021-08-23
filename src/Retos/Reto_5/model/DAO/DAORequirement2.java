package Retos.Reto_5.model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;
import Retos.Reto_5.model.VO.VORequirement2;

public class DAORequirement2 {
    //Atributos
    private Connection connect;
    private String url;
    private String user;
    private String password;

    //Conexión Data Base
    public void connectDB() throws SQLException {
        //Datos de ubicación y acceso de la base de datos
        this.url = "jdbc:mysql://127.0.0.1:3306/proyectos";
        this.user = "root";
        this.password = "";

        //Conexión y mensaje de verificación 
        connect = DriverManager.getConnection(url, user, password);
        Boolean valid = connect.isValid(50000);
        System.out.println(valid ? "Connected":"");
    }
    
    //Obtención de datos en un ArrayList según query
    public ArrayList<VORequirement2> requeriment() throws SQLException{
        
        ArrayList<VORequirement2> result = new ArrayList<>();

        //Query 1
        String query = "SELECT Proyecto.Fecha_Inicio AS fechaInicio, Tipo.Financiable, Tipo.Estrato, Proyecto.Porcentaje_Cuota_Inicial * 100 AS Porcentaje "+ 
                       "FROM Tipo, Proyecto "+ 
                       "WHERE Proyecto.ID_Tipo = Tipo.ID_Tipo "+ 
                            "AND Proyecto.Porcentaje_Cuota_Inicial > 0.2 "+ 
                            "AND Tipo.Estrato >= 5 "+ 
                            "AND Tipo.Financiable = 0 "+ 
                       "ORDER BY Fecha_Inicio";

        connectDB();
        Statement stmt = connect.createStatement();
        ResultSet rset = stmt.executeQuery(query);
        while (rset.next()) {
            VORequirement2 req = new VORequirement2();
            req.setInicio(rset.getDate("fechaInicio"));
            req.setFinanciable(rset.getInt("Financiable"));
            req.setEstrato(rset.getInt("Estrato"));
            req.setPorcentaje(rset.getDouble("Porcentaje"));
            result.add(req);
        }
        
        return result;
    }
    
}