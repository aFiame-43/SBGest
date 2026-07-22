package Server.Model;

import java.util.ArrayList;

public class Menu {
    private final ArrayList<MenuItem> listOfValidItems = new ArrayList<>();

    public void addToMenu(MenuItem prodottoPerMenu){
        listOfValidItems.add(prodottoPerMenu);
    }

    public boolean isPresent(String nomeDomanda){
        for(int i=0; i<= listOfValidItems.size(); i++) {
            if (listOfValidItems.get(i).getNome().equals(nomeDomanda)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<MenuItem> getListOfValidItems() {
        return listOfValidItems;
    }

    public MenuItem getMenuItem(String nomeDomanda) {
        for(int i=0; i<= listOfValidItems.size(); i++) {
            if (listOfValidItems.get(i).getNome().equals(nomeDomanda)) {
                return listOfValidItems.get(i);
            }
        }
        return null;
    }
}
