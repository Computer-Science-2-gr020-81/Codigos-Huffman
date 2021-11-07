/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import javax.swing.JTable;
import models.Nodo;
import views.MenuN;

/**
 *
 * @author cesar
 */
public class ControllerMatriz {
    private MenuN menu;
    private String[] arreglo;
    public ControllerMatriz(MenuN menu){
        this.menu=menu;
    }
    public void pintarTabla(){
        JTable tabla= menu.getTabla();
        tabla.setSize(0, 0);
    }
    public String[][] retornoMatriz(){
         Nodo<String>[][] matrizNodos= menu.getDataController().getTreeRepresentation();
         String[][] matrizString= new String[matrizNodos.length][matrizNodos[0].length];
         for(int i=0; i<matrizNodos.length;i++){
             for(int j=0;j<matrizNodos[0].length;j++){
                 matrizString[i][j]=matrizNodos[i][j].getValue();
             }
         }
         arreglo= new String[matrizNodos[0].length];
         for(int k=0;k<arreglo.length;k++){
             arreglo[k]=String.valueOf(k);
         }
         return matrizString;
    }
    
    
}
