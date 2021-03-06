package it.unipd.tos.business;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.time.LocalTime;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.User;
import it.unipd.tos.business.TotalBill;
import it.unipd.tos.business.exception.TakeAwayBillException;

public class TakeAwayTest {

	TakeAwayDiscount bill;
	User user;
	double total;
	List<MenuItem> list;
	private static final double Diff = 1e-3;

	@Before
	public void setup() {
		bill = new TakeAwayDiscount();
		total = 0.00;
		list = new ArrayList<MenuItem>();
		user = new User("Gabriele","Filippi",21);
	}

	@Test
	public void sumTest() throws TakeAwayBillException {

        list.add(new MenuItem(MenuItem.type.Budino, "Asdrubale", 8.00));
        list.add(new MenuItem(MenuItem.type.Gelato, "Panna", 6.00));
        list.add(new MenuItem(MenuItem.type.Bevanda, "Coca", 2.50));

        total = bill.getOrderPrice(list,user);

        assertEquals(16.50,total,Diff);
    }

	@Test(expected = TakeAwayBillException.class) 
    public void listNulltTest() throws TakeAwayBillException {
        list = null;
        total = bill.getOrderPrice(list,user);
    }

	@Test(expected = TakeAwayBillException.class) 
    public void nullInListTest() throws TakeAwayBillException {
        list.add(new MenuItem(MenuItem.type.Budino,"Pino",3.50));
		list.add(null);
        total = bill.getOrderPrice(list,user);
	}

	@Test
	public void discount50Test() throws TakeAwayBillException {
		list.add(new MenuItem(MenuItem.type.Gelato,"Panna",5.00));
		list.add(new MenuItem(MenuItem.type.Gelato,"MaxiGusto",5.00));
		list.add(new MenuItem(MenuItem.type.Gelato,"GenioBlu",5.00));
		list.add(new MenuItem(MenuItem.type.Gelato,"Amarena",3.00));
		list.add(new MenuItem(MenuItem.type.Gelato,"PizzaPazza",5.00));
		list.add(new MenuItem(MenuItem.type.Gelato,"Armadillo",5.00));
		total = bill.getOrderPrice(list, user);
		assertEquals(26.50,total,Diff);
	}

	@Test
	public void discount10Test() throws TakeAwayBillException {
		list.add(new MenuItem(MenuItem.type.Budino,"Cameo",30.00));
		list.add(new MenuItem(MenuItem.type.Gelato,"BananaSplit",25.00));
		list.add(new MenuItem(MenuItem.type.Bevanda,"7up",5.00));
		total = bill.getOrderPrice(list, user);
		assertEquals(54,total,Diff);
	}

	@Test(expected = TakeAwayBillException.class) 
	public void max30Test() throws TakeAwayBillException {
		for(int i=0; i<32; i++) {
			list.add(new MenuItem(MenuItem.type.Gelato,"BananaSplit",5.00));
		}
		total = bill.getOrderPrice(list,user);
	}

	@Test
	public void plus050Test() throws TakeAwayBillException {
		list.add(new MenuItem(MenuItem.type.Gelato,"BananaSplit",5.00));
		total = bill.getOrderPrice(list, user);
		assertEquals(5.50,total,Diff);
	}

	@Test
	public void freeBillsTest() throws TakeAwayBillException {
		User user = null;
		List<TotalBill> orders = new ArrayList<TotalBill>();
		list.add(new MenuItem(MenuItem.type.Gelato,"BananaSplit",5.00));
		for(int i=0; i<18; i++) {
			user = new User("Gabriele","Filippi",i);
			orders.add(new TotalBill(list,user,LocalTime.of(18, 07, 33),bill.getOrderPrice(list, user)));
		}
		List<TotalBill> free = bill.FreeBills(orders);
		boolean b = false;
		if(free.size()<=10) {
			b = true;
		}	
		assertEquals(true,b);
		for(TotalBill i: free) {
			assertEquals(0.00,i.getPrice(),Diff);
		}
	}
} 