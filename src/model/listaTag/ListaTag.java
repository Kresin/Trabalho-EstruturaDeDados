package model.listaTag;
import model.listaencadeada.*;
import model.tag.Tag;

public class ListaTag {

    private NoListaTag primeiro;

    public ListaTag() {
        primeiro = null;
    }

    public NoListaTag getPrimeiro() {
        return primeiro;
    }

    /**
     * Inclui um novo dado na estrutura de dados
     *
     * @param valor Dado a ser inserido na lista encadeada
     */
    public void inserir(Tag valor) {
        NoListaTag novo = new NoListaTag();
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
    public NoListaTag buscar(Tag valor) {
        NoListaTag p = primeiro;

        while (p != null) {
            if (p.getInfo().equals(valor)) {
                return p;
            }
            p = p.getProximo();
        }
        return null;
    }

    public NoListaTag buscar(String tagNome) {
        NoListaTag p = primeiro;

        while (p != null) {
            if (p.getInfo().getNome().equals(tagNome)) {
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
    public void retirar(Tag valor) {
        NoListaTag p = buscar(valor);

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
    public NoListaTag obterUltimo() {
        NoListaTag ultimo = primeiro;

        NoListaTag p = primeiro;
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
        NoListaTag p = obterUltimo();

        while (p != null) {
            System.out.println(p.getInfo().getNome());
            p = p.getAnterior();
        }
    }

    /**
     * Remove todos os itens da lista
     */
    public void liberar() {
        NoListaTag p = primeiro;
        while (p != null) {
            NoListaTag backup = p.getProximo();
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
        NoListaTag p = primeiro;

        while (p != null) {
            if (p != primeiro) {
                resultado.append(",");
            }

            resultado.append(p.getInfo().getNome());
            resultado.append(" " + p.getInfo().getNumInvokes());
            p = p.getProximo();
        }

        return resultado.toString();
    }

    public boolean estaVazia() {
        return primeiro == null;
    }

}
