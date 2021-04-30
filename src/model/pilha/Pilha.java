package model.pilha;

public interface Pilha<T> {

    void push(T v);

    T pop();

    T peek();

    boolean estaVazia();

}
