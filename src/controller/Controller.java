package controller;

import model.Owner ;
import java.util.ArrayList;

public class Controller {
    
    private ArrayList<Owner> owners;

    public Controller() {
        super();
        owners = new ArrayList<>();
    }

    public ArrayList<Owner> getOwners() {
        return owners;
    }

    public void addOwner(String name) {
        Owner client = new Owner(name);
        owners.add(client);
    }

    public String listarClientes() {
        String listado = "";
        for (Owner user : owners) {
            listado += "Nombre: "+ user.getName() + "\n";
        }
        return listado;
    }

}

