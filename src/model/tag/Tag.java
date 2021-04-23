package model.tag;

public class Tag {
    private String nome;
    private boolean tagDeFechamento;
    private boolean estaFechada;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isTagDeFechamento() {
        return tagDeFechamento;
    }

    public void setTagDeFechamento(boolean tagDeFechamento) {
        this.tagDeFechamento = tagDeFechamento;
    }

    public boolean isEstaFechada() {
        return estaFechada;
    }

    public void setEstaFechada(boolean estaFechada) {
        this.estaFechada = estaFechada;
    }
}
