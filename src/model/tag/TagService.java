package model.tag;

import model.pilha.PilhaTags;

public class TagService {

    public int verificaSeLinhaContemTags(int posicao, String linha) {
        return linha.indexOf("<", posicao);
    }

    public String obtemTag(int posicao, String linha) {
        if (posicao >= 0) {
            return linha.substring(posicao, linha.indexOf(">", posicao) + 1);
        }
        return "";
    }

    public boolean verificaTagDeFechamento(String tag) {
        return tag.contains("</");
    }

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

    public boolean verificaTagComposta(String tag) {
        return tag.trim().contains(" ");
    }

    public String extraiTagComposta(String tag) {
        return tag.substring(0, tag.indexOf(" ")) + ">";
    }

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

    public boolean verificaTagsCompativeis(Tag tagAbertura, Tag tagFechamento) {
        return tagAbertura.getNome().substring(1).equals(tagFechamento.getNome().substring(2));
    }

    public String criaTagFinal(Tag tag) {
        return "</" + tag.getNome().substring(1);
    }
    
    public String extraiTag(String tag) {
        return tag.replace("<", "").replace(">", "");
    }

}
