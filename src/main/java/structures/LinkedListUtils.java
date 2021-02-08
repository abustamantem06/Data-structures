package structures;

public class LinkedListUtils {

    /**
     * Removes duplicated elements in the given LinkedList (mutates)
     * @param <E> list
     */
    public static <E> void removeDups(LinkedList<E> list) {
        if (list._head == null) return;

        LinkedList<E>.Node<E> current = list._head;
        while (current.next != null) {
            if (current.value == current.next.value) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
    }

    /**
     * Reverses the given Linkedlist (mutates)
     * @param <E> list
     */
    public static <E> void reverse(LinkedList<E> list) {
        if (list._head == null || list._head.next == null) {
            return;
        }
        LinkedList<E>.Node<E> second = list._head.next;
        list._head.next = null;
        reverseHelper(list, list._head, second, second.next);
    }

    private static <E> void reverseHelper(LinkedList<E> list, LinkedList<E>.Node<E> a, LinkedList<E>.Node<E> b, LinkedList<E>.Node<E> c) {
        b.next = a;
        LinkedList<E>.Node<E> next = c.next;
        if(next != null) {
            reverseHelper(list, b, c, next);
        } else {
            c.next = b;
            list._head = c;
        }
    }
}
