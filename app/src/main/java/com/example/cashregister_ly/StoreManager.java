package com.example.cashregister_ly;

import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;

public class StoreManager {

    ArrayList<Product> inventory;
    ArrayList<History> purchaseHistory = new ArrayList<>(0);

    public StoreManager(){
   this.inventory = new ArrayList<>(3);
    Product pants = new Product("pants",20,39.99);
    Product shirts = new Product("shirts",100,29.99);
    Product shoes = new Product("shoes",50,89.99);
        inventory.add(pants);
        inventory.add(shirts);
        inventory.add(shoes);
    }

    public boolean inStock(Product p, int userQnt){
        if (userQnt>p.getQuantity()) {
            return false;
        } return true;
    }

    public History newPurchase(String n,int qnt,double price,String date) {
        History newProduct = new History(n,qnt,price,date);
        return newProduct;
    }
    public void restock() {

    }


}
