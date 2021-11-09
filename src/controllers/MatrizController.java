package controllers;

import models.Nodo;
import views.MenuN;


public class MatrizController {
    private MenuN menu;
    private String[] arreglo;
    private String[] titulos = {"Simbolo", "Frecuencia", "Padre", "Tipo", "IZQ", "DER"};
    
    public MatrizController(MenuN menu){
        this.menu=menu;
    }
    
    public String[] getArreglo(){
        return arreglo;
    }
    
    public String[][] retornoMatriz(){
        Nodo<String>[][] matrizNodos= menu.getDataController().getTreeRepresentation();
        String[][] matrizString= new String[matrizNodos.length][matrizNodos[0].length+1];
        for(int i=0; i<matrizString.length;i++){
            for(int j=0;j<matrizString[0].length;j++){
                if(j==0){
                    matrizString[i][j]=titulos[i];
                }else{
                    matrizString[i][j]=matrizNodos[i][j-1].getValue();
                }
            }
        }
        arreglo= new String[matrizNodos[0].length+1];
        arreglo[0]=" ";
        for(int k=1;k<arreglo.length;k++){
            arreglo[k]=String.valueOf(k-1);
        }
        return matrizString;
    }

    
    
}
