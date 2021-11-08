package controllers;

import models.Nodo;
import views.MenuN;


public class ControllerMatriz {
    private MenuN menu;
    private String[] arreglo;
    private String[] titulos={"Simbolo","Frecuencia","Padre","Tipo","IZQ","DER"};
    public ControllerMatriz(MenuN menu){
        this.menu=menu;
    }
    
    public String[] getArreglo(){
        return arreglo;
    }
    
    public String[][] retornoMatriz(){
         Nodo<String>[][] matrizNodos= menu.getDataController().getTreeRepresentation();
         String[][] matrizString= new String[matrizNodos.length+1][matrizNodos[0].length];
         for(int i=0; i<matrizNodos.length;i++){
             for(int j=0;j<matrizNodos[0].length;j++){
                 if(j==0){
                     matrizString[i][j]=titulos[i];
                 }else if(i==0){
                     matrizString[i][j]=String.valueOf(j);
                 }else{
                     matrizString[i][j]=matrizNodos[i][j].getValue();
                 
             }
         }
         }
         arreglo= new String[matrizNodos[0].length];
         for(int k=0;k<arreglo.length;k++){
             arreglo[k]=String.valueOf(k);
         }
         return matrizString;
    }
    
    
}
