package com.example.demo;

import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListRealizationTest {

    ArrayListRealization<String> list = new ArrayListRealization<>();

    @Test
    void get() {
        list.add("A");
        list.add("B");
        list.add("C");

        assertEquals("A", list.get(0));
        assertEquals("B", list.get(1));
        assertEquals("C", list.get(2));
        assertNull(list.get(3));
        assertNull(list.get(-1));
    }

    @Test
    void size() {
        assertEquals(0, list.size());

        list.add("A");
        assertEquals(1, list.size());

        list.add("B");
        list.add("C");
        assertEquals(3, list.size());
    }

    @Test
    void isEmpty() {
        assertTrue(list.isEmpty());

        list.add("A");
        assertFalse(list.isEmpty());
    }

    @Test
    void contains() {
        list.add("A");
        list.add("B");
        list.add("C");

        assertTrue(list.contains("B"));
        assertFalse(list.contains("D"));
    }

    @Test
    void containsAll() {
        list.add("A");
        list.add("B");
        list.add("C");

        assertTrue(list.containsAll(Arrays.asList("A", "B")));
        assertFalse(list.containsAll(Arrays.asList("A", "D")));
    }

    @Test
    void indexOf() {
        list.add("A");
        list.add("B");
        list.add("C");

        assertEquals(1, list.indexOf("B"));
        assertEquals(-1, list.indexOf("D"));
    }

    @Test
    void toArray() {
        list.add("A");
        list.add("B");
        list.add("C");

        Object[] array = list.toArray();
        assertEquals(3, array.length);
        assertArrayEquals(new String[]{"A", "B", "C"}, array);
    }

    //add(Object item)
    @Test
    void add() {
        assertTrue(list.add("A"));
        assertTrue(list.contains("A"));
    }

    //add(int index, Object element)
    @Test
    void testAdd() {
        list.add("A");
        list.add("C");

        list.add(1, "B");
        assertEquals("B", list.get(1));
    }

    @Test
    void addAll() {
        list.add("A");
        list.add("D");

        assertTrue(list.addAll(1, Arrays.asList("B", "C")));
        assertEquals(4, list.size());
        assertArrayEquals(new String[]{"A", "B", "C", "D"}, list.toArray());
    }

    //remove(int index)
    @Test
    void remove() {
        list.add("A");
        list.add("B");
        list.add("C");

        assertEquals("B", list.remove(1));
        assertEquals(2, list.size());
        assertArrayEquals(new String[]{"A", "C"}, list.toArray());
    }

    //remove(Object o)
    @Test
    void testRemove() {
        list.add("A");
        list.add("B");
        list.add("C");

        assertTrue(list.remove("B"));
        assertFalse(list.contains("B"));
    }
}