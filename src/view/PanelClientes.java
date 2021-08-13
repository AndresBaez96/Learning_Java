package view;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import java.awt.GridLayout;

public class PanelClientes extends JPanel {
    
    // 1. Crear la relación o atributo
    private Interfaz interfaz;
    private JList<String> listaClientes;

    public PanelClientes(Interfaz i) {
        super();
        setLayout(new GridLayout());
        setBorder(new TitledBorder("Clients"));
        interfaz = i;
        String[] nombres = {"Juan ","Ana","Pedro"};

        // 2. Inicializar los atributos
        listaClientes = new JList<>();

        // 3. Modificar las propiedades

        // 4. Agregar al panel
        add(listaClientes);
    }

    public void updateListClients(String [] list) {
        listaClientes.setListData(list);
    }
    
}