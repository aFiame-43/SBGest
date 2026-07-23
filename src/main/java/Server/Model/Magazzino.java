package Server.Model;

import java.util.ArrayList;

public class Magazzino {
    private final ArrayList<Ingrediente> giacenza;

    public Magazzino() {
        this.giacenza = new ArrayList<>();
    }

    public ArrayList<Ingrediente> getGiacenza() {
        return giacenza;
    }

    public boolean addToGiacenza(Ingrediente arrivo){
        giacenza.forEach(elemento -> {
            if(elemento.getNome().equals(arrivo.getNome())){
                elemento.setQuantita(elemento.getQuantita() + arrivo.getQuantita());
                arrivo.setQuantita(0);
            }
        });
        return arrivo.getQuantita()==0;
    }

    public boolean removeFromGiacenza(Ingrediente rimozione){
        giacenza.forEach(elemento -> {
            if(elemento.getNome().equals(rimozione.getNome())){
                elemento.setQuantita(elemento.getQuantita() - rimozione.getQuantita());
                rimozione.setQuantita(0);
            }
        });
        return rimozione.getQuantita()==0;
    }
}
