package views;

import controllers.MatrizController;
import controllers.DataController;
import controllers.DrawTreeController;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MenuN extends JFrame {

    private DataController dataController;
    private MatrizController matrizController;
    private JTable matriz = new JTable();
    private JScrollPane dibujoMatriz = new JScrollPane();

    ;

    public MenuN() {
        initTemplate();
        dataController = new DataController(this);
        dataController.initListeners();
        matrizController = new MatrizController(this);
    }

    public JButton getBtnStart() {
        return this.Texto;
    }

    public String getInputMessage() {
        return jTextField1.getText();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        Texto = new javax.swing.JButton();
        Arbol = new javax.swing.JButton();
        Matriz = new javax.swing.JButton();
        btnResults = new javax.swing.JButton();
        lblResult = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Códigos de Huffman");

        jLabel2.setText("Digite el Mensaje (solo se aceptan caracteres de la 'a' a la 'z'):");

        Texto.setText("Procesar Entarda");
        Texto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextoActionPerformed(evt);
            }
        });

        Arbol.setText("Dibujar el Arbol");
        Arbol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ArbolActionPerformed(evt);
            }
        });

        Matriz.setText("Escribir Matriz");
        Matriz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MatrizActionPerformed(evt);
            }
        });

        btnResults.setText("Mostrar Resultados");

        javax.swing.GroupLayout PanelLayout = new javax.swing.GroupLayout(Panel);
        Panel.setLayout(PanelLayout);
        PanelLayout.setHorizontalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE)
                            .addComponent(jLabel1)
                            .addComponent(jTextField1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addComponent(Texto)
                        .addGap(55, 55, 55)
                        .addComponent(Arbol)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                        .addComponent(Matriz)
                        .addGap(76, 76, 76)))
                .addComponent(btnResults)
                .addGap(42, 42, 42))
        );
        PanelLayout.setVerticalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Texto)
                    .addComponent(Arbol)
                    .addComponent(Matriz)
                    .addComponent(btnResults))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        lblResult.setBorder(javax.swing.BorderFactory.createTitledBorder("Información"));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblResult, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblResult, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextoActionPerformed

    }//GEN-LAST:event_TextoActionPerformed

    private void ArbolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ArbolActionPerformed
        try {
            DrawTreeController drawController = new DrawTreeController();
            drawController.setTreeRepresentation((dataController.getTreeRepresentation()));
            drawController.setLetters(dataController.getLetters());
            drawController.generateTree();

            DrawTree draw = new DrawTree(drawController);
            draw.initTemplate();
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Asegurese de tener datos registrados en la aplicación", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_ArbolActionPerformed

    private void MatrizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MatrizActionPerformed
        try {
            String[][] rowData = matrizController.retornoMatriz();
            String[] colNames = matrizController.getArreglo();

            TableRepresentation table = new TableRepresentation();
            table.initTemplate(rowData, colNames);            
            
            /*dibujoMatriz = new JScrollPane();
            dibujoMatriz.setSize(Panel.getWidth() - 50, 430);
            dibujoMatriz.setLocation(20, 180);
            dibujoMatriz.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
            dibujoMatriz.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            
            matriz = new JTable();
            matriz.setModel(new DefaultTableModel(rowData, colNames));
            dibujoMatriz.setViewportView(matriz);
            
            matriz.setSize(new Dimension(dibujoMatriz.getWidth(), dibujoMatriz.getHeight()));
            matriz.setLocation(0, 0);

            Panel.add(dibujoMatriz);
            //dibujoMatriz.add(matriz);
            dibujoMatriz.updateUI();
            dibujoMatriz.repaint();
            Panel.updateUI();
            Panel.repaint();
            repaint();*/
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Asegurese de tener datos registrados en la aplicación", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_MatrizActionPerformed
    public DataController getDataController() {
        return dataController;
    }

    private void initTemplate() {
        initComponents();
        setTitle("Condigos de Huffman");
        setLocationRelativeTo(null);
        setResizable(false);
    }

    public JTable getTabla() {
        return matriz;
    }

    public JScrollPane getScroolPane() {
        return dibujoMatriz;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Arbol;
    private javax.swing.JButton Matriz;
    private javax.swing.JPanel Panel;
    private javax.swing.JButton Texto;
    private javax.swing.JButton btnResults;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblResult;
    // End of variables declaration//GEN-END:variables
}
