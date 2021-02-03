package structures;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {
    LinkedList<Integer> _list;

    @BeforeEach
    void setup() {
        _list = new LinkedList<>();
        _list.add(0);
        _list.add(1);
        _list.add(3);
    }

    @AfterEach
    void afterEach() {
        _list = null;
    }

    @Test
    void testAdd() {
        assertEquals("{0, 1, 3}", _list.toString());
    }

    @Test
    void testGet() {
        assertEquals(0, _list.get(0));
        assertEquals(1, _list.get(1));
        assertEquals(3, _list.get(2));
    }

    @Test
    void testGetThrowsOutOfBoundsExceptionWhenIndexIsNegative() {
        Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> {
           _list.get(-1);
        });

        System.out.println(exception);
    }
}