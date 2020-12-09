package it.unipd.tos.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class MenuItemTest {

	private MenuItem item;
	private static final double Diff = 1e-3;

	@Before
	public void setup() {
		item = new MenuItem(MenuItem.type.Budino,"Cioccolato",4.00);
	}

	@Test
    public void getItemTest() {
        assertEquals(MenuItem.type.Budino, item.getItem());
    }

	@Test
    public void getNameTest() {
        assertEquals("Cioccolato", item.getName());
    }

    @Test
    public void getPriceTest() {
        assertEquals(4.00, item.getPrice(),Diff);
    }

    @Test
    public void negativePriceTest() {
    	boolean neg = true;
		if(item.getPrice()<0)
			neg = false;
		assertEquals(true, neg);
    }

}