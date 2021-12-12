package ua.edu.ucu.collections.immutable;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ImmutableArrayListTest{
    private ImmutableArrayList test_arr, test_arr2;
    private Object[] arr =  {1, 2, 3};

    @Test
    public void testTestToString() {
        test_arr = new ImmutableArrayList(arr);
        assertEquals("1 2 3 ", test_arr.toString());
    }


    @Test
    public void testAdd() {
        test_arr = new ImmutableArrayList(arr);
        test_arr2 = (ImmutableArrayList) test_arr.add(4);
        assertEquals("1 2 3 4 ", test_arr2.toString());
        assertEquals("1 2 3 ", test_arr.toString());
        test_arr2 = (ImmutableArrayList) test_arr.add(0, 4);
        assertEquals("4 1 2 3 ", test_arr2.toString());
        assertEquals("1 2 3 ", test_arr.toString());

        test_arr2 = (ImmutableArrayList) test_arr.add(2, 4);
        assertEquals("1 2 4 3 ", test_arr2.toString());
        assertEquals("1 2 3 ", test_arr.toString());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddFail() {
        test_arr = new ImmutableArrayList(arr);
        test_arr2 = (ImmutableArrayList) test_arr.add(100, 4);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddFail2() {
        test_arr = new ImmutableArrayList(arr);
        test_arr2 = (ImmutableArrayList) test_arr.add(-1, 4);
    }

    @Test
    public void testAddAll() {
        test_arr = new ImmutableArrayList(arr);
        test_arr2 = (ImmutableArrayList) test_arr.addAll(arr);
        assertEquals("1 2 3 1 2 3 ", test_arr2.toString());
        assertEquals("1 2 3 ", test_arr.toString());
        test_arr2 = (ImmutableArrayList) test_arr.addAll(0, arr);
        assertEquals("1 2 3 1 2 3 ", test_arr2.toString());
        assertEquals("1 2 3 ", test_arr.toString());

        test_arr2 = (ImmutableArrayList) test_arr.addAll(2, arr);
        assertEquals("1 2 1 2 3 3 ", test_arr2.toString());
        assertEquals("1 2 3 ", test_arr.toString());

        test_arr2 = (ImmutableArrayList) test_arr.addAll(
                0, new Object[] {9, 8, 7, 6, 5, 4, 3, 2, 1});
        assertEquals("9 8 7 6 5 4 3 2 1 1 2 3 ", test_arr2.toString());
        assertEquals("1 2 3 ", test_arr.toString());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAllFail() {
        test_arr = new ImmutableArrayList(arr);
        test_arr2 = (ImmutableArrayList) test_arr.add(100, arr);
    }


    @Test
    public void testGet() {
        test_arr = new ImmutableArrayList(arr);
        assertEquals(1, test_arr.get(0));

        test_arr = new ImmutableArrayList(arr);
        assertEquals(3, test_arr.get(2));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetFail(){
        test_arr = new ImmutableArrayList(arr);
        test_arr.get(100);

    }

    @Test
    public void testRemove() {
        test_arr = new ImmutableArrayList(arr);
        test_arr2 = (ImmutableArrayList) test_arr.remove(0);
        assertEquals("2 3 ", test_arr2.toString());
        assertEquals("1 2 3 ", test_arr.toString());

        test_arr2 = (ImmutableArrayList) test_arr.remove(2);
        assertEquals("1 2 ", test_arr2.toString());
        assertEquals("1 2 3 ", test_arr.toString());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveFail(){
        test_arr = new ImmutableArrayList(arr);
        test_arr.remove(100);

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveFail2(){
        test_arr = new ImmutableArrayList(arr);
        test_arr.remove(-10);

    }

    @Test
    public void testSet() {
        test_arr = new ImmutableArrayList(arr);
        test_arr2 = (ImmutableArrayList) test_arr.set(0, 100);
        assertEquals("100 2 3 ", test_arr2.toString());
        assertEquals("1 2 3 ", test_arr.toString());

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetFail(){
        test_arr = new ImmutableArrayList(arr);
        test_arr.set(100, 100);


    }

    @Test
    public void testIndexOf() {
        test_arr = new ImmutableArrayList(arr);
        assertEquals(0, test_arr.indexOf(1));
        assertEquals(-1, test_arr.indexOf(30));

    }

    @Test
    public void testSize() {
        test_arr = new ImmutableArrayList(arr);
        assertEquals(3, test_arr.size());

    }

    @Test
    public void testClear() {
        test_arr = new ImmutableArrayList(arr);
        test_arr2 = (ImmutableArrayList) test_arr.clear();
        assertEquals(0, test_arr2.size());
        assertEquals(3, test_arr.size());
        assertEquals("1 2 3 ", test_arr.toString());



    }

    @Test
    public void testIsEmpty() {
        test_arr = new ImmutableArrayList(arr);
        assertEquals(false, test_arr.isEmpty());

        test_arr2 = new ImmutableArrayList();
        assertEquals(true, test_arr2.isEmpty());
    }

    @Test
    public void testToArray() {
        test_arr = new ImmutableArrayList(arr);
        Object[] arr2 = test_arr.toArray();
        assertArrayEquals(arr, arr2);
    }


}