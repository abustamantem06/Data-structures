package structures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListUtilsTest {

    @Test
    void testRemoveDups() {
        //scenario 1
        LinkedList<Integer> list = new LinkedList<>(1, 1, 2, 3);
        assertEquals(4, list.size());

        LinkedListUtils.removeDups(list);
        assertEquals(3, list.size());

        //scenario 2
        LinkedList<Integer> list2 = new LinkedList<>(0, 1, 1, 3);
        assertEquals(4, list2.size());

        LinkedListUtils.removeDups(list2);
        assertEquals(3, list2.size());

        //scenario 3
        LinkedList<Integer> list3 = new LinkedList<>(1, 2, 3, 3);
        assertEquals(4, list3.size());

        LinkedListUtils.removeDups(list3);
        assertEquals(3, list3.size());

        //scenario 4
        LinkedList<Integer> list4 = new LinkedList<>(3, 3, 3, 3);
        assertEquals(4, list4.size());

        LinkedListUtils.removeDups(list4);
        assertEquals(1, list4.size());

        //scenario 5
        LinkedList<Integer> list5 = new LinkedList<>(1, 2, 3, 4);
        assertEquals(4, list5.size());

        LinkedListUtils.removeDups(list5);
        assertEquals(4, list5.size());


    }
}