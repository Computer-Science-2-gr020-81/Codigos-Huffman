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
         String[][] matrizString= new String[matrizNodos.length+1][matrizNodos[0].length+1];
         matrizString[0][0] = "";
         
         for(int x = 1; x < matrizNodos[0].length;x++){
             matrizString[0][x] = String.valueOf(x-1);
         }
         
         for(int i=1; i<matrizString.length;i++){
             for(int j=0;j<matrizString[0].length;j++){
                 if(j==0){
                     matrizString[i][j]=titulos[i-1];
                 }else{
                     matrizString[i][j]=matrizNodos[i-1][j-1].getValue();
                 
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
