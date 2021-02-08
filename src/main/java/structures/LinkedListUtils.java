package structures;

public class LinkedListUtils {

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
}
