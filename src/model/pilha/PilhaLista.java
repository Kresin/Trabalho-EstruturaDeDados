package model.pilha;

import model.listaencadeada.ListaEncadeada;

public class PilhaLista<T> implements Pilha<T> {

    private ListaEncadeada<T> lista;
    private boolean listaValida;
    private PilhaLista<T> tagsParaFechar;

    public PilhaLista() {
        lista = new ListaEncadeada<T>();
    }

    @Override
    public void push(T info) {
        lista.inserir(info);
    }

    @Override
    public T pop() {
        T valor;
        valor = peek();
        lista.retirar(valor);

        return valor;
    }

    @Override
    public T peek() {
        if (estaVazia()) {
            //throw new PilhaVaziaExpetion();
        }
        return lista.getPrimeiro().getInfo();
    }

    @Override
    public boolean estaVazia() {
        return lista.estaVazia();
    }

    @Override
    public void liberar() {
        while (!estaVazia()) {
            pop();
        }
    }

    @Override
    public String toString() {
        return lista.toString();
    }

    public int getQuantidadeTagsDoTipo(String tipo) {
        return 0;
    }

    public boolean isListaValida() {
        return listaValida;
    }
    
}
