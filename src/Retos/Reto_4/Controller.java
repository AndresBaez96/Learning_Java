package Retos.Reto_4;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class Controller {
    private ArrayList<Req1> req1s;
    private ArrayList<Req2> req2s;
    private ArrayList<Req3> req3s;
    private Conector conectorDB;
    
    public Controller(String url) {
        super();
        req1s = new ArrayList<>();
        req2s = new ArrayList<>();
        req3s = new ArrayList<>();
        conectorDB = new Conector(url);
        
    }

    public void req1() {
        ResultSet db = conectorDB.getReq1DB();
        try {
            while (db.next()) {
                Req1 result = new Req1(db.getInt("total"), db.getInt("ID_proyecto"), db.getString("pagado"), db.getString("proveedor"));
                req1s.add(result);
            }
        } catch (SQLException e) {
            
            e.printStackTrace();
        }  
    }

    public void req2() {
        ResultSet db = conectorDB.getReq2DB();
        try {
            while (db.next()) {
                Req2 result = new Req2(db.getString("fechaInicio"),db.getInt("Financiable"),db.getInt("Estrato"),db.getDouble("porcetaje"));
                req2s.add(result);
            }
        } catch (SQLException e) {
            
            e.printStackTrace();
        }  
    }

    public void req3() {
        ResultSet db = conectorDB.getReq3DB();
        try {
            while (db.next()) {
                Req3 result = new Req3(db.getInt("ID_proyecto"),db.getString("pagado"),db.getString("Clasificacion"));
                req3s.add(result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }

    public void printReq1() {
        for (Req1 req1 : req1s) {
            System.out.println(req1);
        }
    }

    public void printReq2() {
        for (Req2 req2 : req2s) {
            System.out.println(req2);
        }
    }

    public void printReq3() {
        for (Req3 req3 : req3s) {
            System.out.println(req3);
        }
    }
}
