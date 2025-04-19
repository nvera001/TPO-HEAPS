package interfaces;

public interface HeapsTDA {
    void InicializarHeap(); // Inicializa la estructura

    void insertar(int valor);    

    int eliminar();    

    int primero();     // Devuelve el mayor o menor valor del elemento. 

    boolean heapVacio();        // Informa si el heap está vacío
    
    void mostrarComoArbol();
}