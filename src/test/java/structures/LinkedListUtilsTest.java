package structures;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LinkedListUtilsTest {

    @ParameterizedTest
    @MethodSource("parametersRemoveDups")
    void testRemoveDups(int expectedSizeAfterRemoval, List<Integer> values) {
        //scenario 1
        LinkedList<Integer> list = new LinkedList<Integer>(values);
        assertEquals(4, list.size());

        LinkedListUtils.removeDups(list);
        assertEquals(expectedSizeAfterRemoval, list.size());
    }

    private static Stream<Arguments> parametersRemoveDups() {
        return Stream.of(
                arguments(1, Arrays.asList(3, 3, 3, 3)),
                arguments(3, Arrays.asList(1, 1, 2, 3)),
                arguments(3, Arrays.asList(1, 2, 3, 3)),
                arguments(3, Arrays.asList(1, 1, 2, 3)),
                arguments(4, Arrays.asList(1, 2, 3, 4))
        );
    }

    @ParameterizedTest
    @MethodSource("parametersReverse")
    void testReverse(LinkedList<Integer> expectedLinkedList, LinkedList<Integer> linkedList) {
        LinkedListUtils.reverse(linkedList);

        assertEquals(expectedLinkedList, linkedList);
    }

    private static Stream<Arguments> parametersReverse() {
        return Stream.of(
          arguments(new LinkedList<Integer>(Arrays.asList(1, 2, 3)), new LinkedList<Integer>(Arrays.asList(3, 2, 1))),
          arguments(new LinkedList<Integer>(Arrays.asList(1)), new LinkedList<Integer>(Arrays.asList(1))),
          arguments(new LinkedList<Integer>(Arrays.asList()), new LinkedList<Integer>(Arrays.asList()))
        );
    }
}