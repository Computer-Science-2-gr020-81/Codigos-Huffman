package views;


import java.awt.Font;
import javax.swing.JPanel;
import java.awt.Graphics;
import models.Arbol;
import models.Nodo;

public class Lienzo extends JPanel {

    private Arbol arbol;
    private static int ancho = 55, diametro = 30, radio = diametro / 2;
    //Diametro de los nodos, radio, ancho de separación entre los nodos
    

    public void setArbol(Arbol arbol) {
        this.arbol = arbol;
        repaint();
    }

    public void pintar(Graphics g, int x, int y, Nodo raiz) {
        if (raiz != null) {
            g.setFont(new Font("Arial",Font.PLAIN,14));
            int extra = raiz.nodosCompletos(raiz) * (ancho / 2)-40; //Espacio extra para que los nodos no queden pegados
            g.drawOval(x, y, diametro, diametro); //Dibujar el nodo
            g.drawString(String.valueOf(raiz.getValue()), x+12, y + 18); //Dibujar el valor del nodo
            
            //Dibujar lineas izquierda y derecha
            if (raiz.getIzquierda()!= null) {
                g.drawLine(x+radio, y+radio+15, x - ancho - extra + radio+15, y + ancho + radio);
            }
            if (raiz.getDerecha()!= null) {
                g.drawLine(x + radio, y + radio+15, x + ancho + extra + radio-15, y + ancho + radio);
            }
            
            //Llamadas recursivas para dibujar a los hijos
            pintar(g, x - ancho - extra, y + ancho, raiz.getIzquierda());
            pintar(g, x + ancho + extra, y + ancho, raiz.getDerecha());
        }

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
         pintar(g, (getWidth() / 2), 20, arbol.getRaiz());
    }

}
