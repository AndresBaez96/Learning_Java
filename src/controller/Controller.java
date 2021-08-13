package controller;

import model.Owner ;
import services.JavaMySQLService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Controller {
    
    private ArrayList<Owner> owners;
    private JavaMySQLService dbService;

    public Controller() {
        super();
        owners = new ArrayList<>();
        dbService = new JavaMySQLService();
        checkDBConnection();
    }

    public void checkDBConnection() {
        try {
            if (dbService.getConnect().isValid(30)) {
               fillUsersData(dbService.getUsersDB()); 
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void fillUsersData(ResultSet rs) {
        try {
            while (rs.next()) {
                Owner owner = new Owner(rs.getString("name"));
                owners.add(owner);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Owner> getOwners() {
        return owners;
    }

    public void addOwner(String name) {
        Owner client = new Owner(name);
        dbService.insertUser(name);
        owners.add(client);
    }

    public String listarClientes() {
        String listado = "";
        for (Owner user : owners) {
            listado += "Nombre: "+ user.getName() + "\n";
        }
        return listado;
    }

    public String[] getListClients() {
        String[] lista = new String[owners.size()];
        for (int i = 0; i < lista.length; i++) {
            lista[i] = owners.get(i).toString();
        }
        return lista;
    }

}

