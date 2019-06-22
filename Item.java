/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine;

/**
 *
 * @author Ahmed Fawzi
 */
public enum Item {

    CANDY("Candy", 0.1), COKE("Coke", 0.25), PEPSI("Pepsi", 0.35), SODA("Soda", 0.45), SNACK("Snack", 0.5), NUTS("Nuts", 0.9);

    private final String name;
    private final double price;

    private Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
