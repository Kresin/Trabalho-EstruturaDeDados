package model.tag;

import model.pilha.PilhaTags;

/**
 * Classe contendo métodos úteis para manipulação das Tags
 */
public class TagService {

    /**
     * Veridica se existe alguma tag na linha fornecida por parâmetro a partir da posição especificada.
     * Caso alguma tag for encontrada é retornado a posição da abertura da tag, caso não seja encontrado nada,
     * é retornado o valor -1.
     * 
     * @param posicao Posição inicial do ponteiro para percorrer a String.
     * @param linha
     * @return Posição da abertura da tag.
     */
    public int verificaSeLinhaContemTags(int posicao, String linha) {
        return linha.indexOf("<", posicao);
    }

    /**
     * Extrai uma tag da linha a partir da posição especificada.
     * 
     * @param posicao Posição inicial do ponteiro para extrair a tag.
     * @param linha
     * @return Tag no formato "<nomeTag>".
     */
    public String obtemTag(int posicao, String linha) {
        if (posicao >= 0) {
            return linha.substring(posicao, linha.indexOf(">", posicao) + 1);
        }
        return "";
    }

    /**
     * Verifica se a tag atual é uma tag de fechamento.
     * 
     * @param tag Tag a ser verificada.
     * @return Valor booleano indicando se a tag é de fechamento.
     */
    public boolean verificaTagDeFechamento(String tag) {
        return tag.contains("</");
    }

    /**
     * Verifica se a tag atual é uma tag do tipo Singleton.
     * 
     * @param tag Tag a ser verificada.
     * @return Valor booleano indicando se é uma tag Singleton.
     */
    public boolean verificaSingletonTag(String tag) {
        if (tag.equals(SingletonTagsEnum.BASE.getValue())) {
            return true;
        } else if (tag.equals(SingletonTagsEnum.BR.getValue())) {
            return true;
        } else if (tag.equals(SingletonTagsEnum.COL.getValue())) {
            return true;
        } else if (tag.equals(SingletonTagsEnum.COMMAND.getValue())) {
            return true;
        } else if (tag.equals(SingletonTagsEnum.DOCTYPE.getValue())) {
            return true;
        } else if (tag.equals(SingletonTagsEnum.EMBED.getValue())) {
            return true;
        } else if (tag.equals(SingletonTagsEnum.HR.getValue())) {
            return true;
        } else if (tag.equals(SingletonTagsEnum.IMG.getValue())) {
            return true;
        } else if (tag.equals(SingletonTagsEnum.INPUT.getValue())) {
            return true;
        } else if (tag.equals(SingletonTagsEnum.LINK.getValue())) {
            return true;
        } else if (tag.equals(SingletonTagsEnum.META.getValue())) {
            return true;
        } else if (tag.equals(SingletonTagsEnum.PARAM.getValue())) {
            return true;
        } else if (tag.equals(SingletonTagsEnum.SOURCE.getValue())) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Verifica se a tag atual é uma tag composta.
     * 
     * @param tag Tag a ser veridicada.
     * @return Valor booleano indicando se é uma tag composta.
     */
    public boolean verificaTagComposta(String tag) {
        return tag.trim().contains(" ");
    }

    /**
     * Extrai os parâmetros de uma tag composta retornando uma tag simples no lugar.
     * 
     * @param tag Tag composta a ser extraída.
     * @return Tag simplificada.
     */
    public String extraiTagComposta(String tag) {
        return tag.substring(0, tag.indexOf(" ")) + ">";
    }

    /**
     * Adiciona todas as tags da linha em uma pilha de Tags.
     * 
     * @param linha Linha contendo as tags.
     * @param pilhaLista Pilha onde será adicionada as tags.
     */
    public void adicionaTagsDaLinha(String linha, PilhaTags<Tag> pilhaLista) {
        boolean primeiraBusca = true;
        int indice = 0;

        while (indice > -1) {
            if (primeiraBusca) {
                indice = verificaSeLinhaContemTags(indice, linha);
                primeiraBusca = false;
                if (indice != -1) {
                    Tag tag = new Tag(obtemTag(indice, linha));
                    pilhaLista.push(tag);
                }
            } else {
                indice = verificaSeLinhaContemTags(indice + 1, linha);
                if (indice != -1) {
                    Tag tag = new Tag(obtemTag(indice, linha));
                    pilhaLista.push(tag);
                }
            }
        }
    }

    /**
     * Verifica se um determinado par de tags são compatíveis.
     * 
     * @param tagAbertura Tag de abertura.
     * @param tagFechamento Tag de fechamento.
     * @return Valor booleano indicando se as tags são compatíveis.
     */
    public boolean verificaTagsCompativeis(Tag tagAbertura, Tag tagFechamento) {
        return tagAbertura.getNome().substring(1).equals(tagFechamento.getNome().substring(2));
    }

    /**
     * Cria uma tag final compatível com a tag fornecida por parâmetro.
     * 
     * @param tag Tag a ser elaborada a teag final.
     * @return Tag final compatível com atag passada por parâmetro.
     */
    public String criaTagFinal(Tag tag) {
        return "</" + tag.getNome().substring(1);
    }
    
    /**
     * Extrai o nome da tag.
     * 
     * @param tag Tag a ter o nome extraído.
     * @return Nome da tag.
     */
    public String extraiTag(String tag) {
        return tag.replace("<", "").replace(">", "");
    }

}
