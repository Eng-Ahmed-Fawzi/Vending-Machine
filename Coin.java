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
public enum Coin {
    PENNY(0.01), NICKEL(0.05), DIME(0.1), QUARTER(0.25), HALFDOLLAR(0.5), ONEDOLLAR(1.00), TWODOLLARS(2.00);

    private final double money;

    private Coin(double money) {
        this.money = money;
    }

    public double getMoney() {
        return money;
    }
}
