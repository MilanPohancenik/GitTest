/**
 * 
 */
package com.pohancenik.testcases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import javax.naming.Context;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.pohancenik.remote.ShoppingCart;
import com.pohancenik.remote.exception.DuplicateItemException;
import com.pohancenik.remote.exception.NotExistingItemException;
import com.pohancenik.util.ContextUtil;

/**
 * @author pohancenik
 *
 */
public class ShoppingCartBeanTest {

	private static Context context;
	
	private static ShoppingCart cart;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ContextUtil().prepareContext();
		cart = (ShoppingCart) context.lookup( "first-test-app/first-test-module2/ShoppingCartBean!com.pohancenik.module2.ShoppingCart" );
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		cart.remove();
		cart = null;
		context = null;
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		cart.addItem("Item-book-2-duplicate");
		cart.addItem("Item-to-remove");
		cart.addItem("Existing-item");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		cart.clear();
	}

	@Test
	public void testAdd1() throws DuplicateItemException, NotExistingItemException {
		cart.addItem("Item-book-1");
		assertEquals(cart.get("Item-book-1"), "Item-book-1");
	}

	@Test
	public void testAdd2() throws DuplicateItemException, NotExistingItemException {
		cart.addItem("Item-book-2");
		assertEquals(cart.get("Item-book-2"), "Item-book-2");
	}
	
	@Test( expected = DuplicateItemException.class)
	public void testAdd3() throws DuplicateItemException {
		cart.addItem("Item-book-2-duplicate");
	}
	
	@Test( expected = NotExistingItemException.class )
	public void testRemove1() throws NotExistingItemException {
		int sizeBeforeRemove = cart.getContent().size();
		cart.removeItem("Item-to-remove");
		int sizeAfterRemove = cart.getContent().size();
		assertEquals(sizeBeforeRemove-1, sizeAfterRemove);
		cart.get("Item-to-remove");
	}
	
	@Test( expected = NotExistingItemException.class )
	public void testRemove2() throws NotExistingItemException {
		cart.removeItem("Not-existing-item");
	}
	
	@Test
	public void testGet1() throws NotExistingItemException {
		String id = cart.get("Existing-item");
		assertEquals(id, "Existing-item");
	}
	
	@Test( expected = NotExistingItemException.class )
	public void testGet2() throws NotExistingItemException {
		cart.get("Not-existing-item");
	}
	
	@Test
	public void testClear() {
		assertTrue(cart.getContent().size() > 0);
		cart.clear();
		assertEquals(cart.getContent().size(), 0);
	}
}
