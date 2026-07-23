package Server.Model;

public class Dipartimento {
    private String nome;
    private int stampanteId;

    public Dipartimento(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getStampanteId() {
        return stampanteId;
    }

    public void setStampanteId(int stampanteId) {
        this.stampanteId = stampanteId;
    }
}
