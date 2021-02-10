package structures;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {
    LinkedList<Integer> _list;

    @BeforeEach
    void setup() {
        _list = new LinkedList<>(Arrays.asList(0, 1, 2));
    }

    @AfterEach
    void afterEach() {
        _list = null;
    }

    @Test
    void testAdd() {
        assertEquals("{0, 1, 2}", _list.toString());
        assertEquals(3, _list.size());
        assertEquals(0, _list.get(0));
        assertEquals(1, _list.get(1));
        assertEquals(2, _list.get(2));
    }

    @Test
    void testGet() {
        assertEquals(3, _list.size());
        assertEquals(0, _list.get(0));
        assertEquals(1, _list.get(1));
        assertEquals(2, _list.get(2));
    }

    @Test
    void testGetThrowsOutOfBoundsExceptionWhenIndexIsOutOfRange() {
        Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            _list.get(100);
        });

        assertEquals("Index [100] out of bounds, size: 2", exception.getMessage());
    }

    @Test
    void testGetThrowsOutOfBoundsExceptionWhenIndexIsNegative() {
        Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> {
           _list.get(-1);
        });

        assertEquals("Index [-1] has to be a positive number", exception.getMessage());
    }

    @Test
    void testRemove() {
        assertEquals(3, _list.size());
        assertEquals(1, _list.get(1));
        _list.remove(1);
        assertEquals(2, _list.size());
        assertEquals(2, _list.get(1));
    }

    @Test
    void testRemoveThrowsOutOfBoundsExceptionWhenIndexIsOutOfRange() {
        Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            _list.remove(100);
        });

        assertEquals("Index [100] out of bounds, size: 3", exception.getMessage());
    }
}