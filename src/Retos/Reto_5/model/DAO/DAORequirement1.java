package Retos.Reto_5.model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;
import Retos.Reto_5.model.VO.VORequirement1;

public class DAORequirement1 {
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
    public ArrayList<VORequirement1> requeriment() throws SQLException{
        
        ArrayList<VORequirement1> result = new ArrayList<>();

        //Query 1
        String query = "SELECT SUM(Cantidad) AS total, Id_proyecto, pagado, proveedor "+
                       "FROM Compra "+ 
                       "WHERE Pagado = 'No' "+
                       "GROUP BY ID_Proyecto "+
                       "HAVING (total) > 50 "+ 
                       "ORDER BY ID_Proyecto";

        connectDB();
        Statement stmt = connect.createStatement();
        ResultSet rset = stmt.executeQuery(query);
        while (rset.next()) {
            VORequirement1 req = new VORequirement1();
            req.setTotal(rset.getInt("total"));
            req.setId_Proyecto(rset.getInt("Id_proyecto"));
            req.setPagado(rset.getString("pagado"));
            req.setProveedor(rset.getString("proveedor"));
            result.add(req);
        }
        
        return result;
    }
}

    
