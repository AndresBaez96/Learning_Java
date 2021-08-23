package Retos.Reto_5.model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;
import Retos.Reto_5.model.VO.VORequirement3;

public class DAORequirement3 {
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
    public ArrayList<VORequirement3> requeriment() throws SQLException{
        
        ArrayList<VORequirement3> result = new ArrayList<>();

        //Query 1
        String query = "SELECT proyecto.ID_Proyecto, compra.pagado, proyecto.Clasificacion "+ 
                       "FROM materialconstruccion, compra, proyecto "+ 
                       "WHERE compra.ID_MaterialConstruccion = materialconstruccion.ID_MaterialConstruccion "+ 
                            "AND proyecto.ID_Proyecto = compra.ID_Proyecto "+ 
                            "AND compra.pagado IN('No','Parcialmente') "+ 
                            "AND proyecto.Clasificacion IN ('Apartamento', 'Apartaestudio') "+
                            "AND proyecto.Acabados = 'No' "+
                            "AND materialconstruccion.Importado = 'Si' "+
                       "GROUP BY proyecto.ID_Proyecto";

        connectDB();
        Statement stmt = connect.createStatement();
        ResultSet rset = stmt.executeQuery(query);
        while (rset.next()) {
            VORequirement3 req = new VORequirement3();
            req.setId_Proyecto(rset.getInt("ID_Proyecto"));
            req.setPagado(rset.getString("pagado"));
            req.setClasificacion(rset.getString("Clasificacion"));
            result.add(req);
        }
        
        return result;
    }
}
