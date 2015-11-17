/**
 * 
 */
package com.pohancenik.testcases;

import static org.junit.Assert.assertEquals;

import javax.naming.Context;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.pohancenik.remote.Counter;
import com.pohancenik.util.ContextUtil;

/**
 * @author pohancenik
 *
 */
public class SimpleCounterBeanTest {

	private static Context context;
	
	private static Counter counter;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ContextUtil().prepareContext();
		counter = (Counter) context.lookup( "first-test-app/first-test-module2/SingletonSimpleCounterBean!com.pohancenik.module2.Counter" );
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		counter = null;
		context = null;
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testIncrement() {
		long valueBefore = counter.value();
		counter.increment();
		long valueAfter = counter.value();
		assertEquals(valueBefore+1L, valueAfter);
	}
	
	public void testReset() {
		counter.reset();
		assertEquals(counter.value(), 0L);
	}

}
