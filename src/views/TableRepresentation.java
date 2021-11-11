package views;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
    

public class TableRepresentation extends JFrame {
    
    public final int ancho,alto;
    private JTable table;
    
    public TableRepresentation(){
        ancho = 800;
        alto = 430;
    }
    
    private void initComponents(String[][] rows,String[] colums){
        table = new JTable(rows, colums);
        table.setSize(new Dimension(1000, alto));
        TableColumn columna;
        columna=table.getColumnModel().getColumn(0);
        columna.setPreferredWidth(90);
        columna.setMaxWidth(90);
        columna.setMinWidth(90);
        table.setRowHeight(25);
        JScrollPane jsp = new JScrollPane(table);
        
        jsp.setSize(new Dimension(ancho, alto-35));
        jsp.setLocation(0, 0);
        jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(jsp);
        jsp.updateUI();
        
    }
    
    public void initTemplate(String[][] rows,String[] colums){
        setLayout(null);
        setTitle("Datos");
        setSize(new Dimension(ancho,alto));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        initComponents(rows,colums);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    
    }
    
}