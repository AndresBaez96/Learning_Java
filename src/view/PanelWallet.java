package view;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class PanelWallet extends JPanel {
    private JLabel labelSaldo;
    private JLabel labelID;
    private JLabel labelHasLimit;
    private Interfaz interfaz;
    
    public PanelWallet(Interfaz i) {
        super();
        setBorder(new TitledBorder("Wallet Information"));
        setLayout(new GridLayout());
        interfaz = i;

        // 2. Inicializar los atributos
        JPanel panelAuxiliar = new JPanel();
        panelAuxiliar.setBorder(new EmptyBorder(20, 20, 10, 10));
        labelSaldo = new JLabel();
        labelID = new JLabel();
        labelHasLimit = new JLabel();

        // 3. Modificar las propiedades

        // 4. Agregar al panel
        panelAuxiliar.add(labelSaldo);
        panelAuxiliar.add(labelID);
        panelAuxiliar.add(labelHasLimit);
        add(panelAuxiliar); //Agrega panelAuxiliar a panelClientes
    }
}