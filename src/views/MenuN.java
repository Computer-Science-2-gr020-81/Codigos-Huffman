package views;

import controllers.Controlador;
import controllers.ControllerMatriz;
import controllers.DataController;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import models.Arbol;


public class MenuN extends javax.swing.JFrame {
    
    private DataController dataController;
    private ControllerMatriz matrizController;
    private JTable matriz;
    private JScrollPane dibujoMatriz;

   
    public MenuN() {
        initTemplate();
        dataController = new DataController(this);
        dataController.initListeners();
        
        matrizController = new ControllerMatriz(this);
    }
    
    public JButton getBtnStart(){
        return this.Texto;
    }
    
    public String getInputMessage(){
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Códigos de Huffman");

        jLabel2.setText("Digite el Mensaje (solo se aceptan caracteres de la 'a' a la 'z'):");

        Texto.setText("Enviar Mensaje");
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

        javax.swing.GroupLayout PanelLayout = new javax.swing.GroupLayout(Panel);
        Panel.setLayout(PanelLayout);
        PanelLayout.setHorizontalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLayout.createSequentialGroup()
                        .addComponent(Texto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addComponent(Arbol)
                        .addGap(72, 72, 72)
                        .addComponent(Matriz)
                        .addGap(10, 10, 10)))
                .addContainerGap(311, Short.MAX_VALUE))
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
                    .addComponent(Matriz))
                .addContainerGap(459, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addComponent(Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextoActionPerformed
        
    }//GEN-LAST:event_TextoActionPerformed

    private void ArbolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ArbolActionPerformed
        //PATRON MVC
        Arbol objArbol = new Arbol(); //MODELO
        Lienzo objLienzo = new Lienzo(); //VISTA
        Controlador objControlador = new Controlador(objLienzo, objArbol); //CONTROLADOR
        //= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
        //INSERTAR Y PINTAR ARBOL
        objArbol.insert(7);
        objArbol.insert(2);
        objArbol.insert(9);
        objArbol.insert(5);
        objArbol.insert(0);
        objArbol.insert(10);
        objControlador.iniciar();
        //= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
        //MOSTRAR LIENZO EN UNA VENTANA TODO
        JFrame ventana = new JFrame();
        ventana.getContentPane().add(objLienzo);
     //   ventana.setDefaultCloseOperation(3);
        ventana.setSize(600, 600);
        ventana.setVisible(true);
    }//GEN-LAST:event_ArbolActionPerformed

    private void MatrizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MatrizActionPerformed
        try{
            try {
            String[][] rowData = matrizController.retornoMatriz();
            String[] colNames = matrizController.getArreglo();
            
            dibujoMatriz = new JScrollPane();
            dibujoMatriz.setSize(Panel.getWidth()-50, 430);
            dibujoMatriz.setLocation(20, 180);
            dibujoMatriz.setBorder(BorderFactory.createLineBorder(Color.RED));
            dibujoMatriz.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
            dibujoMatriz.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            Panel.add(dibujoMatriz);

            matriz = new JTable(rowData, colNames);
            matriz.setSize(new Dimension(dibujoMatriz.getWidth(),dibujoMatriz.getHeight()));
            for(int i=0;i<matrizController.getArreglo().length;i++){
                TableColumn columna;
                columna=matriz.getColumnModel().getColumn(i);
                if(i==0){
                    columna.setPreferredWidth(80);
                    columna.setMaxWidth(80);
                    columna.setMinWidth(80);
                    matriz.setRowHeight(25);
                }else{
                    columna.setPreferredWidth(30);
                    columna.setMaxWidth(30);
                    columna.setMinWidth(30);
                    matriz.setRowHeight(25);
                }
                
                
            }
            matriz.setLocation(0, 0);
            dibujoMatriz.add(matriz);
            dibujoMatriz.repaint();
            repaint();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Asegurese de tener datos registrados en la aplicación", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
             
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error:  " + e.getMessage());
        }
    }//GEN-LAST:event_MatrizActionPerformed
    

    public DataController getDataController(){
        return dataController;
    }
    private void initTemplate(){
        initComponents();
        setTitle("Condigos de Huffman");
        setLocationRelativeTo(null);
        setResizable(false);
        
    }
    
    public JTable getTabla(){
        return matriz;
    }
    
    public JScrollPane getScroolPane(){
        return dibujoMatriz;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Arbol;
    private javax.swing.JButton Matriz;
    private javax.swing.JPanel Panel;
    private javax.swing.JButton Texto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
