/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Ahmed Fawzi
 * @param <T>
 */
public class Inventory<T> {

    private final Map<T, Integer> inventory = new HashMap<>();

    public int getQuantity(T item) {
        Integer value = inventory.get(item);
        return value;
    }

    public void add(T item) {
        int count = inventory.get(item);
        inventory.put(item, count + 1);
    }

    public void remove(T item) {
        if (hasItem(item)) {
            int count = inventory.get(item);
            inventory.put(item, count - 1);
        }
    }

    public boolean hasItem(T item) {
        if (getQuantity(item) > 0) {
            return true;
        } else {
            return false;
        }
    }

    public void put(T item, int quantity) {
        inventory.put(item, quantity);
    }

    public int allAvailable(T item) {
        int value = inventory.get(item);
        return value;
    }
}
