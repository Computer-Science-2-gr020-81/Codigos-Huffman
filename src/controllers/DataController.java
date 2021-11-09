package controllers;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import javax.swing.JOptionPane;

import views.MenuN;
import models.Nodo;

public class DataController {

    private MenuN menu;
    private List<String> letters = new ArrayList<>();
    private Map<String, Integer> countLetters = new HashMap<>();
    private Nodo<String>[][] treeRepresentation;

    public DataController(MenuN menu) {
        this.menu = menu;
    }
    
    public List<String> getLetters(){
        return letters;
    }

    public Nodo<String>[][] getTreeRepresentation() {
        return treeRepresentation;
    }
    
    private void resetFields(){
        letters = new ArrayList<>();
        countLetters = new HashMap<>();
    }

    public void initListeners(){
        menu.getBtnStart().addActionListener((e)  -> {
            String input = menu.getInputMessage();
            if(input.equals("") || input.equals(" ")){
                JOptionPane.showMessageDialog(null, "La cadena no puede ser vacia", "Error",JOptionPane.ERROR_MESSAGE);
            }else{
                resetFields();
                findAllLetters(input);
                initTreeRepresentation();
                startProcces();
            }
           
        });
    }

    private void findAllLetters(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!letters.contains(input.substring(i, i + 1))) {
                letters.add(input.substring(i, i + 1));
            }
        }
        Collections.sort(letters);
        letters.forEach((e) -> {
            countLetters.put(e, 0);
        });
        for (int j = 0; j < input.length(); j++) {
            String key = input.substring(j, j + 1);
            int value = countLetters.get(key);
            countLetters.put(key, ++value);
        }
    }

    public void findHuffmanCode(Nodo nodeList, String code){
        if(nodeList != null){
            if(nodeList.getLeftNode() == null && nodeList.getRightNode() == null){
                nodeList.setHuffmanCode(code);
                System.out.println("Node: "+nodeList.getValue());
                System.out.println("code: "+code);
            }else{  
                findHuffmanCode(nodeList.getLeftNode(),code+0);
                findHuffmanCode(nodeList.getRightNode(),code+1);
            }
        }
    }
    
    private void initTreeRepresentation() {
        int sizeCol = (letters.size() * 2) - 1;
        this.treeRepresentation = new Nodo[6][sizeCol];

        //Guardando letras
        for (int x = 0; x < treeRepresentation[0].length; x++) {
            Nodo<String> temp = new Nodo();
            temp.setWasUsed(false);
            if (x < letters.size()) {
                temp.setValue(letters.get(x));
            } else {
                temp.setValue("");
            }
            temp.setColIndex(x);
            treeRepresentation[0][x] = temp;
        }

        //Inicializando el resto en 0
        for (int i = 1; i < treeRepresentation.length; i++) {
            for (int j = 0; j < treeRepresentation[i].length; j++) {
                Nodo<String> temp = new Nodo();
                if (i == 1 && j < letters.size()) {
                    Integer value = this.countLetters.get(treeRepresentation[i - 1][j].getValue());
                    temp.setValue(String.valueOf(value));
                } else {
                    temp.setValue("0");
                }
                temp.setColIndex(j);
                treeRepresentation[i][j] = temp;
            }
        }
    }

    private Nodo<String> findMinFrequencie(Nodo<String>[] frecuencias) {
        Integer min = Integer.MAX_VALUE;
        Integer indexMinValue = 0;
        Nodo<String> returnElement = new Nodo<>();
        for (int i = 0; i < frecuencias.length; i++) {
            Nodo<String> frecuencia = frecuencias[i];
            if (Integer.parseInt(frecuencia.getValue()) < min && !frecuencia.getValue().equals("0") && !frecuencia.isWasUsed()) {
                min = Integer.parseInt(frecuencia.getValue());
                indexMinValue = i;
            }
        }
        frecuencias[indexMinValue].setWasUsed(true);
        returnElement.setValue(frecuencias[indexMinValue].getValue());
        returnElement.setColIndex(frecuencias[indexMinValue].getColIndex());
        return returnElement;
    }
   

    private void startProcces() {
        for (int i = letters.size(); i < treeRepresentation[0].length; i++) {
            Nodo<String>[] frecuencias = treeRepresentation[1];
            //Util.printArrayRepresentation(frecuencias);
            Nodo<String> f1 = findMinFrequencie(frecuencias);
            Nodo<String> f2 = findMinFrequencie(frecuencias);

            Integer valueCurrentNode = Integer.parseInt(f1.getValue()) + Integer.parseInt(f2.getValue());
            Nodo<String> newNode = new Nodo<>();
            newNode.setValue(String.valueOf(valueCurrentNode));
            newNode.setColIndex(i);
            
            //Estableciendo valor de los padres para las frecuencias
            Nodo<String> auxNode = new Nodo<>(newNode.getColIndex()+"");
            Nodo<String> firstType = new Nodo<>("1"),secondType = new Nodo<>("2");
            
            treeRepresentation[2][f1.getColIndex()] = auxNode;
            treeRepresentation[2][f2.getColIndex()] = auxNode;
            
            //Estableciendo hijo izquierdo y derecho
            if (Integer.parseInt(f1.getValue()) > Integer.parseInt(f2.getValue())) {
                f1.setValue(String.valueOf(f1.getColIndex()));
                f2.setValue(String.valueOf(f2.getColIndex()));
                
                newNode.setDerecha(f1);
                newNode.setIzquierda(f2);
                
                treeRepresentation[3][f1.getColIndex()] = secondType;
                treeRepresentation[3][f2.getColIndex()] = firstType;
                
            } else{
                f1.setValue(String.valueOf(f1.getColIndex()));
                f2.setValue(String.valueOf(f2.getColIndex()));
                
                treeRepresentation[3][f1.getColIndex()] = firstType;
                treeRepresentation[3][f2.getColIndex()] = secondType;
                
                
                newNode.setDerecha(f2);
                newNode.setIzquierda(f1);
            } 

            treeRepresentation[1][i] = newNode;
            treeRepresentation[4][i] = newNode.getIzquierda();
            treeRepresentation[5][i] = newNode.getDerecha();

        }

    }

}
