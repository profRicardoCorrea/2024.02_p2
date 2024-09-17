package repositorios;
import java.util.ArrayList;
public class FilaRepository<T>  {
 
    private ArrayList<T> queueList;

    // Construtor
    public FilaRepository() {
        queueList = new ArrayList<>();
    }

    // insert ou enqueue: insere itens na fila (ao final)
    public void enqueue(T value) {
        queueList.add(value);
    }

    // remove ou dequeue: retira itens da fila (primeiro item)
    public T dequeue() {
        if (!queueList.isEmpty()) {
            return queueList.remove(0); // remove o primeiro elemento da fila
        } else {
            throw new RuntimeException("A fila está vazia.");
        }
    }

    // empty: verifica se a fila está vazia
    public boolean empty() {
        return queueList.isEmpty();
    }

    // size: retorna o tamanho da fila
    public int size() {
        return queueList.size();
    }

    // front: retorna o próximo item da fila sem retirar o mesmo da fila
    public T front() {
        if (!queueList.isEmpty()) {
            return queueList.get(0); // obtém o primeiro elemento sem removê-lo
        } else {
            throw new RuntimeException("A fila está vazia.");
        }
    }
}
