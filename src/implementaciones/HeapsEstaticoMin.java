package implementaciones;

import interfaces.HeapsTDA;

public class HeapsEstaticoMin implements HeapsTDA{
    private int[] heap;
    private int cantidad;
    private int capacidad = 100;

    public void headMax(int capacidad) {
        cantidad = 0;
        heap = new int[capacidad];
    }

    private int padre(int indice) {
        return (indice - 1) / 2;
    }

    private int hijoIzq(int indice) {
        return 2 * indice + 1;
    }

    private int hijoDer(int indice) {
        return 2 * indice + 2;
    }

    private void swap(int i, int j) {
        int temporal = heap[i]; // guarda el valor, para no sobreescribirlo.
        heap[i] = heap[j];
        heap[j] = temporal;
    }

    private void flotar(int i) {
        while (i > 0 && heap[padre(i)] > heap[i]) {
            swap(padre(i), i);
            i = padre(i);
        }
    }

    public void InicializarHeap() {
        heap = new int[capacidad];
        cantidad = 0;
    }

    public void insertar(int valor) {
        if (cantidad == capacidad) {
            System.out.println("El heap llegó a su límite de heap.");
        } else {
            heap[cantidad] = valor;
            flotar(cantidad);
            cantidad++;

        }
    }

    public int eliminar() {
        int eliminado = heap[0];
        heap[0] = heap[cantidad - 1];
        cantidad--;
        hundir(0);
        return eliminado;
    }

    private void hundir(int i) {
        int izquierdo = hijoIzq(i);
        int derecho = hijoDer(i);
        int mayor = i;

        if (izquierdo < cantidad && heap[izquierdo] > heap[mayor]) {
            mayor = izquierdo;

        }
        if (derecho < cantidad && heap[derecho] > heap[mayor]) {
            mayor = derecho;

        }
        if (mayor != i) {
            swap(i, mayor);
            hundir(mayor);
        }
    }

    public int primero() {
        return heap[0];
    }

    public boolean heapVacio() {
        return (cantidad == 0);
    }

    public void mostrarComoArbol() {
        int niveles = (int) Math.floor(Math.log(cantidad) / Math.log(2)) + 1;
        int index = 0;
    
        for (int nivel = 0; nivel < niveles; nivel++) {
            int cantidadEnNivel = (int) Math.pow(2, nivel);
            int espacioAntes = (int) Math.pow(2, niveles - nivel) - 1;
            int espacioEntre = (int) Math.pow(2, niveles - nivel + 1) - 1;
    
            // Espacio antes del primer número
            imprimirEspacios(espacioAntes);
    
            for (int i = 0; i < cantidadEnNivel && index < cantidad; i++) {
                System.out.printf("%2d", heap[index++]);
                imprimirEspacios(espacioEntre);
            }
    
            System.out.println();
        }
    }
    
    private void imprimirEspacios(int cantidadEspacios) {
        for (int i = 0; i < cantidadEspacios; i++) {
            System.out.print("  "); // Dos espacios por unidad para mejor ancho
        }
    }
}