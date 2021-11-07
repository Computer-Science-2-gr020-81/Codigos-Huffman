package utils;

import models.Nodo;
import java.util.Map;
import java.util.HashMap;

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
    
    public static void printArrayRepresentation(Nodo<String>[] frecuencias){
        for(Nodo<String> e : frecuencias){
            System.out.print( e.getValue()+ " ");
        }
        System.out.println("\n");
    }
}