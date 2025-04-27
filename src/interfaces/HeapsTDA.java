package interfaces;

public interface HeapsTDA {
    void InicializarHeap(); // Inicializa la estructura.

    void insertar(int valor); //Agrega valores al heap.

    int eliminar(); //Elimina la raiz del heap.

    int primero();     // Devuelve el mayor o menor valor del elemento. 

    boolean heapVacio();        // Informa si el heap está vacío.
    
    void mostrarComoArbol(); //Muestra el heap.
}