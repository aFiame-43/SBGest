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
}
