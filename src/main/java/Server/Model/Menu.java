package Server.Model;

import java.util.ArrayList;

public class Menu {
    private final ArrayList<Piatto> listOfValidItems = new ArrayList<>();

    public void addToMenu(Piatto piatto){
        listOfValidItems.add(piatto);
    }

    public boolean isPresent(String nomeDomanda){
        for(int i=0; i<= listOfValidItems.size(); i++) {
            if (listOfValidItems.get(i).getNome().equals(nomeDomanda)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Piatto> getListOfValidItems() {
        return listOfValidItems;
    }
}
