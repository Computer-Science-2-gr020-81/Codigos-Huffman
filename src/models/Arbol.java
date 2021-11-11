package models;

import java.util.ArrayList;
import java.util.Objects;

public class Arbol<T> {

    private Nodo<T> raiz;
    private ArrayList<T> in, pre, pos;
    private ArrayList<Nodo<T>> inNodes = new ArrayList<>();

    public Arbol() {
        raiz = null;
        in = new ArrayList<>();
        pre = new ArrayList<>();
        pos = new ArrayList<>();
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }

    public String getInOrden() {
        String retorno = "";
        for (int i = 0; i < in.size(); i++) {
            if (i != in.size() - 1) {
                retorno += in.get(i) + ",";
            } else {
                retorno += in.get(i);
            }
        }
        return retorno;
    }

    public String getPreOrden() {
        String retorno = "";
        for (int i = 0; i < pre.size(); i++) {
            if (i != pre.size() - 1) {
                retorno += pre.get(i) + ",";
            } else {
                retorno += pre.get(i);
            }
        }
        return retorno;
    }

    public String getPosOrden() {
        String retorno = "";
        for (int i = 0; i < pos.size(); i++) {
            if (i != pos.size() - 1) {
                retorno += pos.get(i) + ",";
            } else {
                retorno += pos.get(i);
            }
        }
        return retorno;
    }

    public int insertarNodo(T x) {
        Nodo<T> q, nuevo, p = raiz;
        if (raiz == null) {
            raiz = new Nodo<>(x);
            return 1;
        }
        q = null;
        while (p != null) {
            if (x.hashCode() < p.getValue().hashCode()) {
                q = p;
                p = p.getIzquierda();
            } else if (x.hashCode() > p.getValue().hashCode()) {
                q = p;
                p = p.getDerecha();
            } else {
                return -1;
            }
        }
        nuevo = new Nodo(x);
        if (x.hashCode() < q.getValue().hashCode()) {
            q.setIzquierda(nuevo);
        } else {
            q.setDerecha(nuevo);
        }
        return 1;
    }
    
    public void insertarNodoPorPosicion(Nodo<T> r,int colIndex,boolean isLeft){
        Nodo<T> padre = returnNodeByColIndex(colIndex);
        //System.out.println("Padre: " + padre);
        if(isLeft){
            padre.setIzquierda(r);
        }else{
            padre.setDerecha(r);
        }
    }
    
    public String getCode(T x){
        Nodo<T> q, p = raiz;
        String data = "";

        if (raiz == null) {
            return null;
        }
        q = null;
        while (p != null) {
            if (x.hashCode() < p.getValue().hashCode()) {
                p = p.getIzquierda();
                data += "0";
            } else if (x.hashCode() > p.getValue().hashCode()) {
                p = p.getDerecha();
                data += "1";
            } else if(x.equals(p.getValue())) {
                return data;
            }
        }
        return null;
    }

    public void retirarNodo(T x) {
        Nodo p = returnNodo(x);
        Nodo q = getParent(returnNodo(x));

        Nodo r, t, s;

        if (p.getIzquierda()== null) {
            r = p.getDerecha();
        } else if (p.getDerecha()== null) {
            r = p.getIzquierda();
        } else {
            s = p;
            r = p.getDerecha();
            t = r.getIzquierda();
            while (t != null) {
                s = r;
                r = t;
                t = t.getIzquierda();
            }
            if (p != s) {
                s.setIzquierda(r.getDerecha());
                r.setDerecha(p.getDerecha());
            }
            r.setIzquierda((p.getIzquierda()));
        }
        if (q == null) {
            raiz = r;
        } else if (p == q.getIzquierda()) {
            q.setIzquierda(r);
        } else {
            q.setDerecha(r);
        }
        resetArrays();
    }

    public void inOrden(Nodo<T> r) {
        if (r != null) {
            inOrden(r.getIzquierda());
            in.add(r.getValue());
            inNodes.add(r);
            inOrden(r.getDerecha());
        }
    }

    public void posOrden(Nodo<T> r) {
        if (r != null) {
            posOrden(r.getIzquierda());
            posOrden(r.getDerecha());
            pos.add(r.getValue());
        }
    }

    public void preOrden(Nodo<T> r) {
        if (r != null) {
            pre.add(r.getValue());
            preOrden(r.getIzquierda());
            preOrden(r.getDerecha());
        }
    }

    public String getNodosXNivel(Nodo<T> r) {
        ArrayList<Nodo<T>> colaNiveles = new ArrayList<>();
        ArrayList<Nodo<T>> cola = new ArrayList<>();
        cola.add(r);
        Nodo p;
        while (cola.size() > 0) {
            p = cola.get(0);
            colaNiveles.add(p);
            cola.remove(0);
            if(p==null)
                return "";
            if (p.getIzquierda()!= null) {
                cola.add(p.getIzquierda());
            }
            if (p.getDerecha()!= null) {
                cola.add(p.getDerecha());
            }
        }
        String retorno = "";
        for (int i = 0; i < colaNiveles.size(); i++) {
            if (i != colaNiveles.size() - 1) {
                retorno += colaNiveles.get(i).getValue()+ ",";
            } else {
                retorno += colaNiveles.get(i).getValue();
            }
        }
        return retorno;
    }

    public int calcularGordura(Nodo raiz) {
        int altura = calcularAltura(raiz);
        ArrayList<Integer> arregloNodosXNivel = new ArrayList<>();

        if (altura == 0) {
            return 0;
        }
        if (in.isEmpty()) {
            inOrden(raiz);
            if (in.isEmpty()) {
                return 0;
            } else {
                return calcularGordura(raiz);
            }
        } else {

            for (int i = 0; i < altura; i++) {
                arregloNodosXNivel.add(0);
            }

            for (T e : in) {
                int nivelNodo = getNivelXNodo(e);
                arregloNodosXNivel.set(nivelNodo, arregloNodosXNivel.get(nivelNodo) + 1);
            }
            int retorno = -1;
            for (int e : arregloNodosXNivel) {
                if (retorno == -1) {
                    retorno = e;
                } else {
                    if (retorno < e) {
                        retorno = e;
                    }
                }
            }
            return retorno;
        }
    }

    public int calcularAltura(Nodo r) {
        if (r == null) {
            return 0;
        }
        return Math.max(calcularAltura(r.getIzquierda()), calcularAltura(r.getDerecha())) + 1;
    }

    public boolean contains(T x) {
        int nivelNodo = 0;
        Nodo<T> q, p = raiz;

        if (raiz == null) {
            return false;
        }
        q = null;
        while (p != null) {
            if (x.hashCode() < p.getValue().hashCode()) {
                q = p;
                p = p.getIzquierda();
                nivelNodo++;
            } else if (x.hashCode() > p.getValue().hashCode()) {
                q = p;
                p = p.getDerecha();
                nivelNodo++;
            } else {
                return true;
            }
        }
        return false;
    }

    public int getNivelXNodo(T x) {
        int alturaNodo = 0;
        Nodo<T> q, p = raiz;

        if (raiz == null) {
            return 0;
        }
        q = null;
        while (p != null) {
            if (x.hashCode() < p.getValue().hashCode()) {
                q = p;
                p = p.getIzquierda();
                alturaNodo++;
            } else if (x.hashCode() > p.getValue().hashCode()) {
                q = p;
                p = p.getDerecha();
                alturaNodo++;
            } else {
                return alturaNodo;
            }
        }
        return 0;
    }

    public Nodo<T> returnNodo(T x) {
        inOrden(raiz);
        for(int i = 0; i < inNodes.size(); i++){
            if(Objects.equals(x, inNodes.get(i).getValue())){
               return inNodes.get(i);
            }
        }
        return null;
    }
    
    public Nodo<T> returnNodeByColIndex(int colIndex){
        inOrden(raiz);
        for(int i = 0; i < inNodes.size(); i++){
            if(colIndex == inNodes.get(i).getColIndex()){
               return inNodes.get(i);
            }
        }
        return null;
    }

    public boolean compelto(Nodo raiz) {
        int alturaArbol = calcularAltura(raiz);
        int numeroNodosAltura = 0;
        if (in.isEmpty()) {
            inOrden(raiz);
            if (in.isEmpty()) {
                System.out.println("No hay árbol");
                return false;
            } else {
                return compelto(raiz);
            }
        } else {
            for (T e : in) {
                Nodo nodoIteracion = returnNodo(e);
                if (nodoIteracion != (null)) {
                    if (getNivelXNodo(e) == alturaArbol - 1) {
                        numeroNodosAltura++;
                    }
                } else {

                }
            }
            if ((int) numeroNodosAltura == (int) Math.pow(2, alturaArbol - 1)) {
                return true;
            } else {
                return false;
            }
        }
    }

    public int getNroHojas(Nodo<T> raiz) {
        int contador = 0;

        if (in.isEmpty()) {
            inOrden(raiz);
            if (in.isEmpty()) {
                System.out.println("No hay árbol");
                return 0;
            } else {
                return getNroHojas(raiz);
            }
        } else {
            for (T e : in) {
                Nodo nodoIteracion = returnNodo(e);
                if (nodoIteracion != null) {
                    if (nodoIteracion.getIzquierda()== null && nodoIteracion.getDerecha()== null) {
                        contador++;
                    }
                } else {

                }
            }
            return contador;
        }
    }

    public Nodo getParent(Nodo<T> nodo) {
        Nodo retorno = null;
        for (T e : in) {
            Nodo nodoTemp = returnNodo(e);
            if (nodoTemp.getIzquierda()== (nodo) || nodoTemp.getDerecha()== (nodo)) {
                retorno = nodoTemp;
                return retorno;
            }
        }
        return null;
    }
    
    public void addChild(Nodo<T> nodo){
        for (T e : in) {
            Nodo nodoTemp = returnNodo(e);
            if (nodoTemp.getIzquierda()== (nodo)) {
                nodoTemp.setIzquierda(nodo);
            }else if(nodoTemp.getDerecha()== (nodo)){
                nodoTemp.setDerecha(nodo);
            }
        }
    }

    public void resetArrays() {
        in = new ArrayList<>();
        pre = new ArrayList<>();
        pos = new ArrayList<>();
    }
    
}

