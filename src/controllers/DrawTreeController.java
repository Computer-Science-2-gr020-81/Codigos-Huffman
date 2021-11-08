package controllers;

import java.util.List;
import models.Nodo;
import views.DrawTree;
import models.Arbol;

public class DrawTreeController {
    
    private DrawTree menu;
    private Nodo<String>[][] treeRepresentation;
    private Arbol<String> logicTree;
    private List<String> letters;
    
    public DrawTreeController(){
        this.logicTree = new Arbol();
    }

    public List<String> getLetters() {
        return letters;
    }
    
    public Arbol getLogicTree(){
        return logicTree;
    }

    public void setLetters(List<String> letters) {
        this.letters = letters;
    }

    public Arbol drawTreeController() {
        return logicTree;
    } 
    
    public void setDrawTreeController(DrawTree menu){
        this.menu = menu;
    }

    public DrawTree getMenu() {
        return menu;
    }

    public void setMenu(DrawTree menu) {
        this.menu = menu;
    }

    public Nodo<String>[][] getTreeRepresentation() {
        return treeRepresentation;
    }

    public void setTreeRepresentation(Nodo<String>[][] treeRepresentation) {
        this.treeRepresentation = treeRepresentation;
    }
    
    private int findFrequency(int colIndex,String childFrequency,Nodo<String>[][] treeRepresentation){
        
        
        
        return 0;
    }
    
    private String parseValue(int colIndex,Nodo<String>[][] treeRepresentation){
        if(colIndex > 0 && colIndex < letters.size()){
            return treeRepresentation[1][colIndex].getValue();
        }else{
            return treeRepresentation[0][colIndex].getValue();
        }
        
    }
    
    public void generateTree(){
        //Creando primer nodo del arbol
        
        logicTree.insertarNodo(String.valueOf(treeRepresentation[1][treeRepresentation[0].length-1].getValue()));
        //logicTree.getRaiz().setIzquierda(treeRepresentation[4][treeRepresentation[0].length-1]);
        //logicTree.getRaiz().setDerecha(treeRepresentation[5][treeRepresentation[0].length-1]);
        //Nodo<String> raiz = new Nodo<>(String.valueOf(treeRepresentation[1][treeRepresentation[0].length-1].getValue()));      
        
        for(int i = treeRepresentation[0].length-2;i > 0; i--){
            String father = treeRepresentation[2][i].getValue();
            String type = treeRepresentation[3][i].getValue();
            
            System.out.println("Father: " + father);
            System.out.println("Type: " + type);
            
            String frequencyFather = treeRepresentation[1][Integer.parseInt(father)].getValue();
            System.out.println("Frequency Father: " + frequencyFather);
            
            Nodo<String> referenceFather = logicTree.returnNodo(frequencyFather);
            
            System.out.println("Nodo: "+referenceFather);
            
            if(type.equals("1")){
               referenceFather.setIzquierda(new Nodo<>(String.valueOf(treeRepresentation[1][i].getValue())));
               //referenceFather.setIzquierda(new Nodo<>(parseValue(i,treeRepresentation)));
            }else if(type.equals("2")){
               referenceFather.setDerecha(new Nodo<>(String.valueOf(treeRepresentation[1][i].getValue())));
               //referenceFather.setDerecha(new Nodo<>(parseValue(i,treeRepresentation)));
            }
            
            if( i == treeRepresentation[0].length-3){
                logicTree.setRaiz(referenceFather);
                System.out.println("Raiz para cambiar: " + logicTree.getRaiz());
            }else{
                logicTree.addChild(referenceFather);
            }

           
            
            /*if(referenceFather.getIzquierda() != null){
                raiz.insertar(new Nodo<>(),referenceFather.getIzquierda().getValue().toString());
            }
            
            if(referenceFather.getDerecha() != null){
                raiz.insertar(new Nodo<>(),referenceFather.getDerecha().getValue().toString());
            }*/
            
            
        }
    }
    
    
    
}
