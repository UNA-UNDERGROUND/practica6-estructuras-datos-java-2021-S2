package cr.ac.una.vista;

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
import practica6.modelo.Modelo;

/**
 *
 * (c) 2019-2021
 *
 * @author Georges Alfaro S.
 * @version 1.3.0 2021-10-22
 *
 */
public class PanelCategorias extends JPanel {

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
                    JViewport viewPort
                            = (JViewport) SwingUtilities.getAncestorOfClass(
                                    JViewport.class, PanelCategorias.this);
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
        float[] guiones = {4f, 4f};
        g.setStroke(new BasicStroke(1f,
                BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL,
                0f, guiones, 0f));
        Rectangle r = new Rectangle(MARGEN, MARGEN,
                d.width - 2 * MARGEN,
                d.height - 2 * MARGEN);
        g.drawRect(r.x, r.y, r.width, r.height);

        g.setColor(Color.BLACK);
        g.drawString(String.format("(%s)", modelo),
                2 * MARGEN, 3 * MARGEN);

        setPreferredSize(new Dimension(d.width, d.height));
    }

    private final static int MARGEN = 16;
    private final Modelo modelo;
}
