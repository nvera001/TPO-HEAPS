package prin;

import implementaciones.HeapsEstaticoMin;
import interfaces.HeapsTDA;

public class prinEstaticoMin {
    public static void main(String[] args) {
    HeapsTDA nodo = new HeapsEstaticoMin();

    nodo.InicializarHeap();
    System.out.println(nodo.heapVacio());
    nodo.insertar(5);
    nodo.insertar(7);
    nodo.insertar(3);
    nodo.insertar(8);
    nodo.insertar(1);
    nodo.insertar(2);
    nodo.insertar(4);
    nodo.insertar(6);
    nodo.insertar(10);
    nodo.insertar(9);
    nodo.insertar(11);
    nodo.mostrarComoArbol();



    }
}