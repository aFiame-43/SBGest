package Server.Controller;

import Server.Model.*;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Controller {
    private final Magazzino magazzino;
    private final Menu menu;

    public Controller(Magazzino magazzino, Menu menu) {
        this.magazzino = magazzino;
        this.menu = menu;
    }

    public synchronized boolean isThereEnough(String nomeDomanda, int quantita){
        boolean isPresent = false;
        for(int i=0; i <= menu.getListOfValidItems().size(); i++){
            if(menu.getListOfValidItems().get(i).getNome().equals(nomeDomanda)){
                isPresent = true;
                ArrayList<Ingrediente> ingredientiPiattoRichiesto = menu.getListOfValidItems().get(i).getIngredienti();
                for(int j=0; j <= magazzino.getGiacenza().size(); j++){
                    String nomeIngredientePiattoRichiesto = ingredientiPiattoRichiesto.get(i).getNome();
                    int quantitaIngredientePiattoRichiesto = ingredientiPiattoRichiesto.get(i).getQuantita();
                    if(nomeIngredientePiattoRichiesto.equals(magazzino.getGiacenza().get(j).getNome()) && quantitaIngredientePiattoRichiesto > magazzino.getGiacenza().get(j).getQuantita()){
                        return false;
                    }
                }
            }
        }
        return isPresent;
    }

    public synchronized void nuovoOrdine(ArrayList<OrderItem> elementi, String numTavolo, String nomePersona, String cassiere, BigDecimal sconto){
        Ordine ordine = new Ordine(Ordine.newId(), numTavolo, nomePersona, cassiere);
        elementi.forEach(prodotto -> {
            ordine.addToComanda(prodotto.getNome(), prodotto.getQuantita());
            ordine.setPrezzo(ordine.getPrezzo().add(this.menu.getMenuItem(prodotto.getNome()).getPrezzo().multiply(BigDecimal.valueOf(prodotto.getQuantita()))));
            menu.getMenuItem(prodotto.getNome()).getIngredienti().forEach(magazzino::removeFromGiacenza);
        });
        ordine.setPrezzo(ordine.getPrezzo().subtract(sconto));
        ordine.setSconto(sconto);
        // TODO: il calcolo del prezzo lo dovrà fare il menu stesso, non il controller
        menu.addToOrdini(ordine);
    }

    public synchronized void nuovoMenuItem(String nome, BigDecimal prezzo, Dipartimento dipartimento, ArrayList<Ingrediente> ingredienti){
        MenuItem menuItem = new MenuItem(nome, prezzo);
        menuItem.setDipartimento(dipartimento);
        menuItem.setIngredienti(ingredienti);
        menu.addToMenu(menuItem);
    }

    public synchronized boolean arrivoInMagazzino(Ingrediente ingrediente){
        return magazzino.addToGiacenza(ingrediente);
    }

    public synchronized void modificaStatoOrdine(int id, StatoOrdine statoOrdine){
        menu.setStatoOrdine(id, statoOrdine);
    }

    public synchronized String vediOrdini(){
        return menu.vediOrdini();
    }




}