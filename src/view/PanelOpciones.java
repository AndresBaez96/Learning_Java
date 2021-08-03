package view;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;

public class PanelOpciones extends JPanel implements ActionListener {

    public static final String BTN_SALDO = "Balance inquiry";
    public static final String BTN_CARGAR = "Deposit";
    public static final String BTN_CREAR = "Create user";
    public static final String BTN_LISTAR = "List"; 
    
    // 1. Crear la relación o atributo
    private JButton btnSaldo;
    private JButton btnCargar;
    private JButton btnCrear;
    private JButton btnListar;

    private Interfaz interfaz;

    public PanelOpciones(Interfaz inter) {
        super();
        setLayout(new GridLayout(1, 3)); // Organización botones (filas, columnas) 
        setBorder(new TitledBorder("Options"));
        interfaz = inter;

        // 2. Inicializar los atributos
        btnSaldo = new JButton(BTN_SALDO);
        btnCargar = new JButton(BTN_CARGAR);
        btnCrear = new JButton(BTN_CREAR);
        btnListar = new JButton(BTN_LISTAR);

        // 3. Modificar las propiedades
        btnCargar.setActionCommand(BTN_CARGAR);
        btnSaldo.setActionCommand(BTN_SALDO);
        btnCrear.setActionCommand(BTN_CREAR);
        btnListar.setActionCommand(BTN_LISTAR);

        btnCargar.addActionListener(this);
        btnSaldo.addActionListener(this);
        btnCrear.addActionListener(this);
        btnListar.addActionListener(this);

        // 4. Agregar al panel
        add(btnCargar);
        add(btnSaldo);
        add(btnCrear);
        add(btnListar);

    }

    public void addOwner() {
        String name = JOptionPane.showInputDialog(interfaz, "Write the user's name");
        if (name != null && !name.equalsIgnoreCase("")) {
            interfaz.addOwner(name);
        } else {
            JOptionPane.showMessageDialog(interfaz, "Write a name", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void listarClientes() {
        JOptionPane.showConfirmDialog(interfaz, interfaz.listarClientes());
    }

    @Override
    public void actionPerformed(ActionEvent event) { // Recibe las acciones/eventos del usuario con la interfaz
        
        if (event.getActionCommand().equals(BTN_CARGAR)) {
            JOptionPane.showMessageDialog(interfaz, "Deposit"); // Ventana pequeña para mostrar un mensaje/valores/etc (clase padre: null/this, mensaje)
            //System.out.println("Deposit");
        } else if (event.getActionCommand().equals(BTN_SALDO)){
            JOptionPane.showMessageDialog(interfaz, "Balance", "Balance inquiry", JOptionPane.WARNING_MESSAGE); // Clase padre, mensaje, titulo, tipo de mensaje (icono)
            //System.out.println("Balance");
        } else if (event.getActionCommand().equals(BTN_CREAR)){
            addOwner();
        } else if (event.getActionCommand().equals(BTN_LISTAR)){
            listarClientes();
        }
    }
}
