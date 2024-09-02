package dsa.assignment;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestStringUtil {

    private StringUtil stringUtil = new StringUtil();

    @Test
    public void testReverse() {
        assertEquals("cba", stringUtil.reverse("abc"));
        assertEquals("", stringUtil.reverse(""));
        assertNull(stringUtil.reverse(null));
    }

    @Test
    public void testIsEmpty() {
        assertTrue(stringUtil.isEmpty(""));
        assertTrue(stringUtil.isEmpty(null));
        assertFalse(stringUtil.isEmpty("abc"));
    }

    @Test
    public void testConcatenate() {
        assertEquals("HelloWorld", stringUtil.concatenate("Hello", "World"));
        assertEquals("Hello", stringUtil.concatenate("Hello", null));
        assertEquals("World", stringUtil.concatenate(null, "World"));
        assertEquals("", stringUtil.concatenate(null, null));
    }

    @Test
    public void testContains() {
        assertTrue(stringUtil.contains("Hello World", "Hello"));
        assertTrue(stringUtil.contains("Hello World", "World"));
        assertFalse(stringUtil.contains("Hello World", "hello"));
        assertFalse(stringUtil.contains(null, "Hello"));
        assertFalse(stringUtil.contains("Hello World", null));
    }
}