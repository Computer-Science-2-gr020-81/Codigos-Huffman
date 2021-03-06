package controllers;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import models.Arbol;
import models.Nodo;
import utils.Util;

public class ResultsController {

    private Arbol<String> logicTree;
    private String message;
    private List<String> letters;
    private Nodo<String>[][] treeRepresentation;
    private String finalCode="";
    private String finalName="";
    private Map<String,String> codes = new HashMap<>();
    private Map<String,String> homologacion = new HashMap<>();


    public Arbol<String> getLogicTree() {
        return logicTree;
    }

    public String getFinalCode() {
        return finalCode;
    }

    public String getFinalName() {
        return finalName;
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
   
    
    public String generateOutput(){
        String result = "<html><body>";
        List<String> huffmanCode = new ArrayList<>();
        codes = new HashMap<>();
        homologacion = new HashMap<>();
        finalCode= new String();
        finalName= new String();
        
        
        //Codigo a cada letra
        result += "<p>";
        for (int i = 0; i < letters.size(); i++) {
            Nodo<String> nodo = logicTree.returnNodo(letters.get(i));
            result += "<span>"+letters.get(i) + "=" + nodo.getHuffmanCode() + "</span>&nbsp;&nbsp;";
            huffmanCode.add(nodo.getHuffmanCode());
            if(!codes.containsKey(letters.get(i))){
                codes.put(letters.get(i), nodo.getHuffmanCode());
                homologacion.put(nodo.getHuffmanCode(), letters.get(i));
            }
        }
        
        result += "</p>";
        //Datos
        int originalSize = (message.length())*8;
        result += "<p>Sin comprimir "+message.length()+" * "+ 8 +" = "+originalSize+" bits</p>";
        
        
        int newSize = getCompressedSize();
        result += "<p>Comprimido "+newSize+" bits</p>";

        
        DecimalFormat df = new DecimalFormat("###.###");


        double codificado = newSize*(100.0)/originalSize;
        double ahorro = 100.0 - codificado;

        result += "<p>Codificado: "+df.format(codificado)+"%"+" de espacio.Ahorro: " + df.format(ahorro)+"%</p><br>";
       
        result += "</html></body>";
        return result;
        
    }
    public void setCode(){
        for(int j = 0; j < message.length(); j++){
            finalCode += codes.get(message.substring(j, j+1))+"  ";  
        }
    }
    public void setNameCode(){
        finalName = Util.cloneString(finalCode);
        String[] splitted = finalName.split("  ");
        Util.imprimir(splitted);
        boolean f=true;
        boolean m=true;
        
        for(int i = 0; i < splitted.length; i++){
            splitted[i] = splitted[i].replaceFirst(splitted[i].substring(0, 1), homologacion.get(splitted[i]));
            if(splitted[i].substring(0, 1).equals("s")&& f){
                splitted[i] = splitted[i].replaceAll("[0-9]", "  ");
                f=false;
                
            }else if(splitted[i].substring(0, 1).equals("m")||splitted[i].substring(0, 1).equals("p")){
                splitted[i] = splitted[i].replaceAll("[0-9]", "  ");
            }else if(splitted[i].substring(0, 1).equals("i")&& m||splitted[i].substring(0, 1).equals("r")){
                splitted[i] = splitted[i].replaceAll("[0-9]", "   ");
                m=false;
            }else{
                splitted[i] = splitted[i].replaceAll("[0-9]", "  ");
            }
        }
        finalName = "";
        for(int i = 0; i < splitted.length;i++){
            finalName += splitted[i] + "  ";
        }
    }
    
    public String generateSpaces(String value, String code) {
        String[] splitted = code.split(" ");
        String returned = "";
        int counter = 0;
        for(String codeSplitted : splitted) {
            String aux = value.substring(counter, ++counter);
            do {
                aux += " ";
            } while(aux.length() < codeSplitted.length() + 1);
            returned += aux;
        }
        return returned;
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
