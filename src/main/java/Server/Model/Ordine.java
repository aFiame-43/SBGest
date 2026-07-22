package Server.Model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Ordine {
    private final int id;
    private StatoOrdine statoOrdine;
    private String numTavolo;
    private String nomePersona;
    private final LocalDateTime oraCreazione;
    private LocalDateTime oraInvioCucina;
    private LocalDateTime oraPronto;
    private LocalDateTime oraConsegna;
    private Cassiere cassiere;

    private final ArrayList<OrderItem> comanda = new ArrayList<>();

    public Ordine (int id, String numTavolo, String nomePersona){
        this.id = id;
        this.numTavolo = numTavolo;
        this.nomePersona = nomePersona;
        this.statoOrdine = StatoOrdine.CREATO;
        this.oraCreazione = LocalDateTime.now();
    }

    public double getId() {
        return id;
    }

    public StatoOrdine getStatoOrdine() {
        return statoOrdine;
    }

    public String getNumTavolo() {
        return numTavolo;
    }

    public String getNomePersona() {
        return nomePersona;
    }

    public LocalDateTime getOraCreazione() {
        return oraCreazione;
    }

    public LocalDateTime getOraInvioCucina() {
        return oraInvioCucina;
    }

    public LocalDateTime getOraPronto() {
        return oraPronto;
    }

    public LocalDateTime getOraConsegna() {
        return oraConsegna;
    }

    public Cassiere getCassiere() {
        return cassiere;
    }

    public ArrayList<OrderItem> getComanda() {
        return comanda;
    }

    public void setStatoOrdine(StatoOrdine statoOrdine) {
        this.statoOrdine = statoOrdine;
    }

    public void setNumTavolo(String numTavolo) {
        this.numTavolo = numTavolo;
    }

    public void setNomePersona(String nomePersona) {
        this.nomePersona = nomePersona;
    }

    public void setOraInvioCucina(LocalDateTime oraInvioCucina) {
        this.oraInvioCucina = oraInvioCucina;
    }

    public void setOraPronto(LocalDateTime oraPronto) {
        this.oraPronto = oraPronto;
    }

    public void setOraConsegna(LocalDateTime oraConsegna) {
        this.oraConsegna = oraConsegna;
    }

    public void addToComanda(String item, int num) {
        OrderItem orderItem = new OrderItem(item, num);
        comanda.add(orderItem);
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return "Ordine{" +
                "id=" + id +
                ", statoOrdine=" + statoOrdine +
                ", numTavolo='" + numTavolo + '\'' +
                ", nomePersona='" + nomePersona + '\'' +
                ", oraCreazione=" + oraCreazione.format(formatter) +
                ", oraInvioCucina=" + oraInvioCucina +
                ", oraPronto=" + oraPronto +
                ", oraConsegna=" + oraConsegna +
                ", comanda=" + comanda +
                '}';
    }
}
