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
public class Bill {

    private double balance;

    public Bill(double totalitemPrice, double totalcoins) {
        balance = totalcoins - totalitemPrice;
    }

    public double getBalance() {
        return balance;
    }
}
