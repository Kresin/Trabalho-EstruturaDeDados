package model.tag;

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
        } else if (tag.equals(SingletonTagsEnum.DOCKTYPE.getValue())) {
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

}
