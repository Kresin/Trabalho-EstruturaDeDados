package model.listaTag;

import model.tag.Tag;
import model.listaencadeada.NoLista;

public class NoListaTag {

    private Tag info;
    private NoListaTag proximo;
    private NoListaTag anterior;

    public Tag getInfo() {
        return info;
    }

    public void setInfo(Tag info) {
        this.info = info;
    }

    public NoListaTag getProximo() {
        return proximo;
    }

    public void setProximo(NoListaTag proximo) {
        this.proximo = proximo;
    }

    public NoListaTag getAnterior() {
        return anterior;
    }

    public void setAnterior(NoListaTag anterior) {
        this.anterior = anterior;
    }

}
