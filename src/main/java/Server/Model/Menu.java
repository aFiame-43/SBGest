package Server.Model;

import java.util.ArrayList;

public class Menu {
    private final ArrayList<MenuItem> listOfValidItems = new ArrayList<>();
    private final ArrayList<Ordine> ordiniTutti = new ArrayList<>();

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

    public ArrayList<Ordine> getOrdini() {
        return ordiniTutti;
    }

    public void addToOrdini(Ordine ordine){
        ordiniTutti.add(ordine.getId()-1, ordine);
    }

    public void setStatoOrdine(int id, StatoOrdine statoOrdine){
        ordiniTutti.get(id-1).setStatoOrdine(statoOrdine);
    }

    @Override
    public String toString() {
        return "Menu{" +
                listOfValidItems +
                '}';
    }

    public String vediOrdini(){
        final StringBuilder temp = new StringBuilder("Ordini: ");
        ordiniTutti.forEach(currOrdine -> temp.append(currOrdine.toString()));
        return temp.toString();
    }
}
