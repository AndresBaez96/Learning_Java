package Retos.Reto_5.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

import Retos.Reto_5.controller.Controller;
import Retos.Reto_5.model.VO.VORequirement1;
import Retos.Reto_5.model.VO.VORequirement2;
import Retos.Reto_5.model.VO.VORequirement3;

public class Interfaz extends JFrame implements ActionListener {

    // Constantes
    public static final String QUERY_1 = "Query 1";
    public static final String QUERY_2 = "Query 2";
    public static final String QUERY_3 = "Query 3";

    // Atributos
    private Controller controller;
    private JLabel label, signature;
    private JPanel panelLabel;
    private JScrollPane panel;
    private JButton query1, query2, query3;
    private JPanel panelButtons;
    private JTable table;

    public Interfaz() {
        super();
        // Frame
        setTitle("Challenge 5");
        setSize(500,400);
        setResizable(false);  // No se modifica el tamaño
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Label
        this.label = new JLabel();
        this.signature = new JLabel();

        // Panel para labels
        this.panelLabel = new JPanel();
        panelLabel.setLayout(new GridLayout());
        panelLabel.setBorder(new TitledBorder("Query Info"));
        add(panelLabel, BorderLayout.NORTH);

        // ScrollPane de las tablas
        this.panel = new JScrollPane();
        panel.setBorder(new TitledBorder("Data Info"));
        add(panel, BorderLayout.CENTER);
        
        // Botones
        this.query1 = new JButton(QUERY_1);
        this.query2 = new JButton(QUERY_2);
        this.query3 = new JButton(QUERY_3);
        query1.addActionListener(this);
        query2.addActionListener(this);
        query3.addActionListener(this);

        // Panel de botones
        this.panelButtons = new JPanel();
        panelButtons.setLayout(new GridLayout());
        panelButtons.setBorder(new TitledBorder("Queries"));
        panelButtons.add(query1);
        panelButtons.add(query2);
        panelButtons.add(query3);
        add(panelButtons, BorderLayout.SOUTH);
    }

    // Generación Tabla Query 1
    public JTable dataQuery1() {
        ArrayList<VORequirement1> list = new ArrayList<VORequirement1>();
        this.controller = new Controller();
        try {
            list = controller.query1();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String array[][] = new String [list.size()][4];
        for (int i = 0; i < list.size(); i++) {
            array[i][0] = String.valueOf(list.get(i).getTotal());
            array[i][1] = String.valueOf(list.get(i).getId_Proyecto());
            array[i][2] = list.get(i).getPagado();
            array[i][3] = list.get(i).getProveedor();
        }
        String [] header = {"Total", "ID Proyecto", "Pagado", "Proveedor"};
        this.table = new JTable(array,header);
        return table;
    }

    // Generación Tabla Query 2
    public JTable dataQuery2() {
        ArrayList<VORequirement2> list = new ArrayList<VORequirement2>();
        this.controller = new Controller();
        try {
            list = controller.query2();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String array[][] = new String [list.size()][4];
        for (int i = 0; i < list.size(); i++) {
            array[i][0] = String.valueOf(list.get(i).getInicio());
            array[i][1] = String.valueOf(list.get(i).getFinanciable());
            array[i][2] = String.valueOf(list.get(i).getEstrato());
            array[i][3] = String.valueOf(list.get(i).getPorcentaje());
        }
        String [] header = {"Fecha", "Financiable", "Estrato", "Porcentaje [%]"};
        this.table = new JTable(array,header);
        return table;
    }

    public JTable dataQuery3() {
        ArrayList<VORequirement3> list = new ArrayList<VORequirement3>();
        this.controller = new Controller();
        try {
            list = controller.query3();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String array[][] = new String [list.size()][3];
        for (int i = 0; i < list.size(); i++) {
            array[i][0] = String.valueOf(list.get(i).getId_Proyecto());
            array[i][1] = list.get(i).getPagado();
            array[i][2] = list.get(i).getClasificacion();
        }
        String [] header = {"ID Proyecto", "Pagado", "Clasificacion"};
        this.table = new JTable(array,header);
        return table;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getActionCommand().equals(QUERY_1)) {
            // Información query
            this.label.setText("<html><body>- Proyectos no pagados"+ 
                               "<br>- Suma de Total mayor a 50"+
                               "<br>- Agrupar por ID Proyecto </body></html>");
            panelLabel.add(label);

            //Información tabla
            this.table = dataQuery1();
            panel.add(table);
            panel.setViewportView(table);

            //Firma
            this.signature.setText("<html><body><i>Developed by:"+ 
                                   "<br><i> Andrés Báez </body></html>");
            panelButtons.add(signature, BorderLayout.EAST);
        } else if (event.getActionCommand().equals(QUERY_2)) {
            // Información query
            this.label.setText("<html><body>- Proyectos de los útlimos años (Del más antiguo al más reciente)"+ 
                               "<br>- Estrato mayor o igual a 5"+
                               "<br>- No financiables (1 = Financiable, 0 - No financiable)"+
                               "<br>- Porcentaje de cuota inicial mayor al 30 % </body></html>");
            panelLabel.add(label);

            //Información tabla
            this.table = dataQuery2();
            panel.add(table);
            panel.setViewportView(table);

            //Firma
            this.signature.setText("<html><body><i>Developed by:"+ 
                                   "<br><i> Andrés Báez </body></html>");
            panelButtons.add(signature, BorderLayout.EAST);
        } else if (event.getActionCommand().equals(QUERY_3)) {
            // Información query
            this.label.setText("<html><body>- Proyectos de apartamentos/apartaestudios"+ 
                               "<br>- No pagados o pagados parcialmente"+
                               "<br>- Dentro de sus compras deben tener material de construcción importado"+
                               "<br>- Proyectos que no se entregan acabados");
            panelLabel.add(label);

            //Información tabla
            this.table = dataQuery3();
            panel.add(table);
            panel.setViewportView(table);

            //Firma
            this.signature.setText("<html><body><i>Developed by:"+ 
                                   "<br><i> Andrés Báez </body></html>");
            panelButtons.add(signature, BorderLayout.EAST);
        }
        
    }

    public static void main(String[] args) {
        Interfaz interfaz = new Interfaz();
        interfaz.setVisible(true);
    }
}