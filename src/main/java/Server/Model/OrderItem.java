package Server.Model;

public class OrderItem {
    private String nome;
    private int quantita;

    public OrderItem(String nome, int quantita) {
        this.nome = nome;
        this.quantita = quantita;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "nome='" + nome + '\'' +
                ", quantita=" + quantita +
                '}';
    }
}
