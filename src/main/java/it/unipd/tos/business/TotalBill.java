////////////////////////////////////////////////////////////////////
// FRANCESCO PANTALEONI 1193461
////////////////////////////////////////////////////////////////////
package it.unipd.tos.business;

import java.util.List;
import java.time.LocalTime;

import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.User;

public class TotalBill {

    private List < MenuItem > list;
    private User user;
    private LocalTime time;
    private double price;

    public TotalBill(List < MenuItem > list, User user, LocalTime time, double price) {
        this.list = list;
        this.user = user;
        this.time = time;
        this.price = price;
    }

    public List < MenuItem > getList() {
        return list;
    }

    public User getUser() {
        return user;
    }

    public int getTime() {
        return ((time.getHour() * 60 * 60) + (time.getMinute() * 60) + time.getSecond());
    }


    public double getPrice() {
        return price;
    }

    public void changePrice(double p) {
        price = p;
    }

} 