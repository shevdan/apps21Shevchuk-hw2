package ua.edu.ucu.collections.immutable;

import org.junit.Test;

import static org.junit.Assert.*;

public class NodeTest {
    private Node node;

    @Test
    public void testToString() {
        node = new Node(1);
        assertEquals("1", node.toString());

        node = new Node();
        assertEquals(null, node.getValue());
    }
}