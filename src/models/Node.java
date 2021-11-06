package models;

public class Node {

    private String value;
    private boolean isUsed;
    private Node leftNode,rightNode;

    public String getValue(){
        return value;
    }

    public boolean getIsUsed(){
        return isUsed;
    }

    public Node getLeftNode(){
        return leftNode;
    }

    public Node getRightNode(){
        return rightNode;
    }

    public void setValue(String value){
        this.value = value;
    }

    public void setLeftNode(Node leftNode){
        this.leftNode = leftNode;
    }

    public void setRightNode(Node rightNode){
        this.rightNode = rightNode;
    }

    public void setIsUsed(boolean isUsed){
        this.isUsed = isUsed;
    }
    
}