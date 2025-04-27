package implementaciones; //Paquete en el que está incluido.

import interfaces.HeapsTDA; //Importa el TDA.

public class HeapsEstaticoMax implements HeapsTDA {
    private int[] heap;  // Declara el heap.
    private int cantidad; //Declara cantidad.
    private int capacidad = 100; //Declara e inicializa una capacidad al heap, es estatico.

    private int padre(int indice) {
        return (indice - 1) / 2; //Indice del heap padre. 
    }

    private int hijoIzq(int indice) {
        return 2 * indice + 1; //Indice del hijo izquierdo.
    }

    private int hijoDer(int indice) {
        return 2 * indice + 2; //Indice de hijo derecho.
    }

    private void swap(int i, int j) { //La i es el valor del indice padre, la j es el valor del indice hijo.
        int temporal = heap[i]; // Guarda el valor del padre, para no sobreescribirlo.
        heap[i] = heap[j]; //El hijo pasa a ser padre.
        heap[j] = temporal; //El padre pasa a ser hijo.
    }

    private void flotar(int i) {
        while (i > 0 && heap[padre(i)] < heap[i]) { //En caso de que el heap padre sea menor que el heap hijo.
            swap(padre(i), i); //Los cambia de posición.
            i = padre(i); //Busca la posición del padre.
        }
    }

    public void InicializarHeap() {
        heap = new int[capacidad]; //Inicializa el heap.
        cantidad = 0; // Con cantidad 0 de elementos.
    }

    public void insertar(int valor) {
        if (cantidad == capacidad) { 
            System.out.println("El heap llegó a su límite de heap.");
        } else {
            heap[cantidad] = valor; //Inserta el valor dentro del heap.
            flotar(cantidad); //Organiza el heap.
            cantidad++; //Aumenta en uno la cantidad de elementos.
        }
    }

    public int eliminar() {
        int eliminado = heap[0]; //Elimina el primer elemento del heap.
        heap[0] = heap[cantidad - 1]; //Pone al ultimo elemento del heap, en primer lugar. 
        cantidad--; //Disminuye la cantidad de elementos.
        hundir(0); //Hunde el elemento que se puso en primer lugar, para reorganizar el heap en su conjunto.
        return eliminado; //Devuelve el valor eliminado.
    }

    private void hundir(int i) { 
        int izquierdo = hijoIzq(i); //Indice de hijo izquierdo.
        int derecho = hijoDer(i); //Indice de hijo derecho.
        int mayor = i; //Indice de padre.

        if (izquierdo < cantidad && heap[izquierdo] > heap[mayor]) {
            mayor = izquierdo;

        }
        if (derecho < cantidad && heap[derecho] > heap[mayor]) {
            mayor = derecho;

        }
        if (mayor != i) {
            swap(i, mayor); //Los intercambia.
            hundir(mayor); //Los organiza.
        }
    }

    public int primero() {
        return heap[0]; //Devuelve el primer elemento del heap, en este caso el mayor.
    }

    public boolean heapVacio() {
        return (cantidad == 0); //Devuelve true, en caso que este vacio el heap.
    }

    public void mostrarComoArbol() { //Muestra el heap.
        int niveles = (int) Math.floor(Math.log(cantidad) / Math.log(2)) + 1;
        int index = 0;
    
        for (int nivel = 0; nivel < niveles; nivel++) {
            int cantidadEnNivel = (int) Math.pow(2, nivel);
            int espacioAntes = (int) Math.pow(2, niveles - nivel) - 1;
            int espacioEntre = (int) Math.pow(2, niveles - nivel + 1) - 1;
    
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
            System.out.print("  "); 
        }
    }

}   