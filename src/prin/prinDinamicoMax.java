package prin;

import implementaciones.HeapsDinamicoMax;
import interfaces.HeapsTDA;

public class prinDinamicoMax {
    public static void main(String[] args) {
    HeapsTDA nodo = new HeapsDinamicoMax();

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
    System.out.println("El nodo padre de este head es: " + nodo.primero());
    System.out.println(" ");
    nodo.mostrarComoArbol();
    System.out.println(" ");
    System.out.println("Se elimina el nodo padre: "+nodo.eliminar());
    System.out.println(" ");
    System.out.println("Después de la eliminación, el heap queda así: ");
    nodo.mostrarComoArbol();
    }
}
