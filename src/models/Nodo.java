package models;


public class Nodo<T> {
    
    private T value;
    private Nodo izquierda, derecha;
    private boolean wasUsed;

    public Nodo(T value) {
        this.value = value;
    }
    
    public Nodo(){}
    
    public Nodo insertar(Nodo n, T elemento) {
        if (n == null)
            return new Nodo(elemento);
        else if (elemento.hashCode() < n.value.hashCode())
            n.izquierda = insertar(n.izquierda, elemento);
        else if (elemento.hashCode() > n.value.hashCode())
            n.derecha = insertar(n.derecha, elemento);
        return n;
    }
    
    public int nodosCompletos(Nodo n) {
        if (n == null)
            return 0;
        else {
            if (n.izquierda != null && n.derecha != null)
                return nodosCompletos(n.izquierda) + nodosCompletos(n.derecha) + 1;
            return nodosCompletos(n.izquierda) + nodosCompletos(n.derecha);
        }
    }

    public T getValue() {
        return value;
    }

    public Nodo getIzquierda() {
        return izquierda;
    }

    public Nodo getDerecha() {
        return derecha;
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
}
