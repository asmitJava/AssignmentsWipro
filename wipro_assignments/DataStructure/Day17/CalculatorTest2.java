package dsa.assignment;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest2 {

    private static Calculator calculator;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        
        calculator = new Calculator();
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        
        calculator = null;
    }

    @Before
    public void setUp() throws Exception {
        
        System.out.println("Setting up for test...");
    }

    @After
    public void tearDown() throws Exception {
     
        System.out.println("Tearing down after test...");
    }

    @Test
    public void testAdd() {
        assertEquals(5, calculator.add(2, 3));
        assertEquals(-1, calculator.add(-2, 1));
        assertEquals(0, calculator.add(0, 0));
    }

    @Test
    public void testSubtract() {
        assertEquals(1, calculator.subtract(3, 2));
        assertEquals(-3, calculator.subtract(0, 3));
        assertEquals(5, calculator.subtract(10, 5));
    }

    @Test
    public void testMultiply() {
        assertEquals(6, calculator.multiply(2, 3));
        assertEquals(0, calculator.multiply(5, 0));
        assertEquals(-15, calculator.multiply(3, -5));
    }

    @Test
    public void testDivide() {
        assertEquals(3, calculator.divide(9, 3));
        assertEquals(0, calculator.divide(0, 5));
       
        try {
            calculator.divide(5, 0);
            fail("Expected ArithmeticException to be thrown");
        } catch (ArithmeticException e) {
         
        }
    }
}
