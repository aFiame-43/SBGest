package Server.Controller;

import Server.Model.Ingrediente;
import Server.Model.Magazzino;
import Server.Model.Menu;

import java.util.ArrayList;

public class Controller {
    private final Magazzino magazzino;
    private final Menu menu;

    public Controller() {
        this.magazzino = new Magazzino();
        this.menu = new Menu();
    }

    public boolean isThereEnough(String nomeDomanda, int quantita){
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


}