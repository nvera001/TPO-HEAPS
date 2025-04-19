package prin;

import implementaciones.HeapsEstaticoMax;
import interfaces.HeapsTDA;

public class prinEstaticoMax {
    public static void main(String[] args) {
    HeapsTDA nodo = new HeapsEstaticoMax();
    nodo.InicializarHeap();
    System.out.println(nodo.heapVacio());
    nodo.insertar(5);
    nodo.insertar(7);
    nodo.insertar(3);
    nodo.insertar(8);
    nodo.insertar(1);
    nodo.insertar(111);
    nodo.insertar(1254);
    nodo.insertar(1365);
    nodo.insertar(1023);
    nodo.insertar(15);
    nodo.insertar(107);
    nodo.insertar(105);
    nodo.insertar(1777);
    nodo.insertar(10000);
    nodo.insertar(13465);
    nodo.insertar(1234);
    nodo.insertar(14445);
    System.out.println(nodo.primero());
    nodo.mostrarComoArbol();
    System.out.println(nodo.eliminar());
    System.out.println(nodo.eliminar());
    System.out.println(nodo.eliminar());
    System.out.println(nodo.eliminar());
    System.out.println(nodo.eliminar());
    System.out.println(nodo.eliminar());
    System.out.println(nodo.eliminar());
    System.out.println(nodo.eliminar());
    System.out.println(nodo.eliminar());
    System.out.println(nodo.eliminar());
    System.out.println(nodo.eliminar());
    System.out.println(nodo.eliminar());
    System.out.println(nodo.eliminar());
    System.out.println(nodo.eliminar());
    System.out.println(nodo.eliminar());
    System.out.println(nodo.eliminar());
    System.out.println(nodo.eliminar());

    System.out.println("    ");
    nodo.mostrarComoArbol();
    


    }
}