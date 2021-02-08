package structures;

import java.util.stream.Stream;

public class LinkedList<E>{
    public LinkedList(E... elems) {
        Stream.of(elems).forEach(e -> add(e));
    }

    protected class Node<E> {
        E value;
        Node<E> next;

        public Node() {}

        public Node(E value) {
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

    Node<E> _head;

    /**
     * adds given element {E elem}
     * time completexity: O(n)
     * space complexity: O(1)
     * @param elem
     */
    public void add(E elem) {
        Node<E> current = _head;
        if (current == null) {
            _head = new Node<>(elem);
            return;
        }

        while(current.next != null) {
            current = current.next;
        }

        current.next = new Node<>(elem);
    }

    /**
     * returns element in the {index} position
     * time completexity: O(n)
     * space complexity: O(1)
     * @param index
     * @return
     */
    public E get(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException(String.format("Index [%s] has to be a positive number", index));
        }

        int counter = 0;
        Node<E> currentNode = _head;
        while(counter < index) {
            if (currentNode.next == null) {
                throw new IndexOutOfBoundsException(String.format("Index [%s] out of bounds, size: %d", index, counter));
            }
            currentNode = currentNode.next;
            counter++;
        }
        return currentNode.value;
    }

    /**
     * removes element in the {index} position
     * time completexity: O(n)
     * space complexity: O(1)
     * @param index
     */
    public void remove(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException(String.format("Index [%s] has to be a positive number", index));
        }

        if (index == 0) {
            _head = _head.next;
        }

        int counter = 1;
        Node<E> currentNode = _head;
        while (counter < index) {
            if (currentNode.next == null) {
                throw new IndexOutOfBoundsException(String.format("Index [%s] out of bounds, size: %d", index, counter));
            }
            currentNode = currentNode.next;
            counter++;
        }

        if (currentNode.next == null) {
            throw new IndexOutOfBoundsException(String.format("Index [%s] out of bounds, size: %d", index, counter));
        }
        currentNode.next = currentNode.next.next;
    }

    public int size() {
        int counter = 0;
        Node<E> currentNode = _head;
        while(currentNode != null) {
            counter++;
            currentNode = currentNode.next;
        }
        return counter;
    }

    @Override
    public String toString() {
        if (_head == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder("{");
        sb.append(_head.value);

        Node<E> current = _head;
        while(current.next != null) {
            sb.append(", ");
            current = current.next;
            sb.append(current.value);
        }

        sb.append("}");
        return sb.toString();
    }
}
