package cr.ac.una;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import cr.ac.una.practica6.modelo.Modelo;
import cr.ac.una.practica6.vista.VentanaAplicacion;

public class App {
    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc="Configuración UI">
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            JFrame.setDefaultLookAndFeelDecorated(true);
        } catch (Exception ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        //</editor-fold>

        SwingUtilities.invokeLater(() -> {
            new VentanaAplicacion("Práctica #6 (Categorías)", new Modelo()).init();
        });
    }
}
