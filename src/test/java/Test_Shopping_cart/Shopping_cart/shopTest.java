package Test_Shopping_cart.Shopping_cart;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class shopTest {

	private static ShoppingCart shoppingCart;
	private static Product product;
	private static ProductNotFoundException pr;

	@BeforeEach
	public void init() {
		shoppingCart=new ShoppingCart();
		product = new Product("pro",2.2);
	}
	
	@Test
	public void vacio() {
		assertEquals(0,new ShoppingCart().getItemCount());
		shoppingCart.empty();
		assertEquals(0,shoppingCart.getItemCount());
	}
	
	@Test
	public void aumento() {
		shoppingCart.addItem(product);
		assertTrue(shoppingCart.getItemCount()>0);
		double bal=0;
		bal+= shoppingCart.getBalance();
		assertTrue(bal==shoppingCart.getBalance());
	}
	
	@Test
	public void elimina() throws ProductNotFoundException {
		shoppingCart.addItem(product);
		int nu=shoppingCart.getItemCount();
		shoppingCart.removeItem(product);
		assertTrue(nu>shoppingCart.getItemCount());

	}
	
	@Test
	public void excepcion() {
		try {
			shoppingCart.removeItem(product);
			fail("Se esperaba una excepción ProductNotFoundException");
			
		} catch (ProductNotFoundException e) {

		}

	}

}
