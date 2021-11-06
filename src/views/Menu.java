package views;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Dimension;

import utils.GraphicConstants;

import controllers.DataController;

public class Menu extends JFrame {

    private final int WIDTH,HEIGHT;
    private DataController dataController;
    private JButton btnStart;
    private JTextField txtInput;
    private JLabel titleEntrada;

    public Menu(){
        WIDTH = 1000;
        HEIGHT = 800;
        dataController = new DataController(this);
    }

    public JButton getBtnStart(){
        return btnStart;
    }

    public String getInputMessage(){
        return txtInput.getText();
    }

    private void initComponents(){
        btnStart = new JButton("Iniciar");
        btnStart.setSize(new Dimension(150,30));
        btnStart.setLocation((getWidth() - btnStart.getWidth())/2, 700);
        btnStart.setFont(GraphicConstants.generalBoldFont);
        btnStart.setFocusable(false);
        add(btnStart);

        txtInput = new JTextField();
        txtInput.setSize(new Dimension(400,30));
        txtInput.setLocation((getWidth() - txtInput.getWidth())/2, 100);
        txtInput.setFont(GraphicConstants.generalBoldFont);
        txtInput.setHorizontalAlignment(JTextField.CENTER);
        add(txtInput);

        titleEntrada = new JLabel("Mensaje a crifrar:");
        titleEntrada.setSize(new Dimension(150,30));
        titleEntrada.setLocation((getWidth() - titleEntrada.getWidth())/2 - 350, 100);
        titleEntrada.setFont(GraphicConstants.generalBoldFont);
        add(titleEntrada);
    }

    private void initTemplate(){
        setLayout(null);
        setSize(new Dimension(WIDTH,HEIGHT));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Codigos Hoffman");
        setLocationRelativeTo(null);
        initComponents();
        setVisible(true);
    }

    public void start(){
        initTemplate();
        dataController.initListeners();
    }
    
}
