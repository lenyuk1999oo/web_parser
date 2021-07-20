package model;

import java.util.ArrayList;

public class Thinks {
    private ArrayList<Think> thinks;

    public Thinks() {
        thinks = new ArrayList<>();
    }


    public ArrayList<Think> getThinks() {
        return thinks;
    }

    public Thinks setThinks(ArrayList<Think> thinks) {
        this.thinks = thinks;
        return this;
    }

    public Thinks addThink(Think think) {
        this.thinks.add(think);
        return this;
    }
}
