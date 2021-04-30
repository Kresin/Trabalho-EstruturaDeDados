package model.pilha;

import model.listaencadeada.ListaEncadeada;
import model.tag.Tag;
import model.tag.TagContabilizada;
import model.tag.TagService;

public class PilhaTags<T> implements Pilha<T> {

    private ListaEncadeada<T> tags;
    private final TagService tagService = new TagService();
    private PilhaTagsContabilizadas<TagContabilizada> tagsContabilizadas = new PilhaTagsContabilizadas<>();
    private PilhaMensagensDeErro<String> mensagensDeErro = new PilhaMensagensDeErro<>();

    public PilhaTags() {
        tags = new ListaEncadeada<>();
    }

    @Override
    public void push(T info) {
        Tag tagAtual = (Tag) info;
        if (tagService.verificaTagDeFechamento(tagAtual.getNome())) {
            Tag tagParaFechar = (Tag) peek();
            if (tagService.verificaTagsCompativeis(tagParaFechar, tagAtual)) {
                TagContabilizada tagContabilizada = new TagContabilizada(((Tag)pop()).getNome(), 0);
                tagsContabilizadas.push(tagContabilizada);
            } else {
                mensagensDeErro.push("Foi encontrada uma tag final inesperada (aguardava-se a tag " + tagService.criaTagFinal(tagParaFechar) 
                        + " mas foi encontrada a tag " + tagAtual.getNome());
                pop();
            }
        } else {
            if (tagService.verificaSingletonTag(tagAtual.getNome())) {
                TagContabilizada tagContabilizada = new TagContabilizada(tagAtual.getNome(), 0);
                tagsContabilizadas.push(tagContabilizada);
            } else {
                if (tagService.verificaTagComposta(tagAtual.getNome())) {
                    tagAtual.setNome(tagService.extraiTagComposta(tagAtual.getNome()));
                }
                tags.inserir((T) tagAtual);
            }
        }
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
        if (estaVazia()) {
            //throw new PilhaVaziaExpetion();
        }
        return tags.getPrimeiro().getInfo();
    }

    @Override
    public boolean estaVazia() {
        return tags.estaVazia();
    }

    public int getQuantidadeTagsDoTipo(String tipo) {
        return 0;
    }

    public PilhaTagsContabilizadas<TagContabilizada> getTagsContabilizadas() {
        return tagsContabilizadas;
    }

    public PilhaMensagensDeErro<String> getMensagensDeErro() {
        return mensagensDeErro;
    }

}
