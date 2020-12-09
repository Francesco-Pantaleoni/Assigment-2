////////////////////////////////////////////////////////////////////
// FRANCESCO PANTALEONI 1193461
////////////////////////////////////////////////////////////////////
package it.unipd.tos.business;
import java.util.List;
import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.User;
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
        return total;
    }
}