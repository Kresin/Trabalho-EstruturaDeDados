package model.tag;

public class Tag {
    private String nome;
    private boolean tagDeFechamento;
    private boolean estaFechada;
    private int numInvokes;

    public Tag(String nome){
        this.nome = nome;
        tagDeFechamento = false;
        estaFechada = false;
        numInvokes = 0;
    }

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

    public boolean estaFechada() {
        return estaFechada;
    }

    public void setEstaFechada(boolean estaFechada) {
        this.estaFechada = estaFechada;
    }

    public int getNumInvokes() {
        return numInvokes;
    }

    public void incrementaInvokes(){
        numInvokes++;
    }
}
