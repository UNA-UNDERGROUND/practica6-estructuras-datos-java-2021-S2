package cr.ac.una.practica6.modelo;

import java.util.ArrayList;

/**
 * Representa el nodo de un Arbol
 * 
 */
public class Nodo<T> {
    public Nodo(T dato) {
        this.dato = dato;
    }

    public T getDato() {
        return dato;
    }

    public void agregarHijo(Nodo<T> hijo) {
        hijos.add(hijo);
    }

    public boolean eliminarHijo(T valor) {
        for (Nodo<T> hijo : hijos) {
            if (hijo.getDato().equals(valor)) {
                hijos.remove(hijo);
                return true;
            } else if (hijo.eliminarHijo(valor)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Nodo<T>> getHijos() {
        return hijos;
    }

    public Nodo<T> buscarHijo(T dato) {
        for (Nodo<T> hijo : hijos) {
            if (hijo.getDato().equals(dato)) {
                return hijo;
            }
        }
        return null;
    }

    private T dato;
    private ArrayList<Nodo<T>> hijos = new ArrayList<>();
}
