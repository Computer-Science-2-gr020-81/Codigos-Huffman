package utils;

import models.Node;

public class Util {

    public static void printRepresentation(Node[][] matriz){
        for(int i = 0; i < matriz.length; i++){
            for(int j = 0; j < matriz[i].length;j++){
                System.out.print(matriz[i][j].getValue()+" ");       
            }
            System.out.println("\n");
        }
    }
}