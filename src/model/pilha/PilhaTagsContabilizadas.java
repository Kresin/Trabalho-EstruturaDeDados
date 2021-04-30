package model.pilha;

import model.listaencadeada.ListaEncadeada;
import model.tag.TagContabilizada;

public class PilhaTagsContabilizadas<T> implements Pilha<T> {

    private ListaEncadeada<T> tags = new ListaEncadeada<>();

    @Override
    public void push(T info) {
        tags.inserirTagContabilizada((TagContabilizada) info);
    }

    @Override
    public T pop() {
        T valor;
        valor = peek();
        tags.retirar(valor);

        return valor;
    }

    @Override
    public T peek() {
        return tags.getPrimeiro().getInfo();
    }

    @Override
    public boolean estaVazia() {
        return tags.estaVazia();
    }

    public int getTamanhoPilha() {
        return tags.tamanhoPilha();
    }

}
