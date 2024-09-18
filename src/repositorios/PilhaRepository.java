package repositorios;
import java.util.ArrayList;

public class PilhaRepository<T> {
    private ArrayList<T> stackList;
    
    public PilhaRepository(ArrayList<T> pilha) {
    	this.stackList=pilha;
    }

    

    // push: coloca uma informação na pilha
    public void push(T value) {
        stackList.add(value);
    }

    // pop: retira uma informação da pilha
    public T pop() {
        if (!stackList.isEmpty()) {
            return stackList.remove(stackList.size() - 1);
        } else {
            return null;
        }
    }

    // size: retorna o tamanho da pilha
    public int size() {
        return stackList.size();
    }

    // stackpop: retorna o elemento superior da pilha sem removê-lo
    public T stackpop() {
        if (!stackList.isEmpty()) {
            return stackList.get(stackList.size() - 1);
        } else {
            return null;
        }
    }

    // empty: verifica se a pilha está vazia
    public boolean empty() {
        return stackList.isEmpty();
    }
}
