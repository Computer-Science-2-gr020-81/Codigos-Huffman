package controllers;

import java.util.List;
import models.Arbol;
import models.Nodo;

public class ResultsController {

    private Arbol<String> logicTree;
    private String message;
    private List<String> letters;

    public Arbol<String> getLogicTree() {
        return logicTree;
    }

    public void setLogicTree(Arbol<String> logicTree) {
        this.logicTree = logicTree;
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

    public String generateOutput() {
        String result = "<html><body>";
        String newData = "";
        String finalCode = "";
        
        //Codigo a cada letra
        result += "<p>";
        for (int i = 0; i < letters.size(); i++) {
            Nodo<String> nodo = logicTree.returnNodo(letters.get(i));
            newData += nodo.getHuffmanCode();
            result += " "+letters.get(i) + "=" + nodo.getHuffmanCode();
        }
        result += "</p>";
        result += "<br>";
        //Datos
        int originalSize = (letters.size())*8;
        result += "<p>Sin comprimir "+originalSize+" bits</p>";
        
        int newSize = newData.length();
        result += "<p>Comprimido "+newSize+" bits</p>";
        
        result += "<br>";
        
        double codificado = newSize*(100)/originalSize;
        double ahorro = 100 - codificado;
        
        result += "<p>Codificado: "+codificado+"%"+" de espacio.Ahorro: " + ahorro+"%</p>";
        result += "<br>";
        result += "<p>"+message+"</p>";
        
        result += "<p>";
        for (int j = 0; j < message.length(); j++) {
            Nodo<String> nodo = logicTree.returnNodo(message.substring(j, j+1));
            finalCode += nodo.getHuffmanCode();
           
        }
        result += finalCode+"</p>";
        
        result += "</body></html>";
        
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
