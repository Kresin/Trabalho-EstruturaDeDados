package model.pilha;

import model.listaencadeada.ListaEncadeada;

public class PilhaMensagensDeErro<T> implements Pilha<T> {

    private ListaEncadeada<T> erros = new ListaEncadeada<>();

    @Override
    public void push(T v) {
        erros.inserir(v);
    }

    @Override
    public T pop() {
        T valor;
        valor = peek();
        erros.retirar(valor);

        return valor;
    }

    /**
     * Remove o último valor da pilha.
     * 
     * @return
     */
    public T inversePop() {
        T valor;
        valor = inversePeek();
        erros.retirar(valor);

        return valor;
    }

    @Override
    public T peek() {
        return erros.getPrimeiro().getInfo();
    }

    /**
     * Obtém o último valor da pilha.
     * 
     * @return
     */
    public T inversePeek() {
        return erros.obterUltimo().getInfo();
    }

    @Override
    public boolean estaVazia() {
        return erros.estaVazia();
    }

}
