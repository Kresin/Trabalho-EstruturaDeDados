package model.listaencadeada;

import model.tag.TagContabilizada;

public class ListaEncadeada<T> {

    private NoLista<T> primeiro;

    public ListaEncadeada() {
        primeiro = null;
    }

    public NoLista<T> getPrimeiro() {
        return primeiro;
    }

    /**
     * Inclui um novo dado na estrutura de dados
     *
     * @param valor Dado a ser inserido na lista encadeada
     */
    public void inserir(T valor) {
        NoLista<T> novo = new NoLista<>();
        novo.setInfo(valor);
        novo.setProximo(primeiro);
        novo.setAnterior(null);
        if (primeiro != null) {
            primeiro.setAnterior(novo);
        }
        primeiro = novo;
    }
    
    /**
     * Insere um objeto do tipo TagContabilizada em uma pilha de TagContabilizada.
     * 
     * @param tag Tag a ser adicionada.
     */
    public void inserirTagContabilizada(TagContabilizada tag) {
        TagContabilizada tagContabilizada = buscarTagContabilizada(tag);
        if (tagContabilizada != null) {
            tagContabilizada.setQuantidade(tagContabilizada.getQuantidade() + 1);
        } else {
            inserir((T) new TagContabilizada(tag.getNome(), 1));
        }
    }

    /**
     * Busca um nó na estrutura de dados que estja armazenando o dado fornecido
     * como argumento
     *
     * @param valor Valor a ser localizado
     * @return Nó contendo o dado
     */
    public NoLista<T> buscar(T valor) {
        NoLista<T> p = primeiro;

        while (p != null) {
            if (p.getInfo().equals(valor)) {
                return p;
            }
            p = p.getProximo();
        }

        return null;
    }
    
    /**
     * Busca um objeto do tipo TagContabilizada em uma lista de TagContabilizada.
     * Caso o objeto fornecido por parâmetro não seja encontrado, é retornado null
     * no lugar.
     * 
     * @param tag  Objeto a ser buscado na lista.
     * @return Objeto encontrado.
     */
    public TagContabilizada buscarTagContabilizada(TagContabilizada tag) {
        if (estaVazia()) {
            return null;
        }
        NoLista<TagContabilizada> tagContabilizada = (NoLista<TagContabilizada>) primeiro;
        
        while (tagContabilizada != null && !tagContabilizada.getInfo().getNome().equals(tag.getNome())) {            
            tagContabilizada = tagContabilizada.getProximo();
        }
        
        if (tagContabilizada != null) {
            return tagContabilizada.getInfo();
        } else {
            return null;
        }
    }

    /**
     * Retira da estrutura de dados um dado armazenado na lista
     *
     * @param valor Valor a ser retirado
     */
    public void retirar(T valor) {
        NoLista<T> p = buscar(valor);

        if (p != null) {
            if (primeiro == p) {
                primeiro = p.getProximo();
            } else {
                p.getAnterior().setProximo(p.getProximo());
            }
            if (p.getProximo() != null) {
                p.getProximo().setAnterior(p.getAnterior());
            }
        }
    }
    
    /**
     * Retorna o último elemento da lista encadeada
     *
     * @return Nó armazenado na última posição
     */
    public NoLista<T> obterUltimo() {
        NoLista<T> ultimo = primeiro;

        NoLista<T> p = primeiro;
        while (p != null) {
            ultimo = p;
            p = p.getProximo();
        }

        return ultimo;
    }

    /**
     * Veridica se a lista está vazia.
     * 
     * @return Valor booleano indicando se a lista está vazia.
     */
    public boolean estaVazia() {
        return primeiro == null;
    }
    
    /**
     * Conta quantos registros existem na pilha.
     * 
     * @return Quantidade de elementos.
     */
    public int tamanhoPilha() {
        int tamanho = 0;
        NoLista<T> p = primeiro;
        
        while (p != null) {    
            tamanho ++;
            p = p.getProximo();
        }
        return tamanho;
    }

}
