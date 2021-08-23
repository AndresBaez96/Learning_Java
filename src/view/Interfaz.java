package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import controller.Controller;
import model.Wallet;
import java.awt.BorderLayout;

public class Interfaz extends JFrame {
    // 1. Crear la relación o atributo
    private PanelOpciones panelOpciones; // relación entre Interfaz con PanelOpciones
    private PanelClientes panelClientes;
    private PanelWallet panelWallet;
    private Controller controlador;

    public Interfaz() {
        super();
        setSize(650, 400); // Tamaño de la ventana que se abre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // La ventana se cierra cuando terminga el debug
        setTitle("Wallet");
         // se debe escribir la importación manualmente

        // 2. Inicializar los atributos
        panelOpciones = new PanelOpciones(this);
        panelClientes = new PanelClientes(this);
        panelWallet = new PanelWallet(this);
        controlador = new Controller();

        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new GridLayout());
        panelCentral.add(panelClientes);
        panelCentral.add(panelWallet);

        // 3. Modificar las propiedades

        // 4. Agregar al panel
        add(panelOpciones, BorderLayout.SOUTH); // Ubicaciones: North, South, West, East
        add(panelClientes, BorderLayout.CENTER);
        updateListClients();
    
    }

    public void addOwner(String name) {
        controlador.addOwner(name);
        updateListClients();
    }

    public String listarClientes() {
        return controlador.listarClientes();
    }
    public static void main(String[] args) {
        Interfaz interfaz = new Interfaz();
        interfaz.setVisible(true); // Interfaz visible

    }
    
    public void updateListClients() {
        panelClientes.updateListClients(controlador.getListClients());
    }
}
