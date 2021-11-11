package views;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import controllers.DrawTreeController;

public class DrawTree extends JFrame {
    
    private Lienzo panel;
    private final int ancho, alto;
    private DrawTreeController drawTreeController;

    private JScrollPane jsp;

    public DrawTree(DrawTreeController drawTreeController) {
        ancho = 1200;
        alto = 500;
        this.drawTreeController = drawTreeController;
    }

    private void initComponents() {
        panel = new Lienzo();
        panel.setPreferredSize(new Dimension(1000, 1000));
        
        panel.setArbol(drawTreeController.getLogicTree());

        jsp = new JScrollPane(panel);
        jsp.setSize(new Dimension(ancho, alto-35));
        jsp.setLocation(0, 0);
        jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(jsp);

    }

    public Lienzo getPanel() {
        return panel;
    }
    
    public DrawTreeController getDrawTreeController(){
        return drawTreeController;
    }

    public void initTemplate() {
        setLayout(null);
        setTitle("Dibujo árbol");
        setSize(new Dimension(ancho, alto));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

    }
    
}
