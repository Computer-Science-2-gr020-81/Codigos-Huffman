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
    
    public void generateTree(){
        //Creando primer nodo del arbol
        
        logicTree.insertarNodo(String.valueOf(treeRepresentation[1][treeRepresentation[0].length-1].getValue()));
        logicTree.getRaiz().setColIndex(treeRepresentation[1][treeRepresentation[0].length-1].getColIndex());
        //logicTree.getRaiz().setIzquierda(treeRepresentation[4][treeRepresentation[0].length-1]);
        //logicTree.getRaiz().setDerecha(treeRepresentation[5][treeRepresentation[0].length-1]);
        //Nodo<String> raiz = new Nodo<>(String.valueOf(treeRepresentation[1][treeRepresentation[0].length-1].getValue()));      
        
        for(int i = treeRepresentation[0].length-2;i > 0; i--){
            String father = treeRepresentation[2][i].getValue();
            String type = treeRepresentation[3][i].getValue();
            
            Nodo<String> matrizFather = treeRepresentation[1][Integer.parseInt(father)];
            matrizFather.setColIndex(treeRepresentation[1][Integer.parseInt(father)].getColIndex());
            Nodo<String> insercion = new Nodo<>(treeRepresentation[1][i].getValue());
            insercion.setColIndex(treeRepresentation[1][i].getColIndex());
            
             if(i > 0 && i < letters.size()){
                    insercion.setValue(letters.get(i));
                }
            
            if(Integer.parseInt(matrizFather.getDerecha().getValue().toString()) == i){ 
                logicTree.insertarNodoPorPosicion(insercion,matrizFather.getColIndex(),false);
            }else{
                logicTree.insertarNodoPorPosicion(insercion,matrizFather.getColIndex(),true);
            }
            
            
            
        }
    }
    
    
    
}
