////////////////////////////////////////////////////////////////////
// FRANCESCO PANTALEONI 1193461
////////////////////////////////////////////////////////////////////
package it.unipd.tos.business;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;


import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.User;
import it.unipd.tos.business.TotalBill;
import it.unipd.tos.business.exception.TakeAwayBillException;

public class TakeAwayDiscount implements TakeAwayBill {
    public double getOrderPrice(List < MenuItem > itemsOrdered, User user) throws TakeAwayBillException {
        double total = 0.0;
        int ice = 0;
        MenuItem cheapestIce = null;
        double IcePud = 0.0;

        if (itemsOrdered == null) {
            throw new TakeAwayBillException("La lista è vuota");
        }

        if (itemsOrdered.contains(null)) {
            throw new TakeAwayBillException("Nella lista è presente un elemento vuoto");
        }

        for (MenuItem i: itemsOrdered) {
            total += i.getPrice();
            if (i.getItemType() == MenuItem.type.Gelato) {
                ice++;
                IcePud += i.getPrice();
                if ((cheapestIce == null) || (cheapestIce.getPrice() > i.getPrice())) {
                    cheapestIce = i;
                }
            }
            if (i.getItemType() == MenuItem.type.Budino) {
                IcePud += i.getPrice();
            }
        }
        //sconto 50
        if (ice > 5) {
            total -= cheapestIce.getPrice() * 0.5;
        }
        //sconto 10
        if (IcePud > 50) {
            total -= total * 0.1;
        }
        //limite30
        if (itemsOrdered.size() > 30) {
            throw new TakeAwayBillException("La lista supera il massimo di 30 elementi");
        }
        //commissione
        if (total < 10) {
            total += 0.50;
        }
        return total;
    }
    public List < TotalBill > FreeBills(List < TotalBill > bills) {

        List < TotalBill > gratis = new ArrayList < TotalBill > ();

        for (TotalBill i: bills) {
            if (i.getUser().getAge() < 18 && (!gratis.contains(i)) && gratis.size() < 10 && i.getTime() >= 64800 && i.getTime() <= 68400) {
                Random rand = new Random();
                if (rand.nextBoolean()) {
                    gratis.add(i);
                }
            }
        }
        for (TotalBill i: gratis) {
            i.changePrice(0.00);
        }
        return gratis;
    }
} 