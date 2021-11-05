package cr.ac.una.practica6.modelo;

import java.util.ArrayList;

/**
 * Representa la clase de un Arbol
 */
public class Arbol<T> {

    public Arbol() {

    }

    public boolean agregarNodo(T padre, T dato) {
        Nodo<T> nodoPadre = buscarNodo(padre);
        Nodo<T> nodoHijo = new Nodo<T>(dato);
        if (nodoPadre != null) {
            return nodoPadre.agregarHijo(nodoHijo);
        } else if (padre == null || (padre != null && padre.equals(""))) {
            hijos.add(nodoHijo);
            return true;
        }
        return false;
    }

    public boolean eliminarNodo(T dato) {
        for (Nodo<T> nodo : hijos) {
            if (nodo.getDato().equals(dato)) {
                hijos.remove(nodo);
                return true;
            } else if (nodo.eliminarHijo(dato)) {
                return true;
            }
        }
        return false;
    }

    public Nodo<T> buscarNodo(T dato) {
        if (dato == null || dato.equals("")) {
            return null;
        }
        for (Nodo<T> raiz : hijos) {
            Nodo<T> nodo = raiz;
            if (nodo.getDato().equals(dato)) {
                return nodo;
            }
            nodo = nodo.buscarHijo(dato);
            if (nodo != null) {
                return nodo;
            }
        }
        return null;
    }

    public ArrayList<Nodo<T>> getNodos() {
        return hijos;
    }

    private ArrayList<Nodo<T>> hijos = new ArrayList<>();
}
