package services;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class JavaMySQLService {
    private Connection connect;
    private String url;
    private String user;
    private String password;

    public JavaMySQLService() {
        super();
        getDBProperties();
        connectDB();
    }

    public Connection getConnect() {
        return connect;
    }

    public void getDBProperties() {
        try {
            InputStream ins = new FileInputStream("./data/db.properties");
            Properties prop = new Properties();
            prop.load(ins);
            url = prop.getProperty("url");
            user = prop.getProperty("user");
            password = prop.getProperty("password");
            ins.close();
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void connectDB() {
        try {
            connect = DriverManager.getConnection(url, user, password);
            Boolean valid = connect.isValid(50000);
            System.out.println(valid ? "Connected":"Failed");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    public void insertUser(String nombre) {
        String sql = "INSERT INTO `users`(`name`, `user_status`) VALUES ('"+nombre+"', 1)";
        try {
            Statement stmt = connect.createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    public ResultSet getUsersDB() {
        ResultSet rs = null;
        String sql = "SELECT * FROM users";
        try {
            Statement stmt = connect.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
}