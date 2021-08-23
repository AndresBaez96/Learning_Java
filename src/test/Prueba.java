package test;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

public class Prueba extends JFrame implements ActionListener {
    
    public static final String QUERY_1 = "Query 1";
    public static final String QUERY_2 = "Query 2";
    public static final String QUERY_3 = "Query 3";

    private JScrollPane panel;
    private JButton query1, query2;
    private JPanel panelButtons;
    private JTable table;

    public Prueba() {
        super();

        setTitle("Test");
        setSize(500,300);
        setResizable(false);  // No se modifica el tamaño
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.panel = new JScrollPane();
        panel.setBorder(new TitledBorder("Test"));
        add(panel, BorderLayout.CENTER);
        
        this.query1 = new JButton(QUERY_1);
        this.query2 = new JButton(QUERY_2);
        query1.addActionListener(this);
        query2.addActionListener(this);

        this.panelButtons = new JPanel();
        panelButtons.setLayout(new GridLayout());
        panelButtons.setBorder(new TitledBorder("Queries"));
        panelButtons.add(query1);
        panelButtons.add(query2);
        add(panelButtons, BorderLayout.SOUTH);

    }

    public JTable dataQuery1() {
        JTable table = new JTable();
        String [][] array = {
                            {"1","Andrés"},
                            {"2","Felipe"},
                            {"3","Luis"},
                            {"4","Eduardo"},
                            {"5","Luz"},
                            {"6","Mery"},
                            {"7","Maria"},
                            {"8","Paula"},};
        String [] header = {"ID", "Nombre"};
        table = new JTable(array,header);
        return table;
    }

    public JTable dataQuery2() {
        JTable table = new JTable();
        String [][] array = {
                            {"1","otroAndrés"},
                            {"2","otroFelipe"},
                            {"3","otroLuis"},
                            {"4","otroEduardo"},
                            {"5","otroLuz"},
                            {"6","otroMery"},
                            {"7","otroMaria"},
                            {"8","otroPaula"},};
        String [] header = {"ID", "Nombre"};
        table = new JTable(array,header);
        return table;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getActionCommand().equals(QUERY_1)) {
            this.table = dataQuery1();
            panel.add(table);
            panel.setViewportView(table);
        } else if (event.getActionCommand().equals(QUERY_2)) {
            this.table = dataQuery2();
            panel.add(table);
            panel.setViewportView(table);
        }
          
    }

    public static void main(String[] args) {
        Prueba test = new Prueba();
        test.setVisible(true);
    }
}



