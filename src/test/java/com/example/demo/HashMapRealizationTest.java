package com.example.demo;

import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class HashMapRealizationTest {

    private HashMapRealization<String, Integer> hashMap;

    @BeforeEach
    public void setUp() {
        hashMap = new HashMapRealization<>(16, 0.75f);
    }

    @Test
    void put() {
        hashMap.put("key1", 1);
        hashMap.put("key2", 2);

        assertEquals(1, hashMap.get("key1"));
        assertEquals(2, hashMap.get("key2"));
    }

    @Test
    void putDuplicateKey() {
        hashMap.put("key1", 1);
        hashMap.put("key1", 2);

        assertEquals(2, hashMap.get("key1"));
    }

    @Test
    void getNonExistingKey() {
        assertNull(hashMap.get("nonExistingKey"));
    }

    @Test
    void containsValue() {
        hashMap.put("key1", 1);
        hashMap.put("key2", 2);

        assertTrue(hashMap.containsValue(1));
        assertTrue(hashMap.containsValue(2));
        assertFalse(hashMap.containsValue(3));
    }

    @Test
    void getKeysByValue() {
        hashMap.put("key1", 1);
        hashMap.put("key2", 2);
        hashMap.put("key3", 1);

        List<String> keysForValue1 = hashMap.getKeysByValue(1);
        List<String> keysForValue2 = hashMap.getKeysByValue(2);

        assertEquals(Arrays.asList("key1", "key3"), keysForValue1);
        assertEquals(Collections.singletonList("key2"), keysForValue2);
    }

    @Test
    void putAllByKey() {
        Map<String, Integer> map = new HashMap<>();
        map.put("key1", 1);
        map.put("key2", 2);

        hashMap.putAllByKey(map);

        assertEquals(1, hashMap.get("key1"));
        assertEquals(2, hashMap.get("key2"));
    }

    @Test
    void putAllByValue() {
        Collection<Integer> values = Arrays.asList(1, 2);

        hashMap.putAllByValue("key", values);

        assertEquals(2, hashMap.get("key"));
    }

    @Test
    void remove() {
        hashMap.put("key1", 1);
        hashMap.put("key2", 2);

        hashMap.remove("key1");

        assertEquals(1, hashMap.size());
        assertNull(hashMap.get("key1"));
    }

    @Test
    void size() {
        assertEquals(0, hashMap.size());

        hashMap.put("key1", 1);
        hashMap.put("key2", 2);

        assertEquals(2, hashMap.size());
    }

    @Test
    void isEmpty() {
        assertTrue(hashMap.isEmpty());

        hashMap.put("key1", 1);

        assertFalse(hashMap.isEmpty());
    }
}