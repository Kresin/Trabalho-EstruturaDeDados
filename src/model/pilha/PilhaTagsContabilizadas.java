package model.pilha;

import model.listaencadeada.ListaEncadeada;
import model.tag.TagContabilizada;

public class PilhaTagsContabilizadas<T> implements Pilha<T> {

    private ListaEncadeada<T> tags = new ListaEncadeada<>();

    @Override
    public void push(T info) {
        tags.inserirTagContabilizada((TagContabilizada) info);
    }

    /*public void push(Tag info) {
        tags.inserirTagContabilizada((Tag)info);
    }*/
    @Override
    public T pop() {
        T valor;
        valor = peek();
        tags.retirar(valor);

        return valor;
    }

    @Override
    public T peek() {
        if (estaVazia()) {
            //throw new PilhaVaziaExpetion();
        }
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
