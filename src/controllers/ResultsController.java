package controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import models.Arbol;
import models.Nodo;

public class ResultsController {

    private Arbol<String> logicTree;
    private String message;
    private List<String> letters;
    private Nodo<String>[][] treeRepresentation;

    public Arbol<String> getLogicTree() {
        return logicTree;
    }
    
    public void setLogicTree(Arbol<String> logicTree) {
        this.logicTree = logicTree;
    }

    public void setTreeRepresentation(Nodo<String>[][] treeRepresentation) {
        this.treeRepresentation = treeRepresentation;
    }  

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getLetters() {
        return letters;
    }

    public void setLetters(List<String> letters) {
        this.letters = letters;
    }
    
    private int getCompressedSize(){
        int acumulado = 0;
        
        for(int i = 0; i < treeRepresentation[0].length-1; i++){
            acumulado += Integer.valueOf(treeRepresentation[1][i].getValue());
        }
        return acumulado;
    }
    
    private String calculateLength(String code){
        String whiteSpaces = "";
        int size = code.length();
        for(int i = 0; i < size;i++){
            whiteSpaces += "<span> </span>";
        }
        return whiteSpaces;
    }
    
    public String generateOutput(){
        String result = "<html><body>";
        List<String> huffmanCode = new ArrayList<>();
        Map<String,String> codes = new HashMap<>();
        String finalCode = "";
        String finalName = "";
        
        //Codigo a cada letra
        result += "<p>";
        for (int i = 0; i < letters.size(); i++) {
            Nodo<String> nodo = logicTree.returnNodo(letters.get(i));
            result += "<span>"+letters.get(i) + "=" + nodo.getHuffmanCode() + "</span>&nbsp;&nbsp;";
            huffmanCode.add(nodo.getHuffmanCode());
            if(!codes.containsKey(letters.get(i))){
                codes.put(letters.get(i), nodo.getHuffmanCode());
            }
        }
        
        result += "</p><br>";
        //Datos
        int originalSize = (message.length())*8;
        result += "<p>Sin comprimir "+message.length()+" * "+ 8 +" = "+originalSize+" bits</p>";
        
        result += "<br>";
        
        int newSize = getCompressedSize();
        result += "<p>Comprimido "+newSize+" bits</p>";

        result += "<br>";
        
        double codificado = newSize*(100)/originalSize;
        double ahorro = 100 - codificado;
        
        result += "<p>Codificado: "+codificado+"%"+" de espacio.Ahorro: " + ahorro+"%</p><br>";
        result += "<br>";
        
        for(int j = 0; j < message.length(); j++){
            finalCode += codes.get(message.substring(j, j+1))+"&nbsp;&nbsp;";
            finalName += message.substring(j, j+1)  + calculateLength(codes.get(message.substring(j, j+1)));
        }
        
        result += "<p>"+finalName+"</p><br>";
        result += "<p>"+finalCode+"</p><br>";
        
        result += "</html></body>";
        return result;
        
    }
    
    public void findHuffmanCode(Nodo nodeList, String code) {
        if (nodeList != null) {
            if (nodeList.getLeftNode() == null && nodeList.getRightNode() == null) {
                nodeList.setHuffmanCode(code);
            } else {
                findHuffmanCode(nodeList.getLeftNode(), code + 0);
                findHuffmanCode(nodeList.getRightNode(), code + 1);
            }
        }
    }
}
