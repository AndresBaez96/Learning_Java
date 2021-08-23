package Retos.Reto_4;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class Conector {
    private Connection connect;

    public Conector(String url) {
        super();
        connectDB(url);
    }

    public ResultSet getReq1DB() {
        String sql = "SELECT SUM(Cantidad) AS total, Id_proyecto, pagado, proveedor FROM Compra WHERE Pagado = 'No' GROUP BY ID_Proyecto HAVING (total) > 50 ORDER BY id_proyecto";
        return executeQuery(sql);
    }
    public ResultSet getReq2DB() {
        String sql = "SELECT Proyecto.Fecha_Inicio AS fechaInicio, Tipo.Financiable, Tipo.Estrato, Proyecto.Porcentaje_Cuota_Inicial * 100 AS porcetaje FROM Tipo, Proyecto WHERE Proyecto.ID_Tipo = Tipo.ID_Tipo AND Proyecto.Porcentaje_Cuota_Inicial > 0.2 AND Tipo.Estrato >= 5 AND Tipo.Financiable = 0 ORDER BY Fecha_Inicio";
        return executeQuery(sql);
    }
    public ResultSet getReq3DB() {
        String sql = "SELECT proyecto.ID_Proyecto, compra.pagado, proyecto.Clasificacion FROM materialconstruccion, compra, proyecto WHERE materialconstruccion.Importado = 'Si' AND compra.ID_MaterialConstruccion = materialconstruccion.ID_MaterialConstruccion AND proyecto.ID_Proyecto = compra.ID_Proyecto AND compra.Pagado IN ('NO', 'Parcialmente') AND proyecto.Clasificacion IN ('Apartamento', 'Apartaestudio') AND proyecto.Acabados = 'No' GROUP BY proyecto.ID_Proyecto";
        return executeQuery(sql);
    }
       
    public Connection connectDB(String url) { // Hace la conexión con la base de datos
        try {
            connect = DriverManager.getConnection(url, "root", "");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return connect;
    }

    public ResultSet executeQuery(String sql) {
        ResultSet rs = null;
        try {
            Statement stmt = connect.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
}
