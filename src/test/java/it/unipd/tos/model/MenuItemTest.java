package it.unipd.tos.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class MenuItemTest {

	private MenuItem menuitem;
	private static final double Diff = 1e-3;

	@Before
	public void setup() {
		menuitem = new MenuItem(MenuItem.type.Budino,"Cameo",3.50);
	}

	@Test
    public void getItemTypeTest() {
        assertEquals(MenuItem.type.Budino, menuitem.getItemType());
    }

	@Test
    public void getNameTest() {
        assertEquals("Cameo", menuitem.getName());
    }

    @Test
    public void getPriceTest() {
        assertEquals(3.50, menuitem.getPrice(),Diff);
    }

    @Test
    public void negativePriceTest() {
    	boolean b = true;
		if(menuitem.getPrice()<0)
			b = false;
		assertEquals(true, b);
    }

} 