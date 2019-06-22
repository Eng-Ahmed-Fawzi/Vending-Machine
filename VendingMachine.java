/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Ahmed Fawzi
 */
public class VendingMachine {

    /**
     * @param args the command line arguments
     */
    private Inventory<Item> itemInventory = new Inventory<>();
    private Inventory<Coin> cashInventory = new Inventory<>();
    private ArrayList<Item> items = new ArrayList<>();
    private ArrayList<Coin> coins = new ArrayList<>();
    private ArrayList<Coin> remainingCoins;

    private boolean flag = true;
    private boolean flag2 = true;
    private double totalitemprice = 0.0;
    private double totalinputcoins = 0.0;
    private double balance = 0.0;

    public static void main(String[] args) {
        try {
            VendingMachine obj = new VendingMachine();
            obj.run(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run(String[] args) throws Exception {
        for (Item i : Item.values()) {
            itemInventory.put(i, 6);
        }
        for (Coin c : Coin.values()) {
            cashInventory.put(c, 5);
        }

        while (true) {
            if (flag) {
                mainWindow();
                Scanner sc = new Scanner(System.in);
                int inputItem = sc.nextInt();
                //sc.close();
                switch (inputItem) {
                    case 1:
                        if (checkExistenceOFItem(Item.CANDY)) {
                            items.add(Item.CANDY);
                            itemInventory.remove(Item.CANDY);
                            checkNewItem();
                        }
                        break;
                    case 2:
                        if (checkExistenceOFItem(Item.COKE)) {
                            items.add(Item.COKE);
                            itemInventory.remove(Item.COKE);
                            checkNewItem();
                        }
                        break;
                    case 3:
                        if (checkExistenceOFItem(Item.PEPSI)) {
                            items.add(Item.PEPSI);
                            itemInventory.remove(Item.PEPSI);
                            checkNewItem();
                        }
                        break;
                    case 4:
                        if (checkExistenceOFItem(Item.SODA)) {
                            items.add(Item.SODA);
                            itemInventory.remove(Item.SODA);
                            checkNewItem();
                        }
                        break;
                    case 5:
                        if (checkExistenceOFItem(Item.SNACK)) {
                            items.add(Item.SNACK);
                            itemInventory.remove(Item.SNACK);
                            checkNewItem();
                        }
                        break;
                    case 6:
                        if (checkExistenceOFItem(Item.NUTS)) {
                            items.add(Item.NUTS);
                            itemInventory.remove(Item.NUTS);
                            checkNewItem();
                        }
                        break;
                    case 7:
                        showAllAvailable();
                        break;
                        
                    default:
                        System.out.println("\nWrong choice\n");
                        break;
                }
            } else {
                totalitemprice = totalCost(items);
                System.out.println("\nTotal Cost = " + totalitemprice + "\n");
                if (flag2) {
                    coinsMainWindow();
                    Scanner sc = new Scanner(System.in);
                    int inputCoin = sc.nextInt();
                    //sc.close();
                    switch (inputCoin) {
                        case 1:
                            coins.add(Coin.PENNY);
                            addMoreCoins();
                            break;
                        case 2:
                            coins.add(Coin.NICKEL);
                            addMoreCoins();
                            break;
                        case 3:
                            coins.add(Coin.DIME);
                            addMoreCoins();
                            break;
                        case 4:
                            coins.add(Coin.QUARTER);
                            addMoreCoins();
                            break;
                        case 5:
                            coins.add(Coin.HALFDOLLAR);
                            addMoreCoins();
                            break;
                        case 6:
                            coins.add(Coin.ONEDOLLAR);
                            addMoreCoins();
                            break;
                        case 7:
                            coins.add(Coin.TWODOLLARS);
                            addMoreCoins();
                            break;
                        default:
                            System.out.println("\nWrong choice\n");
                            break;
                    }
                } else {
                    remainingCoins = new ArrayList<>();
                    totalinputcoins = totalCoins(coins);
                    System.out.println(totalinputcoins);
                    Bill B = new Bill(totalitemprice, totalinputcoins);
                    balance = B.getBalance();
                    System.out.println(balance);
                    getChange(coins, items, balance);
                    confirmAndPrintbalance(coins, remainingCoins);
                    items.clear();
                    coins.clear();
                    remainingCoins.clear();
                    flag = flag2 = true;
                }
            }
        }
    }

    private void showAllAvailable() {
        for (Item i : Item.values()) { 
            System.out.println("Having " + itemInventory.allAvailable(i) + " from " + i);
        }
    }

    private void mainWindow() {
        System.out.println("\nExisting items: CANDY(0.1), COKE(0.25), PEPSI(0.35), SODA(0.45), SNACK(0.5), NUTS(0.9)");
        System.out.println("For CANDY press '1'");
        System.out.println("For COKE press  '2'");
        System.out.println("For PEPSI press '3'");
        System.out.println("For SODA press  '4'");
        System.out.println("For SNACK press '5'");
        System.out.println("For NUTS press  '6'");
        System.out.println("Display the inventory available items  '7'");
    }

    private void coinsMainWindow() {
        System.out.println("\nInsert Coins: PENNY(0.01), NICKEL(0.50), DIME(0.10), QUARTER(0.25), HALFDOLLAR(0.50), ONEDOLLAR(1.00), TWODOLLARS(2.00)");
        System.out.println("For PENNY press      '1'");
        System.out.println("For NICKEL press     '2'");
        System.out.println("For DIME press       '3'");
        System.out.println("For QUARTER press    '4'");
        System.out.println("For HALFDOLLAR press '5'");
        System.out.println("For ONEDOLLAR press  '6'");
        System.out.println("For TWODOLLARS press '7'");
    }

    private void checkNewItem() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nDo You need another item?");
        System.out.println("For Yes press 'Y'");
        System.out.println("For NO press  'N'");
        char inputNewItem = sc.next().charAt(0);
        switch (inputNewItem) {
            case 'Y':
            case 'y': {
                flag = true;
                break;
            }
            case 'N':
            case 'n': {
                flag = false;
                break;
            }
            default:
                System.out.println("Wrong choice");
                checkNewItem();
        }
    }

    private void addMoreCoins() {
        System.out.println("\nWill You insert more Coins?");
        System.out.println("For Yes press 'Y'");
        System.out.println("For NO press  'N'");
        Scanner sc = new Scanner(System.in);
        char inputNewCoin = sc.next().charAt(0);
        switch (inputNewCoin) {
            case 'Y':
            case 'y': {
                flag2 = true;
                break;
            }
            case 'N':
            case 'n': {
                flag2 = false;
                break;
            }
            default:
                System.out.println("Wrong Choice");
                addMoreCoins();
        }
    }

    public boolean checkExistenceOFItem(Item item) throws SoldOutException {
        if (itemInventory.hasItem(item)) {
            return true;
        }
        throw new SoldOutException("Sold Out, Please buy another item");
    }

    public double totalCost(ArrayList<Item> items) {
        double totalitemPrice = 0.0;
        for (int counter = 0; counter < items.size(); counter++) {
            totalitemPrice += items.get(counter).getPrice();
        }
        return totalitemPrice;
    }

    public double totalCoins(ArrayList<Coin> coins) {
        double totalcoins = 0.0;
        for (int counter = 0; counter < coins.size(); counter++) {
            totalcoins += coins.get(counter).getMoney();
        }
        return totalcoins;
    }

    public void getChange(ArrayList<Coin> coins, ArrayList<Item> items, double balance) throws NotSufficientChangeException, NotFullPaidException {
        if (balance >= 0) {
            for (int counter = 0; counter < coins.size(); counter++) {
                cashInventory.add(coins.get(counter));
            }
        } else {
            for (int counter = 0; counter < items.size(); counter++) {
                itemInventory.add(items.get(counter));
            }
            throw new NotFullPaidException("Price not full paid, remaining : ", balance);
        }

        while (balance > 0) {
            if (balance < 0.01) {//as the smalest coin is 0.01 and double has a amall garbage value
                balance = 0.0;
            } else if (balance >= Coin.TWODOLLARS.getMoney() && cashInventory.hasItem(Coin.TWODOLLARS)) {
                remainingCoins.add(Coin.TWODOLLARS);
                cashInventory.remove(Coin.TWODOLLARS);
                balance = balance - Coin.TWODOLLARS.getMoney();

            } else if (balance >= Coin.ONEDOLLAR.getMoney() && cashInventory.hasItem(Coin.ONEDOLLAR)) {
                remainingCoins.add(Coin.ONEDOLLAR);
                cashInventory.remove(Coin.ONEDOLLAR);
                balance = balance - Coin.ONEDOLLAR.getMoney();

            } else if (balance >= Coin.HALFDOLLAR.getMoney() && cashInventory.hasItem(Coin.HALFDOLLAR)) {
                remainingCoins.add(Coin.HALFDOLLAR);
                cashInventory.remove(Coin.HALFDOLLAR);
                balance = balance - Coin.HALFDOLLAR.getMoney();

            } else if (balance >= Coin.QUARTER.getMoney() && cashInventory.hasItem(Coin.QUARTER)) {
                remainingCoins.add(Coin.QUARTER);
                cashInventory.remove(Coin.QUARTER);
                balance = balance - Coin.QUARTER.getMoney();

            } else if (balance >= Coin.DIME.getMoney() && cashInventory.hasItem(Coin.DIME)) {
                remainingCoins.add(Coin.DIME);
                cashInventory.remove(Coin.DIME);
                balance = balance - Coin.DIME.getMoney();

            } else if (balance >= Coin.NICKEL.getMoney() && cashInventory.hasItem(Coin.NICKEL)) {
                remainingCoins.add(Coin.NICKEL);
                cashInventory.remove(Coin.NICKEL);
                balance = balance - Coin.NICKEL.getMoney();

            } else if (balance >= Coin.PENNY.getMoney() && cashInventory.hasItem(Coin.PENNY)) {
                remainingCoins.add(Coin.PENNY);
                cashInventory.remove(Coin.PENNY);
                balance = balance - Coin.PENNY.getMoney();
            } else {
                throw new NotSufficientChangeException("NotSufficientChange,Please try another product");
            }
        }
    }

    private void confirmAndPrintbalance(ArrayList<Coin> coins, ArrayList<Coin> remainingCoins) {
        System.out.println("\nConfirm the order");
        System.out.println("For Yes press 'Y'");
        System.out.println("For NO press  'N'");
        Scanner sc = new Scanner(System.in);
        char Confirmation = sc.next().charAt(0);
        switch (Confirmation) {
            case 'Y':
            case 'y': {
                System.out.println("Done, Please receive the remaining Coins ");
                for (int counter = 0; counter < remainingCoins.size(); counter++) {
                    System.out.println(remainingCoins.get(counter));
                }
                break;
            }
            case 'N':
            case 'n': {
                System.out.println("Order canceled, Please receive the remaining Coins");
                for (int counter = 0; counter < coins.size(); counter++) {
                    System.out.println(coins.get(counter));
                }
                break;
            }
            default:
                System.out.println("Wrong Choice");
                confirmAndPrintbalance(coins, remainingCoins);
        }
    }
}
