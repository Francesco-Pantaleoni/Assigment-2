package it.unipd.tos.business;

import static org.junit.Assert.assertEquals;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalTime;

import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.User;

import org.junit.Before;
import org.junit.Test;

public class TotalBillTest {

	private TotalBill totalbill;
	private List<MenuItem> list;
	private User user; 
	private static final double Diff = 1e-3;

	@Before
	public void setup() {
		user = new User("Gabriele","Filippi",21);
		list = new ArrayList<MenuItem>();
		totalbill = new TotalBill(list,user,LocalTime.of(18, 07, 33),3.50);
		list.add(new MenuItem(MenuItem.type.Budino,"Pino",3.50));
	}

	@Test
    public void getListTest() {
		assertEquals(list, totalbill.getList());
    }

    @Test
    public void getUserTest() {
        assertEquals(user, totalbill.getUser());
    }

    @Test
    public void getTimeTest() {
    	int second = (18*60*60) + (7*60) + 33;
        assertEquals(second,totalbill.getTime());
    }

    @Test
    public void getPriceTest() {
        assertEquals(3.50,totalbill.getPrice(),Diff);
    }
} 