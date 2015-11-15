/**
 * 
 */
package com.pohancenik;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.pohancenik.testcases.ShoppingCartBeanTest;
import com.pohancenik.testcases.SimpleCounterBeanTest;

/**
 * @author pohancenik
 *
 */
@RunWith(Suite.class)
@SuiteClasses({ShoppingCartBeanTest.class, SimpleCounterBeanTest.class })
public class TestsForEjb {

}
