package cr.ac.una.practica6.modelo;

import java.awt.Dimension;

/**
 *
 * (c) 2019-2021
 *
 * @author Georges Alfaro S.
 * @version 1.3.0 2021-10-22
 *
 */
public class Modelo {

    public Dimension obtenerArea() {
        return new Dimension(800, 640);
    }

    public void agregarNodo(String padre, String dato) {
        arbol.agregarNodo(padre, dato);
    }

    public boolean eliminarNodo(String valor) {
        return arbol.eliminarNodo(valor);
    }

    public Arbol<String> getArbol() {
        return arbol;
    }

    @Override
    public String toString() {
        return "Modelo{" + '}';
    }

    private Arbol<String> arbol = new Arbol<>();
}
