package model.tag;

public class TagContabilizada {
    
    private String Nome;
    private int quantidade;

    public TagContabilizada(String Nome, int quantidade) {
        this.Nome = Nome;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

}
