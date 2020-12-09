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
                if ((cheapestIce == null) || (gelatoMenoCostoso.getPrice() > i.getPrice())) {
                    cheapestIce = i;
                }
            }
        }
        //sconto 50
        if (cheapestIce > 5) {
            total -= gelatoMenoCostoso.getPrice() * 0.5;
        }
        return total;
    }
} 