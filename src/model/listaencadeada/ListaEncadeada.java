package model.listaencadeada;

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
    private NoLista<T> obterUltimo() {
        NoLista<T> ultimo = primeiro;

        NoLista<T> p = primeiro;
        while (p != null) {
            ultimo = p;
            p = p.getProximo();
        }

        return ultimo;
    }

    /**
     * Exibe o conteúdo da lista encadeada começando a exibir primeiro a partir
     * do último elemento
     */
    public void exibirOrdemInversa() {
        NoLista<T> p = obterUltimo();

        while (p != null) {
            System.out.println(p.getInfo());
            p = p.getAnterior();
        }
    }

    /**
     * Remove todos os itens da lista
     */
    public void liberar() {
        NoLista<T> p = primeiro;
        while (p != null) {
            NoLista<T> backup = p.getProximo();
            p.setProximo(null);
            p.setAnterior(null);

            p = backup;
        }
    }

    /**
     * Retorna representação textual da lista
     */
    public String toString() {
        StringBuilder resultado = new StringBuilder();
        NoLista<T> p = primeiro;

        while (p != null) {
            if (p != primeiro) {
                resultado.append(",");
            }

            resultado.append(p.getInfo().toString());
            p = p.getProximo();
        }

        return resultado.toString();
    }

    public boolean estaVazia() {
        return primeiro == null;
    }

}
