package prin;

import implementaciones.HeapsEstaticoMax;
import interfaces.HeapsTDA;

public class prinEstaticoMax {
    public static void main(String[] args) {
    HeapsTDA heap = new HeapsEstaticoMax(); //Crea el heap.
    heap.InicializarHeap(); //Inicializa.
    System.out.println("El heap está vacío? "+heap.heapVacio()); //Está vacío?
    heap.insertar(5);
    heap.insertar(7);
    heap.insertar(3);
    heap.insertar(8);
    heap.insertar(1);
    heap.insertar(111);
    heap.insertar(1254);
    heap.insertar(1365);
    heap.insertar(1023);
    System.out.println("");
    System.out.println("El heap está vacío? "+heap.heapVacio()); //Está vacío?

    heap.insertar(15);
    heap.insertar(107);
    heap.insertar(105);
    heap.insertar(1777);
    heap.insertar(10000);
    heap.insertar(13465);
    heap.insertar(1234);
    heap.insertar(14445);
    //Inserta valores.
    System.out.println("El heap padre de este heap es: " + heap.primero()); //Muestra valor de la raiz.
    System.out.println(" ");
    heap.mostrarComoArbol(); //Muestra el heap.
    System.out.println(" ");
    System.out.println("Se elimina el heap padre: "+heap.eliminar()); //Elimina la raiz.
    System.out.println(" ");
    System.out.println("Después de la eliminación, el heap queda así: ");
    heap.mostrarComoArbol(); //Vuelve a mostrar el heap, ordenado nuevamente después de la eliminación.




    }
}