package models;


public class Nodo<T> {
    
    private T value;
    private Nodo leftNode, rightNode;
    private boolean wasUsed;
    private Integer colIndex;
    private String HuffmanCode = null;

    public Nodo getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Nodo leftNode) {
        this.leftNode = leftNode;
    }

    public Nodo getRightNode() {
        return rightNode;
    }

    public void setRightNode(Nodo rightNode) {
        this.rightNode = rightNode;
    }

    public String getHuffmanCode() {
        return HuffmanCode;
    }

    public void setHuffmanCode(String HuffmanCode) {
        this.HuffmanCode = HuffmanCode;
    }     
    
    public Nodo(T value) {
        this.value = value;
    }
    
    public Nodo(){}
    
    public Nodo insertar(Nodo n, T elemento) {
        if (n == null)
            return new Nodo(elemento);
        else if (elemento.hashCode() < n.value.hashCode())
            n.leftNode = insertar(n.leftNode, elemento);
        else if (elemento.hashCode() > n.value.hashCode())
            n.rightNode = insertar(n.rightNode, elemento);
        return n;
    }
    
    public int nodosCompletos(Nodo n) {
        if (n == null)
            return 0;
        else {
            if (n.leftNode != null && n.rightNode != null)
                return nodosCompletos(n.leftNode) + nodosCompletos(n.rightNode) + 1;
            return nodosCompletos(n.leftNode) + nodosCompletos(n.rightNode);
        }
    }
    
     public Nodo<T> returnNodo(T x) {
        Nodo<T> q, p = this;
        
        q = null;
        while (p != null) {
            if (x.hashCode() < p.getValue().hashCode()) {
                p = p.getIzquierda();
            } else if (x.hashCode() > p.getValue().hashCode()) {
                p = p.getDerecha();
            } else {
                return p;
            }
        }
        return null;
    }

    public Integer getColIndex() {
        return colIndex;
    }

    public void setColIndex(Integer colIndex) {
        this.colIndex = colIndex;
    }
    
    public void setIzquierda(Nodo leftNode) {
        this.leftNode = leftNode;
    }

    public void setDerecha(Nodo rightNode) {
        this.rightNode = rightNode;
    }  

    public T getValue() {
        return value;
    }

    public Nodo getIzquierda() {
        return leftNode;
    }

    public Nodo getDerecha() {
        return rightNode;
    }
    
    public void setValue(T value){
        this.value = value;
    }

    public boolean isWasUsed() {
        return wasUsed;
    }

    public void setWasUsed(boolean wasUsed) {
        this.wasUsed = wasUsed;
    } 

    @Override
    public String toString() {
        return "Nodo{" + "value=" + value + ", leftNode=" + leftNode + ", rightNode=" + rightNode + ", wasUsed=" + wasUsed + ", colIndex=" + colIndex + '}';
    }

    
    
}
