package models;


public class Arbol<T> {
    private Nodo<T> root;
    
    public void insert(T value) {
        if (root == null)
            root = new Nodo(root);
        else
            root = root.insertar(root, value);
    }

    public Nodo getRaiz() {
        return root;
    }
}
