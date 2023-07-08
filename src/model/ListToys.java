package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class ListToys {

    private final HashMap<String, Toy> ListToys;

    public ListToys() {
        ListToys = new HashMap<>();
    }

    public Toy getWinnerToy() {
        ArrayList<Toy> list = new ArrayList<>();
        for (Toy t: ListToys.values()) {
            for(int i = 0; i < t.getCount() * t.getPercent(); i++) {
                list.add(t);
            }
        }

        int id = new Random().nextInt(0, list.size());

        return list.get(id);

    }



    public void addToy(String name, int count) {
        int id = ListToys.size();
        Toy toy = new Toy(id, name, count);
        ListToys.put(name, toy);
    }
}
