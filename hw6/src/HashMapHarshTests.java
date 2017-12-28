import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.NoSuchElementException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import java.util.Set;

/**
 * @author Harsh Gupta
 * @version 1.0
 */
public class HashMapHarshTests {

    private HashMap2<String, Integer> directory;
    private static final int TIMEOUT = 200;

    @Before
    public void setUp() {
        directory = new HashMap2<>();
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testput() {
        directory.put("a",1);
        assertEquals(1,directory.size());
        putStuff();
        assertEquals(9,directory.size());
        putStuff();
        assertEquals(9, directory.size());
        directory.put("a",32);
        assertEquals(9, directory.size());
        directory.put("123", null);
    }


    @Test(timeout = TIMEOUT, expected = NoSuchElementException.class)
    public void testRemove() {
        putStuff();
        Object t = 1;
        assertEquals(t, directory.remove(new String("1")));
        assertFalse(directory.containsKey(new String("1")));
        assertEquals(7, directory.size());
        directory.remove(new String("1"));
    }

    @Test(timeout = TIMEOUT, expected = NoSuchElementException.class)
    public void testGet() {
        putStuff();
        Object t = 1;
        assertEquals(java.util.Optional.of(1), java.util.Optional.ofNullable(directory.get(new String("1"))));
        directory.remove("1");
        directory.get("1");

    }
    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testResize(){
        assertEquals(directory.getTable().length,13);
        directory.put("a",1);
        assertEquals(1,directory.size());
        directory.resizeBackingTable(20);
        assertEquals(directory.getTable().length,20);
        assertEquals(1,directory.size());
        directory.put("v",2);
        directory.resizeBackingTable(1);
    }


    @Test(timeout = TIMEOUT)
    public void testContainsKey() {
        directory.put(new String("a"),1);
        assertTrue(directory.containsKey(new String("a")));
        directory.remove("a");
        assertTrue(!directory.containsKey("a"));
    }

    /**
     * Put a baseline of items to the hash map.
     */
    public void putStuff() {
        for (int x = 0; x<8;x++){
            String name = String.valueOf(x);
            directory.put(name, x);
        }
    }
}
