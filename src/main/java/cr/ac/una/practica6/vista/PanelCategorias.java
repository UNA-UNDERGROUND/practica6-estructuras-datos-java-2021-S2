package cr.ac.una.practica6.vista;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.JViewport;
import javax.swing.SwingUtilities;

import cr.ac.una.practica6.modelo.Modelo;
import cr.ac.una.practica6.modelo.Nodo;

/**
 *
 * (c) 2019-2021
 *
 * @author Georges Alfaro S.
 * @version 1.3.0 2021-10-22
 *
 */
public class PanelCategorias extends JPanel {
    private class Ubicacion {
        public int profundidad = 0;
        public int altitud = 0;
    }

    public PanelCategorias(Modelo modelo) {
        this.modelo = modelo;
        configurar();
    }

    private void configurar() {
        setBackground(new Color(220, 220, 240));
        setCursor(new Cursor(Cursor.MOVE_CURSOR));

        MouseAdapter m = new MouseAdapter() {
            @Override

            public void mouseDragged(MouseEvent e) {
                if (origin != null) {
                    JViewport viewPort = (JViewport) SwingUtilities.getAncestorOfClass(JViewport.class,
                            PanelCategorias.this);
                    if (viewPort != null) {
                        int deltaX = origin.x - e.getX();
                        int deltaY = origin.y - e.getY();

                        Rectangle view = viewPort.getViewRect();
                        view.x += deltaX;
                        view.y += deltaY;

                        scrollRectToVisible(view);
                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                origin = e.getPoint();
            }

            private Point origin = null;
        };

        addMouseListener(m);
        addMouseMotionListener(m);
    }

    @Override
    public void paintComponent(Graphics bg) {
        super.paintComponent(bg);
        Graphics2D g = (Graphics2D) bg;

        Dimension d = modelo.obtenerArea();

        g.setColor(Color.RED);
        float[] guiones = { 4f, 4f };
        g.setStroke(new BasicStroke(1f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0f, guiones, 0f));
        Rectangle r = new Rectangle(MARGEN, MARGEN, d.width - 2 * MARGEN, d.height - 2 * MARGEN);
        g.drawRect(r.x, r.y, r.width, r.height);

        g.setColor(Color.BLACK);

        setPreferredSize(new Dimension(d.width, d.height));

        paint(g, d);
    }

    private void paint(Graphics2D g, Dimension d) {
        // g.drawString(String.format("[%s]", modelo), 2 * MARGEN, 3 * MARGEN);
        Ubicacion u = new Ubicacion();
        for (Nodo<String> nodo : modelo.getArbol().getNodos()) {
            paintNodo(g, nodo, d, u);
        }

    }

    /**
     * dibuja un nodo de manera recursiva con sus hijos
     * <ul>
     * <li>el texto es el valor del nodo</li>
     * <li>el fondo siempre es el color #ffedbc</li>
     * <li>el color de los nodos con hijos es #B20000</li>
     * <li>el color de los nodos sin hijos#5956B4</li>
     * <li>los nodos tienen sombras</li>
     * <li>la ubicacion es modificada en cada llamada</li>
     * </ul>
     * 
     * @param g    el objeto grafico
     * @param nodo el nodo a dibujar
     * @param d    el tamaño del panel
     * @param u    la ubicacion del nodo
     */
    void paintNodo(Graphics2D g, Nodo<String> nodo, Dimension d, Ubicacion u) {

        // actualizamos la ubicacion
        // nos movimos una distancia de 1 en la altura
        u.altitud++;
        // aumentamos la profundidad al entrar en un nodo
        u.profundidad++;

        Color foreground;
        if (nodo.getHijos().isEmpty()) {
            // #5956B4
            foreground = new Color(89, 86, 180);
        } else {
            // #B20000
            foreground = new Color(178, 0, 0);
        }
        // calcula el ancho del rectangulo basado en el texto mas un margen
        int ancho = g.getFontMetrics().stringWidth(nodo.getDato()) + (MARGEN);
        // el alto del rectangulo es una constante basada en la altura del texto mas un
        // margen interno
        int margen = 2;
        int alto = g.getFontMetrics().getHeight() + (margen * 2);
        // la posicion x,y inicial del rectangulo es el punto de referencia
        int x1 = u.profundidad * MARGEN * 2;
        int y1 = u.altitud * MARGEN * 2;
        // la posicion x,y final del rectangulo es el punto de referencia mas el ancho y
        // alto
        // int x2 = x1 + ancho;
        // int y2 = y1 + alto;
        // el rectangulo es una instancia de Rectangle
        Rectangle r = new Rectangle(x1, y1, ancho, alto);
        drawRect(g, r, new Color(255, 237, 188), nodo.getDato(), foreground);

        // dibujamos de manera recursiva los hijos
        for (Nodo<String> hijo : nodo.getHijos()) {
            paintNodo(g, hijo, d, u);
        }

        // salimos del nodo por lo que la profundidad se decrementa
        u.profundidad--;
    }

    /**
     * Dibuja un rectangulo con un texto en el centro y con sombras sombras
     * 
     * @param g          el objeto grafico
     * @param r          el rectangulo a dibujar
     * @param background el color de fondo
     * @param text       el texto a dibujar
     * @param foreground el color del texto
     */
    private void drawRect(Graphics2D g, Rectangle r, Color background, String text, Color foreground) {
        g.setColor(background);
        g.fillRect(r.x, r.y, r.width, r.height);
        g.setColor(foreground);
        // dibuja el texto centrado en el rectangulo
        g.drawString(text, r.x + r.width / 2 - g.getFontMetrics().stringWidth(text) / 2,
                r.y + r.height / 2 + g.getFontMetrics().getAscent() / 2);
    }

    @Override
    public String toString() {
        return getClass().getName() + "[" + "]";
    }

    private final static int MARGEN = 16;
    private int ALTO_NODO = 16;
    private final Modelo modelo;
}
