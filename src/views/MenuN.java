package views;

import controllers.MatrizController;
import controllers.DataController;
import controllers.DrawTreeController;
import controllers.ResultsController;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class MenuN extends JFrame {

    private DataController dataController;
    private MatrizController matrizController;
    private JTable matriz = new JTable();
    private JScrollPane dibujoMatriz = new JScrollPane();
    private DrawTreeController drawController;
    private ResultsController resultsController;

    public MenuN() {
        initTemplate();
        dataController = new DataController();
        matrizController = new MatrizController(this);
        resultsController = new ResultsController();
        drawController = new DrawTreeController();
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Códigos de Huffman");

        jLabel2.setText("Digite el Mensaje (solo se aceptan caracteres de la 'a' a la 'z'):");

        Texto.setText("Procesar Entrada");
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
        btnResults.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResultsActionPerformed(evt);
            }
        });

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
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

        jLabel3.setText("Información:");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 882, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextoActionPerformed

        try {
            String input = getInputMessage();
            Pattern patron = Pattern.compile(".+[0-9]+.+");
            Matcher matcher = patron.matcher(input);
            boolean resultado = matcher.matches();
            if (resultado) {
                throw new Exception("no ingrese numeros");
            }

            dataController.startProcess(input);
            resultsController.setMessage(input);
            drawController.setTreeRepresentation((dataController.getTreeRepresentation()));
            drawController.setLetters(dataController.getLetters());
            drawController.generateTree();

            JOptionPane.showMessageDialog(null, "Mensaje procesado correctamente", "Salida", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_TextoActionPerformed

    private void ArbolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ArbolActionPerformed
        try {
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
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Asegurese de tener datos registrados en la aplicación", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_MatrizActionPerformed

    private void btnResultsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResultsActionPerformed
        try {
            jLabel4.setText("");
            jLabel5.setText("");
            jLabel6.setText("");
            resultsController.setTreeRepresentation(dataController.getTreeRepresentation());
            resultsController.setLogicTree(drawController.getLogicTree());
            resultsController.findHuffmanCode(drawController.getLogicTree().getRaiz(), "");
            resultsController.setLetters(dataController.getLetters());
            String result = resultsController.generateOutput();
            resultsController.setCode();
            resultsController.setNameCode();

            jLabel4.setText(result);
            jLabel5.setText(resultsController.getFinalName());
            jLabel6.setText(resultsController.getFinalCode());

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnResultsActionPerformed
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
