package controllers;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;

import views.MenuN;
import models.Nodo;
import utils.Util;

public class DataController {

    private MenuN menu;
    private List<String> letters = new ArrayList<>();
    private Map<String,Integer> countLetters = new HashMap<>();
    private Nodo<String> [][] treeRepresentation;

    public DataController(MenuN menu){
        this.menu = menu;
    }

    public Nodo<String>[][] getTreeRepresentation(){
        return treeRepresentation;
    }

    public void initListeners(){
        menu.getBtnStart().addActionListener((e) -> {
            String input = menu.getInputMessage();
            findAllLetters(input);
            initTreeRepresentation();
            startProcces();
        });
    }

    private void findAllLetters(String input){
        for(int i = 0; i < input.length(); i++){
            if(!letters.contains(input.substring(i,i+1))){
                letters.add(input.substring(i,i+1));
            }
        } 
        Collections.sort(letters);
        letters.forEach((e) -> {
            countLetters.put(e,0);
        });
        for(int j = 0; j < input.length(); j++){
            String key = input.substring(j,j+1);
            int value = countLetters.get(key);
            countLetters.put(key,++value);
        }
        System.out.println(letters.toString());
        System.out.println(countLetters.toString());
    }

    private void initTreeRepresentation(){
        int sizeCol = (letters.size()*2)-1;
        this.treeRepresentation = new Nodo[5][sizeCol];

        //Guardando letras
        for(int x = 0; x < treeRepresentation[0].length;x++){
            Nodo<String> temp = new Nodo();
            temp.setWasUsed(false);
            if(x < letters.size()){
                temp.setValue(letters.get(x));
            }else{
                temp.setValue("");
            }
            treeRepresentation[0][x] = temp;
        }

        //Inicializando el resto en 0
        for(int i = 1; i < treeRepresentation.length; i++){
            for(int j = 0; j < treeRepresentation[i].length;j++){
                Nodo<String> temp = new Nodo();
                if(i == 1 && j < letters.size()){
                    Integer value = this.countLetters.get(treeRepresentation[i-1][j].getValue());
                    temp.setValue(String.valueOf(value));
                }else{
                    temp.setValue("0");
                }
                treeRepresentation[i][j] = temp;
            }
        }
        System.out.println("\n");
        Util.printRepresentation(treeRepresentation);
        System.out.println("--------------------------------------------------");
    }
    
    private Nodo<String> findMinFrequencie(Nodo<String>[] frecuencias ){
        Integer min = Integer.MAX_VALUE;
        Integer indexMinValue = 0;
        for(int i=0; i < frecuencias.length; i++){
            Nodo<String> frecuencia = frecuencias[i];
            if(Integer.parseInt(frecuencia.getValue()) < min && !frecuencia.getValue().equals("0") && !frecuencia.isWasUsed()){
               min = Integer.parseInt(frecuencia.getValue());
               indexMinValue = i;
            }
        }
        frecuencias[indexMinValue].setWasUsed(true);
        return frecuencias[indexMinValue];
    }
    
    private void startProcces(){
        for(int i = letters.size(); i < treeRepresentation.length;i++){
            Nodo<String>[] frecuencias = treeRepresentation[1];
            //Util.printArrayRepresentation(frecuencias);
            Nodo<String> f1 = findMinFrequencie(frecuencias);
            Nodo<String> f2 = findMinFrequencie(frecuencias);
            
            
            
            System.out.println("f1: " + f1.getValue() + " f2: " + f2.getValue());
            
            
        }
        
    }
    
    
}
