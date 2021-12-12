package ua.edu.ucu.collections;

import org.junit.Before;
import org.junit.Test;

import java.util.EmptyStackException;

import static org.junit.Assert.*;

public class QueueTest {
    Queue queue;
    @Before
    public void setUp() {
        queue = new Queue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
    }

    @Test
    public void testPeek() {
        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.dequeue());
        assertEquals(3, queue.dequeue());
    }

    @Test(expected = EmptyStackException.class)
    public void testPeekFail() {
        queue = new Queue();
        queue.peek();
    }

    @Test
    public void testDequeue() {
        assertEquals(1, queue.peek());
    }

    @Test(expected = EmptyStackException.class)
    public void testDequeueFail() {
        queue = new Queue();
        queue.dequeue();
    }

}
