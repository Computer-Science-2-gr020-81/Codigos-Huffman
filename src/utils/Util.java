package utils;

import models.Nodo;
import java.util.Map;
import java.util.HashMap;
import javax.swing.JOptionPane;

public class Util {
    
    public static Map<String,Integer> indices = new HashMap<>();

    public static void printRepresentation(Nodo[][] matriz){
        for(int x = 0; x < matriz[0].length;x++){
            System.out.print(x+" ");  
        }
        System.out.println("\n");
        
        for(int i = 0; i < matriz.length; i++){
            for(int j = 0; j < matriz[i].length;j++){
                System.out.print(matriz[i][j].getValue()+" ");       
            }
            System.out.println("\n");
        }
    }
    
    public static void showRepresentation(Nodo[][] matriz){
        String result = "";
        for(int x = 0; x < matriz[0].length;x++){
           result += x+" ";  
        }
        result += "\n";
        
        for(int i = 0; i < matriz.length; i++){
            for(int j = 0; j < matriz[i].length;j++){
                    result += matriz[i][j].getValue()+" ";       
            }
            result += "\n";
        }
        JOptionPane.showMessageDialog(null, result);
    }
    
    public static void printArrayRepresentation(Nodo<String>[] frecuencias){
        for(Nodo<String> e : frecuencias){
            System.out.print( e.getValue()+ " ");
        }
        System.out.println("\n");
    }
    
    public static Nodo<String>[][] cloneTreeRepresentation(Nodo<String> [][] tree){
        Nodo<String>[][] treeCloned = new Nodo[tree.length][tree[0].length];
        for(int i = 0; i < tree.length;i++){
            for(int j = 0; j < tree[i].length;j++){
                Nodo<String> temp = new Nodo<>();
                temp.setColIndex(tree[i][j].getColIndex());
                temp.setValue(tree[i][j].getValue());
                temp.setWasUsed(tree[i][j].isWasUsed());
                temp.setDerecha(tree[i][j].getDerecha());
                temp.setIzquierda(tree[i][j].getIzquierda());
                treeCloned[i][j] = temp;
            }
        }
        
        return treeCloned;
        
    }
}