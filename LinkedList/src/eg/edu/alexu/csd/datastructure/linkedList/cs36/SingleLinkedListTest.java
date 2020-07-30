package eg.edu.alexu.csd.datastructure.linkedList.cs36;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SingleLinkedListTest {

    /**
     * test of add.
     */
    @Test
    public void add() {
        ILinkedList instance = (ILinkedList) new SingleLinkedList();
        instance.add(1);
        instance.add('3');
        instance.add("5");
        instance.set(1, 'F');
        assertEquals('F', instance.get(1));
    }
    /**
     * test of add in invalid index.
     */
    @Test
    public void TestSetError() {
        ILinkedList instance = (ILinkedList) new SingleLinkedList();
        try {
            instance.add(1);
            instance.set(2, 'F');
            fail("You should throw an "
                    + "exception when trying "
                    + "to set in a wrong index");
        } catch (RuntimeException f) {
            System.out.print("index must be "
                    + "in litter than size");
        }
    }




    @Test
    public void clear() {
        ILinkedList c = (ILinkedList) new SingleLinkedList();
        c.add(0, '3');
        c.add(1, '7');
        c.clear();
        assertTrue(c.isEmpty());
    }

    @Test
    public void isEmpty() {
        ILinkedList c = (ILinkedList) new SingleLinkedList();
        c.add(0, '3');
        c.add(1, '7');
        assertFalse(c.isEmpty());
    }

    @Test
    public void remove() {
        ILinkedList c = (ILinkedList) new SingleLinkedList();
        c.add(0, '3');
        c.add(1, '7');
        c.set(1, '5');
        ILinkedList d = (ILinkedList) new SingleLinkedList();
        d.add('3');
        d.add('5');
        for (int i = 0; i < 2; i++) {
            assertEquals(c.get(i), d.get(i));
        }
    }

    /**
     * test of size and contain.
     */
    @Test
    public void size() {
        final ILinkedList object = (ILinkedList) new SingleLinkedList();
        object.add(0, '0');
        object.add(1, "1"); // line 365
        object.add(2, 2);
        object.remove(1);
        assertEquals(2, object.get(1));
    }
    /**
     * test of size.
     */
    @Test
    public void TestSizeContains1() {
        ILinkedList test = (ILinkedList) new SingleLinkedList();
        final int x = 10;
        for (int i = 0; i < x; ++i) {
            test.add(i);
        }
        test.add("1000000");
        assertEquals(x + 1, test.size());
        assertEquals(true, test.contains("1000000"));
        assertEquals(true, test.contains(1));
    }
    @Test
    public void sublist() {
        ILinkedList instance = (ILinkedList) new SingleLinkedList();
        instance.add('a');
        instance.add('b');
        instance.add('c');
        instance.add('d');
        ILinkedList temp = instance.sublist(1, 2);
        assertEquals(temp.get(0), instance.get(1));
        assertEquals(temp.get(1), instance.get(2));
    }

    /**
     * test of contain.
     */

    @Test
    public void contains() {
        ILinkedList c = (ILinkedList) new SingleLinkedList();
        for (int i = 0; i <= 2; i++) {
            c.add(i);
        }
        c.add(0, 2);
        c.add(2, '4');
        assertTrue(c.contains('4'));
        assertTrue(c.contains(0));
        assertTrue(c.contains(1));
        assertTrue(c.contains(2));
        assertTrue(c.contains(2));
        assertFalse(c.contains('9'));
        assertFalse(c.contains("19"));
    }
}