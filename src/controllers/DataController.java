package controllers;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;

import views.Menu;
import models.Node;
import utils.Util;

public class DataController {

    private Menu menu;
    private List<String> letters = new ArrayList<>();
    private Map<String,Integer> countLetters = new HashMap<>();
    private Node [][] treeRepresentation;

    public DataController(Menu menu){
        this.menu = menu;
    }

    public Node[][] getTreeRepresentation(){
        return treeRepresentation;
    }

    public void initListeners(){
        menu.getBtnStart().addActionListener((e) -> {
            String input = menu.getInputMessage();
            findAllLetters(input);
            initTreeRepresentation();
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
            int value = countLetters.get(key).intValue();
            countLetters.put(key,++value);
        }
        System.out.println(letters.toString());
        System.out.println(countLetters.toString());
    }

    private void initTreeRepresentation(){
        int sizeCol = (letters.size()*2)-1;
        this.treeRepresentation = new Node[5][sizeCol];

        //Guardando letras
        for(int x = 0; x < treeRepresentation[0].length;x++){
            Node temp = new Node();
            temp.setIsUsed(false);
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
                Node temp = new Node();
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
    }
    
}
