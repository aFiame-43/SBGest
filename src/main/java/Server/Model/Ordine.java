package Server.Model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Ordine {
    public static int contatoreOrdini = 0;
    private final int id;
    private StatoOrdine statoOrdine;
    private String numTavolo;
    private String nomePersona;
    private BigDecimal prezzo;
    private BigDecimal sconto;
    private final LocalDateTime oraCreazione;
    private LocalDateTime oraInvioCucina;
    private LocalDateTime oraPronto;
    private LocalDateTime oraConsegna;
    private String cassiere;

    private final ArrayList<OrderItem> comanda = new ArrayList<>();

    public Ordine (int id, String numTavolo, String nomePersona, String cassiere){
        this.id = id;
        this.numTavolo = numTavolo;
        this.nomePersona = nomePersona;
        this.statoOrdine = StatoOrdine.CREATO;
        this.oraCreazione = LocalDateTime.now();
        this.cassiere = cassiere;
        this.prezzo = BigDecimal.valueOf(0);
        this.sconto = BigDecimal.valueOf(0);
    }

    public static int newId(){
        contatoreOrdini++;
        return contatoreOrdini;
    }

    public int getId() {
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

    public BigDecimal getPrezzo() {
        return prezzo;
    }

    public BigDecimal getSconto() {
        return sconto;
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

    public String getCassiere() {
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

    public void setPrezzo(BigDecimal prezzo) {
        this.prezzo = prezzo;
    }

    public void setSconto(BigDecimal sconto) {
        this.sconto = sconto;
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

    public void setCassiere(String cassiere) {
        this.cassiere = cassiere;
    }

    public void addToComanda(String nome, int quantita) {
        OrderItem orderItem = new OrderItem(nome, quantita);
        comanda.add(orderItem);
    }

    public void sendOrdine(){
        this.setOraInvioCucina(LocalDateTime.now());
        //altre azioni da definire
    }

    @Override
    public String toString() {
        return "Ordine{" +
                "id=" + id +
                ", statoOrdine=" + statoOrdine +
                ", numTavolo='" + numTavolo + '\'' +
                ", nomePersona='" + nomePersona + '\'' +
                ", prezzo=" + prezzo +
                ", sconto=" + sconto +
                ", oraCreazione=" + oraCreazione +
                ", oraInvioCucina=" + oraInvioCucina +
                ", oraPronto=" + oraPronto +
                ", oraConsegna=" + oraConsegna +
                ", cassiere='" + cassiere + '\'' +
                ", comanda=" + comanda.toString() +
                '}';
    }
}
