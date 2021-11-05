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

    public boolean agregarHijo(Nodo<T> hijo) {
        // verifica que no existe en los hijos
        if (hijos.contains(hijo)) {
            return false;
        }
        hijos.add(hijo);
        return true;
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
            // busca en los hijos de manera recursiva
            Nodo<T> nodo = hijo.buscarHijo(dato);
            if (nodo != null) {
                return nodo;
            }
        }
        return null;
    }

    private T dato;
    private ArrayList<Nodo<T>> hijos = new ArrayList<>();
}
