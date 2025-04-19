package implementaciones; //Paquete en el que está incluido.

import interfaces.HeapsTDA; //importa el TDA.

public class HeapsEstaticoMax implements HeapsTDA {
    private int[] heap;  // Declara el heap.
    private int cantidad; //indica la cantidad, 0.
    private int capacidad = 100; //pone una capacidad al heap, es estatico.

    private int padre(int indice) {
        return (indice - 1) / 2; //indice del heap padre. 
    }

    private int hijoIzq(int indice) {
        return 2 * indice + 1; //indice del hijo izq
    }

    private int hijoDer(int indice) {
        return 2 * indice + 2; //indice de hijo derecha
    }

    private void swap(int i, int j) { //la i es el valor del indice padre, la j es el valor del indice hijo
        int temporal = heap[i]; // guarda el valor del padre, para no sobreescribirlo.
        heap[i] = heap[j]; //el hijo pasa a ser padre.
        heap[j] = temporal; //el padre pasa a ser hijo.
    }

    private void flotar(int i) {
        while (i > 0 && heap[padre(i)] < heap[i]) { //en caso de que el heap padre sea menor que el heap hijo.
            swap(padre(i), i); //los cambia en el metodo de arriba.
            i = padre(i); //busca la indice del padre en el metodo de arriba.
        }
    }

    public void InicializarHeap() {
        heap = new int[capacidad]; //inicializa el heap, con cantidad 0 de elementos.
        cantidad = 0;
    }

    public void insertar(int valor) {
        if (cantidad == capacidad) { 
            System.out.println("El heap llegó a su límite de heap.");
        } else {
            heap[cantidad] = valor; //indica el valor del heap.
            flotar(cantidad); //llama al metodo anterior, para ponerlo en su indice correcta.
            cantidad++; //aumenta en uno la cantidad de elementos

        }
    }

    public int eliminar() {
        int eliminado = heap[0]; //elimina el primer elemento de heap, en este caso el valor mas grande.
        heap[0] = heap[cantidad - 1]; //pone al ultimo elemento del heap, en primer lugar. 
        cantidad--; //disminuye la cantidad de elementos.
        hundir(0); //hunde el elemento que se puso en primer lugar, para reorganizar el heap en su conjunto.
        return eliminado; //devuelve el valor eliminado.
    }

    private void hundir(int i) { 
        int izquierdo = hijoIzq(i); //indice de hijo izq
        int derecho = hijoDer(i); //indice de hijo der
        int mayor = i; //indice de padre

        if (izquierdo < cantidad && heap[izquierdo] > heap[mayor]) {
            mayor = izquierdo;

        }
        if (derecho < cantidad && heap[derecho] > heap[mayor]) {
            mayor = derecho;

        }
        if (mayor != i) {
            swap(i, mayor); //los intercambia
            hundir(mayor); //los organiza
        }
    }

    public int primero() {
        return heap[0]; //devuelve el primer elemento del heap, en este caso el mayor.
    }

    public boolean heapVacio() {
        return (cantidad == 0); //devuelve true, en caso que este vacio el heap.
    }

    public void mostrarComoArbol() { //muestra el arbol, lo saque de chat gpt pero hace que se vea super claro todo.
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