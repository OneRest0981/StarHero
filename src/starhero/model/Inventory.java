package starhero.model;

import java.util.List;

public class Inventory {

    private List<Item> items;
    private int capacity;

    public Inventory(List<Item> items, int capacity) {
        this.items = items;
        this.capacity = capacity;
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public void removeItem(Item item) {
        this.items.remove(item);
    }

    public boolean hasItem(Item item) {
        return this.items.contains(item);
    }




}
