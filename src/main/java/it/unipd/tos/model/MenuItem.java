////////////////////////////////////////////////////////////////////
// FRANCESCO PANTALEONI 1193461
////////////////////////////////////////////////////////////////////
package it.unipd.tos.model;

public class MenuItem {

    public enum type {Gelato,Budino,Bevanda}

    private type item;
    private String name;
    private double price;

    public MenuItem(type itemtype, String nome, double prezzo) {
        this.item = itemtype;
        this.name = nome;
        this.price = prezzo;
    }

    public type getItem() {
        return item;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}