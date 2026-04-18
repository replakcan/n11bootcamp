package entity;

import java.util.ArrayList;

public class Cart {

    private ArrayList<CartItem> itemList;

    public Cart() {
        this.itemList = new ArrayList<>();
    }

    public ArrayList<CartItem> getItemList() {
        return itemList;
    }

    public void setItemList(ArrayList<CartItem> itemList) {
        this.itemList = itemList;
    }

    public double calculateCartTotal() {
        if (itemList.isEmpty()) {
            return 0.0;
        }

        double amount = 0.0;

        for (CartItem item : itemList) {
            amount += item.getPrice();
        }

        return amount;
    }

    public void addItem(CartItem item) {
        itemList.add(item);
    }

    public void dropItem(CartItem item) {
        itemList.remove(item);
    }

    public void emptyCart() {
        this.itemList.clear();
    }

    public void listCartItems() {
        System.out.println("START-----Cart-Items-----START");
        for (CartItem item : itemList) {
            item.printItemInfo();
            System.out.println("-----");
        }
        System.out.println("END-----Cart-Items-----END");
    }
}
