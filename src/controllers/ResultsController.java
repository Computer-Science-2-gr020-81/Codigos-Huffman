package controllers;

import java.awt.Color;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JTextArea;
import models.Arbol;
import models.Nodo;

public class ResultsController {

    private Arbol<String> logicTree;
    private String message;
    private List<String> letters;
    private JTextArea resultLabel;

    public Arbol<String> getLogicTree() {
        return logicTree;
    }

    public void setResultLabel(JTextArea resultLabel) {
        this.resultLabel = resultLabel;
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
    
    private String calculateLength(String code){
        String whiteSpaces = "";
        int size = code.length();
        for(int i = 0; i < size;i++){
            if(code.equals("0")){
                whiteSpaces += "   ";
            }else{
                whiteSpaces += " ";
            }
        }
        return whiteSpaces;
    }

    public String generateOutput() {
        String result = "";
        String newData = "";
        String finalCode = "";
        String finalName = "";
        Map<String,String> asociation = new HashMap<>();
        
        //Codigo a cada letra
        for (int i = 0; i < letters.size(); i++) {
            Nodo<String> nodo = logicTree.returnNodo(letters.get(i));
            newData += nodo.getHuffmanCode();
            result += " "+letters.get(i) + "=" + nodo.getHuffmanCode();
        }
        result += "\n";
        //Datos
        int originalSize = (letters.size())*8;
        result += "Sin comprimir "+originalSize+" bits";
        
        int newSize = newData.length();
        result += "Comprimido "+newSize+" bits";
        
        result += "\n";
        
        double codificado = newSize*(100)/originalSize;
        double ahorro = 100 - codificado;
        
        result += "Codificado: "+codificado+"%"+" de espacio.Ahorro: " + ahorro+"%\n";
        result += "\n";
        
        for (int j = 0; j < message.length(); j++) {
            Nodo<String> nodo = logicTree.returnNodo(message.substring(j, j+1));
            finalCode += nodo.getHuffmanCode()+" ";
            if(!asociation.containsKey(nodo.getHuffmanCode())){
                asociation.put(nodo.getHuffmanCode(), message.substring(j, j+1));
            }
            
            
        }
        String[] huffmanCode =  finalCode.split(" ");
        
        for(String e:huffmanCode){
            for(int index = 0; index < e.length();index++){
                if(index == 0){
                    resultLabel.setForeground(Color.BLACK);
                    finalName += asociation.get(e);
                }else{
                    resultLabel.setForeground(Color.WHITE);
                    finalName += "0";
                }
            }
            resultLabel.setForeground(Color.WHITE);
            finalName += "0";
        }
        resultLabel.setForeground(Color.BLACK);
        result += finalName+"\n";
        result += ""+finalCode+"";
        
        //result += "</body></html>";
        
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
