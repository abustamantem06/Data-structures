package structures;

/**
 * methods:
 * add
 * - at head
 * - at position
 * - at the end (default)
 * remove
 * - position
 *
 * other methods?
 * @param <T>
 */
public class LinkedList<T> {
    private class Node<T> {
        T value;
        Node<T> next;

        public Node() {}

        public Node(T value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }
    }

    Node<T> head;

    public void add(T elem) {
        Node<T> current = head;
        if (current == null) {
            head = new Node<>(elem);
            return;
        }

        while(current.next != null) {
            current = current.next;
        }

        current.next = new Node<>(elem);
    }

    public T get(int index) throws IndexOutOfBoundsException {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index has to be a positive number");
        }

        int counter = 0;
        Node<T> currentNode = head;
        while(counter < index) {
            currentNode = currentNode.next;
            counter++;
        }
        return currentNode.value;
    }

    @Override
    public String toString() {
        if (head == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder("{");
        sb.append(head.value);

        Node<T> current = head;
        while(current.next != null) {
            sb.append(", ");
            current = current.next;
            sb.append(current.value);
        }

        sb.append("}");
        return sb.toString();
    }
}
